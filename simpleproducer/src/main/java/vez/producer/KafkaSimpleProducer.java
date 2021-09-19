package vez.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import vez.property.KafkaProperties;

import java.util.Random;

public class KafkaSimpleProducer {

    private static final long INTERVAL_MILLS = 10;
    private static final int AMOUNT_PRODUCE = 200;

    public static void main(String[] args) {

        //Create a Kafka producer from configuration
        KafkaProducer optionProducer = new KafkaProducer( KafkaProperties.newProducerProperties() );

        //Publish 10 messages with intervals, and a random key
        try{

            int startKey = (new Random()).nextInt(1_000) ;

            for(int i = startKey; i < startKey + AMOUNT_PRODUCE; i++) {
                //Create a producer Record
                ProducerRecord<String, String> asyncNoCheckRec = new ProducerRecord<>(
                                KafkaProperties.TOPIC_NAME,   //Topic name
                                String.valueOf(i),              //Key for the message
                                "Published async with no check " + i       //Message Content
                        );
                System.out.println("Sending asyncNoCheck Message : "+ asyncNoCheckRec);
                //Publish to Kafka
                optionProducer.send(asyncNoCheckRec);
                Thread.sleep(INTERVAL_MILLS);
            }
        } catch(Exception e) {
            System.out.println("Exception when sending Message: "+ e);
        } finally {
            optionProducer.close();
        }
    }

}
