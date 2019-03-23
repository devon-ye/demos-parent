package org.devon.middleware.kafka.consumer;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.serializer.StringDecoder;
import kafka.utils.VerifiableProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author dewen.ye
 * @date 2019/3/15 19:52
 */

public class KafkaConsumerV080 {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumerV080.class);

    private static kafka.javaapi.consumer.ConsumerConnector consumer;


    public static void main(String[] args) {
        ConsumerConfig config = new ConsumerConfig(init());

        consumer = kafka.consumer.Consumer.createJavaConsumerConnector(config);
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put("test.topic", new Integer(1));
        StringDecoder keyDecoder = new StringDecoder(new VerifiableProperties());
        StringDecoder valueDecoder = new StringDecoder(new VerifiableProperties());
        Map<String, List<KafkaStream<String, String>>> consumerMap = consumer.createMessageStreams(topicCountMap, keyDecoder, valueDecoder);
        KafkaStream<String, String> stream = consumerMap.get("test.topic").get(0);
        ConsumerIterator<String, String> it = stream.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().message());
        }

    }

    public static Properties init() {
        Properties props = new Properties();
        props.put("zookeeper.connect", "localhost:2181");
        props.put("bootstrap.servers", "localhost:9092");
        props.put("consumer.topic", "tc.qtracer.sqlspan");
        props.put("group.id", "test-group");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("client.id", "test");
        props.put("max.partition.fetch.bytes", 4 * 1024 * 1024);
        props.put("partition.assignment.strategy", "range");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
        return props;
    }
}
