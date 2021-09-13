package vez.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import vez.property.KafkaProperties;

import java.time.Duration;
import java.util.Collections;

public class KafkaSimpleConsumer {

    public static void main(String[] args) {

        //Create a Consumer with properties for consumer
        KafkaConsumer<String, String> simpleConsumer = new KafkaConsumer<>( KafkaProperties.newKafkaProperties() );

        //Subscribe to the kafka.learning.orders topic
        simpleConsumer.subscribe(Collections.singletonList("kafka.learning.orders"));

        //Continuously poll for new messages
        while(true) {

            //Poll with timeout of 100 milli seconds
            ConsumerRecords<String, String> messages = simpleConsumer.poll(Duration.ofMillis(100));

            //Print batch of records consumed
            for (ConsumerRecord<String, String> message : messages)
                System.out.println("Message fetched : " + message);
        }

    }

}
