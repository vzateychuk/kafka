# Run Producer
java -cp simpleproducer-1.0.jar;lib\propertymodule-1.0.jar;%REPO%\org\apache\kafka\kafka-clients\2.7.0\kafka-clients-2.7.0.jar;%REPO%\com\github\luben\zstd-jni\1.4.5-6\zstd-jni-1.4.5-6.jar;%REPO%\org\lz4\lz4-java\1.7.1\lz4-java-1.7.1.jar;%REPO%\org\xerial\snappy\snappy-java\1.1.7.7\snappy-java-1.1.7.7.jar;%REPO%\org\slf4j\slf4j-api\1.7.30\slf4j-api-1.7.30.jar vez.producer.KafkaSimpleProducer

# Run Consumer
java -cp simpleconsumer-1.0.jar;lib\propertymodule-1.0.jar;%REPO%\org\apache\kafka\kafka-clients\2.7.0\kafka-clients-2.7.0.jar;%REPO%\com\github\luben\zstd-jni\1.4.5-6\zstd-jni-1.4.5-6.jar;%REPO%\org\lz4\lz4-java\1.7.1\lz4-java-1.7.1.jar;%REPO%\org\xerial\snappy\snappy-java\1.1.7.7\snappy-java-1.1.7.7.jar;%REPO%\org\slf4j\slf4j-api\1.7.30\slf4j-api-1.7.30.jar vez.consumer.KafkaSimpleConsumer