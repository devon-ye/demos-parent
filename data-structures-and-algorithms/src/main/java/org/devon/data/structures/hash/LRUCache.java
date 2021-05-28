package org.devon.data.structures.hash;


import org.w3c.dom.Node;

/**
 * @author: devon.ye@foxmail.com
 * @datetime: 2021/2/13 8:09 PM
 */
class LRUCache<K, V> {

    private int capacity;
    private Node<K, V>[] table;

    private static final Integer MAX_CAPACITY = Integer.MAX_VALUE;
    private static final Integer DEFAULT_INITIAL_CAPACITY = 16;

    public LRUCache(int capacity) {
        this.capacity = capacity;

    }

    public V get(K key) {
       return null;
    }

    public Node getNode(K key, int hash) {
       return null;
    }

    public V putVal(K key, V value) {
        return putVal(hash(key), key, value);
    }

    public V putVal(int hash, K key, V value) {
        Node<K, V>[] t;
        Node p;
        int i, n;
        if ((t = table) == null || (n = t.length) == 0) {
            t = resize();
        } else if ((p =table[i = n - 1 & hash]) == null) {
            table[i] = new Node<>(hash, key, value);
        } else {
            Node<K,V> e;
            K k;
           if((p.hash==hash && p.key==key) || (key!=null && key.equals(p.key))){
               e = p;
           }else {
               // 遍历链表的同时 统计链表深度 准备转换红黑树
               for (int binCount = 0; ; ++binCount) {
                   if ((e = p.next) == null) {
                       p.next = new Node(hash, key, value, null);
                       //TODO FOR REDBLACK TREE
//                       if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
//                           treeifyBin(tab, hash);
                       break;
                   }
                   if (e.hash == hash &&
                           ((k = e.key) == key || (key != null && key.equals(k))))
                       break;
                   p = e;
               }
           }
           if(e != null){
               V oldValue = e.value;
               if(oldValue== null){
                   e.value = value;
               }
           }
        }

        return value;
    }


    private int hash(K key) {
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private Node<K, V>[] resize() {
        Node<K, V>[] oldTable = table;
        int newCap = 0;
        int oldCap = oldTable == null ? 0 : oldTable.length;

        if (oldCap > 0) {
            if (oldCap >= MAX_CAPACITY) {
                return oldTable;
            } else if ((newCap = oldCap >> 1) < MAX_CAPACITY && oldCap > DEFAULT_INITIAL_CAPACITY) {
                newCap = oldCap >> 1;
            } else {

            }
        }

        Node<K, V>[] newTable = (Node<K, V>[]) new Node[newCap];
        table = newTable;
        if (oldTable != null) {
            for (int i = 0; i < oldCap; i++) {
                Node<K, V> e;
                if ((e = oldTable[i]) != null) {
                    oldTable[i] = null;
                    if (e.next == null) {
                        newTable[e.hash & (newCap - 1)] = e;
                    } else {
                        // preserve order
                        Node<K, V> loHead = null, loTail = null;
                        Node<K, V> hiHead = null, hiTail = null;
                        Node<K, V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            } else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTable[i] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTable[i + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTable;
    }


    class Node<K, V> {
        int hash;
        K key;
        V value;
        Node pre;
        Node next;

        public Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }

        public Node(int hash, K key, V value, Node next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }
}


