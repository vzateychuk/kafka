package vez;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Random;

public class KafkaSimpleProducer {

    public static void main(String[] args) {

        //Create a Kafka producer from configuration
        KafkaProducer simpleProducer = new KafkaProducer( KafkaProperties.newKafkaProperties() );

        //Publish 10 messages at 2 second intervals, with a random key
        try{

            int startKey = (new Random()).nextInt(1000) ;

            for( int i=startKey; i < startKey + 20; i++) {
                //Create a producer Record
                ProducerRecord<String, String> kafkaRecord =
                        new ProducerRecord<String, String>(
                                "kafka.learning.orders",    //Topic name
                                String.valueOf(i),          //Key for the message
                                "This is order" + i         //Message Content
                        );
                System.out.println("Sending Message : "+ kafkaRecord.toString());
                //Publish to Kafka
                simpleProducer.send(kafkaRecord);
                Thread.sleep(2000);
            }
        } catch(Exception e) {
            System.out.println("Exception when sending Message: "+ e);
        } finally {
            simpleProducer.close();
        }
    }

}
