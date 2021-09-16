package vez.property;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.record.CompressionType;

import java.util.Properties;

public class KafkaProperties {

    public static final String TOPIC_NAME = "kafka.learning.orders";

    private static final String DESERIALIZER_CLASS = "org.apache.kafka.common.serialization.StringDeserializer";
    private static final String STRING_SERIALIZER = "org.apache.kafka.common.serialization.StringSerializer";

    public static Properties newConsumerProps(){

        Properties kafkaProps = newKafkaProperties();

        //Deserializer class to convert Keys from Byte Array to String
        kafkaProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, DESERIALIZER_CLASS);

        //Deserializer class to convert Messages from Byte Array to String
        kafkaProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, DESERIALIZER_CLASS);

        //Consumer Group ID for this consumer
        kafkaProps.put(ConsumerConfig.GROUP_ID_CONFIG, "kafka-java-consumer");

        //Set to consume from the earliest message, on start when no offset is available in Kafka
        kafkaProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        return kafkaProps;
    }

    public static Properties newProducerProperties(){

        Properties kafkaProps = newKafkaProperties();

        //Serializer class used to convert Keys to Byte Arrays
        kafkaProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, STRING_SERIALIZER);

        //Serializer class used to convert Messages to Byte Arrays
        kafkaProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, STRING_SERIALIZER);

        // Set all to ask all replicas to acknowledge
        kafkaProps.put(ProducerConfig.ACKS_CONFIG, "all");

        // Set compression type to GZIP
        kafkaProps.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, CompressionType.GZIP.name);

        return kafkaProps;
    }

    private static Properties newKafkaProperties() {

        Properties kafkaProps = new Properties();

        //List of Kafka brokers to connect to
        kafkaProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092,localhost:9093,localhost:9094");

        //Consumer Group ID for this consumer
        kafkaProps.put(ConsumerConfig.GROUP_ID_CONFIG, "kafka-java-consumer");

        return kafkaProps;
    }
}
