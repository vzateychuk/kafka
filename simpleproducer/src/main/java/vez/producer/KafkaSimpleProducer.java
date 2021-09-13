package vez.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import vez.property.KafkaProperties;

import java.util.Random;

public class KafkaSimpleProducer {

    private static final long INTERVAL_MILLS = 10;

    public static void main(String[] args) {

        //Create a Kafka producer from configuration
        KafkaProducer simpleProducer = new KafkaProducer( KafkaProperties.newKafkaProperties() );

        //Publish 10 messages with intervals, and a random key
        try{

            int startKey = (new Random()).nextInt(10_000) ;

            for( int i=startKey; i < startKey + 10; i++) {
                //Create a producer Record
                ProducerRecord<String, String> kafkaRecord =
                        new ProducerRecord<String, String>(
                                "kafka.learning.orders",   //Topic name
                                String.valueOf(i),              //Key for the message
                                "This is order" + i       //Message Content
                        );
                System.out.println("Sending Message : "+ kafkaRecord);
                //Publish to Kafka
                simpleProducer.send(kafkaRecord);
                Thread.sleep(INTERVAL_MILLS);
            }
        } catch(Exception e) {
            System.out.println("Exception when sending Message: "+ e);
        } finally {
            simpleProducer.close();
        }
    }

}