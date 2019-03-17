package org.devon.middleware.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author dewen.ye
 * @date 2019/3/16 13:26
 */
public class KafkaConsumerV111 {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers","localhost:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
        KafkaConsumer<String, byte[]> consumer = new KafkaConsumer<String,byte[]>(props);
        consumer.subscribe(Arrays.asList("test.topic"));
        while (true) {
            ConsumerRecords<String, byte[]> records = consumer.poll(100);
            for (ConsumerRecord<String, byte[]> record : records) {
                byte[] bytes =record.value();
                String value = new String(record.value(), Charset.forName("UTF-8"));
                System.out.println("value:["+value+"]");
                System.out.println("#####");
                for (byte aByte : bytes) {
                    byte[] temp = new byte[1];
                    temp[0]=aByte;
                    System.out.printf("@"+new String(temp,Charset.forName("UTF-8")) +"#"+aByte);
                }
                System.out.println("valueChar:[");
                for (byte aByte : bytes) {
                    byte[] temp = new byte[1];
                    temp[0]=aByte;
                    System.out.printf(new String(temp,Charset.forName("UTF-8")) +"\t");
                }
                System.out.println("]");
                System.out.println("bytes:[");
                for (byte aByte : bytes) {
                    System.out.printf(aByte+"\t");
                }
                System.out.println("]");
                System.out.println();
            }
        }
    }
}
