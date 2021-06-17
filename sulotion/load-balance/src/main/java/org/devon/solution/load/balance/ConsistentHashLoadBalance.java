package org.devon.solution.load.balance;


import org.devon.solution.load.balance.request.Request;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author: devon.ye@foxmail.com
 * @datetime: 2020/11/2 4:40 PM
 */
public class ConsistentHashLoadBalance implements LoadBalance {

    private static final String NAME = "consistentHash";

    //<serverName,Selector>
    private Map<String, ConsistentHashSelector> selectorMap = new ConcurrentHashMap<>();
    private static final int DEFAULT_NUMBER_REPLICAS = 160;




    @Override
    public <T> T select(List<T> invokers, Request request) {
        String serverName=request.serverUniqueName();
        ConsistentHashSelector consistentHashSelector = selectorMap.get(request.serverUniqueName());
        int serverContextsHashCode = invokers.hashCode();
        if (consistentHashSelector == null || serverContextsHashCode != consistentHashSelector.identityHashCode) {
            selectorMap.put(serverName, new ConsistentHashSelector(DEFAULT_NUMBER_REPLICAS, invokers, serverContextsHashCode));
            consistentHashSelector = selectorMap.get(serverName);
        }
        return consistentHashSelector.doSelect(Arrays.toString(request.args()));
    }

    @Override
    public String name() {
        return NAME;
    }


    private static final class ConsistentHashSelector<T> {
        private HashFunction hashFunction;
        private final int numberOfReplicas;
        private final int identityHashCode;
        private final SortedMap<Integer, T> circle = new TreeMap<>();

        public ConsistentHashSelector(int numberOfReplicas, Collection<T> serverContexts, int identityHashCode) {
            this.hashFunction = new Md5HashFunction();
            this.numberOfReplicas = numberOfReplicas;
            this.identityHashCode = identityHashCode;
            for (T serverContext : serverContexts) {
                for (int i = 0; i < numberOfReplicas; i++) {
                    circle.put(hashFunction.hash(serverContext.getInstanceId() + "" + i), serverContext);
                }
            }
        }


        public void add(T node) {
            for (int i = 0; i < numberOfReplicas; i++) {
                circle.put(hashFunction.hash(node.getInstanceId() + "_" + i), node);
            }
        }

        public void remove(T node) {
            for (int i = 0; i < numberOfReplicas; i++) {
                circle.remove(hashFunction.hash(node.getInstanceId() + "_" + i));
            }
        }

        public <T>T doSelect(String key) {
            if (circle.isEmpty()) {
                return null;
            }
            int hash = hashFunction.hash(key);
            if (!circle.containsKey(hash)) {
                SortedMap<Integer, T> tailMap = circle.tailMap(hash);
                hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
            }
            return circle.get(hash);
        }

    }


    interface HashFunction {
        int hash(String str);
    }

    static class Md5HashFunction implements HashFunction {
        private static final Charset UTF8 = Charset.forName("UTF-8");

        @Override
        public int hash(String str) {
            byte[] hash = MessageDigests.md5().digest(str.toString().getBytes(UTF8));
            int h0 = (hash[0] & 0xFF);
            int h1 = (hash[1] & 0xFF) << 8;
            int h2 = (hash[2] & 0xFF) << 16;
            int h3 = (hash[3] & 0xFF) << 24;

            return h0 + h1 + h2 + h3;
        }
    }

    static class MessageDigests {
        /**
         * MD5
         */
        private static final ThreadLocal<MessageDigest> MD5_DIGEST = createThreadLocalMessageDigest("MD5");
        /**
         * SHA_1
         */
        private static final ThreadLocal<MessageDigest> SHA_1_DIGEST = createThreadLocalMessageDigest("SHA-1");
        /**
         * SHA_256
         */
        private static final ThreadLocal<MessageDigest> SHA_256_DIGEST = createThreadLocalMessageDigest("SHA-256");
        /**
         *
         */
        private static final char[] HEX_DIGITS = "0123456789abcdef".toCharArray();


        private static ThreadLocal<MessageDigest> createThreadLocalMessageDigest(final String digest) {
            return ThreadLocal.withInitial(() -> {
                try {
                    return MessageDigest.getInstance(digest);
                } catch (NoSuchAlgorithmException e) {
                    throw new IllegalStateException("unexpected exception creating MessageDigest instance for [" + digest + "]", e);
                }
            });
        }

        /**
         * @return thread local MD5 {@link MessageDigest} instance
         */
        public static MessageDigest md5() {
            return get(MD5_DIGEST);
        }

        /**
         * @return a thread local SHA_1 {@link MessageDigest} instance
         */
        public static MessageDigest sha1() {
            return get(SHA_1_DIGEST);
        }

        /**
         * @return a thread local SHA_256 {@link MessageDigest} instance
         */
        public static MessageDigest sha256() {
            return get(SHA_256_DIGEST);
        }

        /**
         * get and reset thread local {@link MessageDigest} instance
         *
         * @param messageDigest threadLocalMessageDigest
         * @return a thread local {@link MessageDigest} instance
         */
        private static MessageDigest get(ThreadLocal<MessageDigest> messageDigest) {
            MessageDigest instance = messageDigest.get();
            instance.reset();
            return instance;
        }

        /**
         * Format a byte array as a hex string.
         *
         * @param bytes the input to be represented as hex.
         * @return a hex representation of the input as a String.
         */
        public static String toHexString(byte[] bytes) {
            StringBuilder sb = new StringBuilder(2 * bytes.length);

            for (byte b : bytes) {
                sb.append(HEX_DIGITS[b >> 4 & 0xf]).append(HEX_DIGITS[b & 0xf]);
            }

            return sb.toString();
        }
    }

}
