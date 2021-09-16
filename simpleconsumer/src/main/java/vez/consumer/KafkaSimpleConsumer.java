package vez.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import vez.property.KafkaProperties;

import java.time.Duration;
import java.util.Collections;
import java.util.Random;

public class KafkaSimpleConsumer {

    private static final int CONSUMER_INTERVAL_MILLS = 3_000;

    public static void main(String[] args) throws InterruptedException {

        //Create a Consumer with properties for consumer
        KafkaConsumer<String, String> simpleConsumer = new KafkaConsumer<>( KafkaProperties.newConsumerProps() );

        //Subscribe to the kafka.learning.orders topic
        simpleConsumer.subscribe(Collections.singletonList( KafkaProperties.TOPIC_NAME ));

        Random rnd = new Random();

        //Continuously poll for new messages
        while(true) {

            //Poll with timeout of 100 milli seconds
            ConsumerRecords<String, String> messages = simpleConsumer.poll(Duration.ofMillis(100));

            //Print batch of records consumed
            for (ConsumerRecord<String, String> message : messages) {
                System.out.println("Message fetched : " + message);
                Thread.sleep(rnd.nextInt(CONSUMER_INTERVAL_MILLS)+10);
            }
        }

    }

}
