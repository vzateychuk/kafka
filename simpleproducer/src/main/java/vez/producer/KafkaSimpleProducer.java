package vez.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import vez.property.KafkaProperties;

import java.util.Random;

public class KafkaSimpleProducer {

    private static final long INTERVAL_MILLS = 1000;
    private static final int AMOUNT_PRODUCE = 5;

    public static void main(String[] args) {

        //Create a Kafka producer from configuration
        KafkaProducer optionProducer = new KafkaProducer( KafkaProperties.newProducerProperties() );

        //Publish 10 messages with intervals, and a random key
        try{

            int startKey = (new Random()).nextInt(1_000) ;

            for(int i = startKey; i < startKey + AMOUNT_PRODUCE; i++) {
                //Create a producer Record
                ProducerRecord<String, String> syncRec = new ProducerRecord<>(
                                KafkaProperties.TOPIC_NAME,     //Topic name
                                String.valueOf(i),              //Key for the message
                                "Published Sync " + i      //Message Content
                        );

                //Publish Sync to Kafka
                RecordMetadata meta = (RecordMetadata)optionProducer.send(syncRec).get();
                System.out.println("Sent Sync : "+ syncRec + ", received partition: " + meta.partition()
                        + ", offset: "+ meta.offset());
                Thread.sleep(INTERVAL_MILLS);
            }
        } catch(Exception e) {
            System.out.println("Exception when sending Message: "+ e);
        } finally {
            optionProducer.close();
        }
    }

}
