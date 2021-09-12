# Apache Kafka project

Using Kafka cluster with Java

Дата: 2021-09-12

## Содержание kafka-cluster.yml
Созданный кластер будет содержать:
- Zookeeper;
- Kafka1/Kafka2/Kafka3 broker;
- KafDrop UI

### Запуск Kafka кластера
Для запуска можно использовать команду
```shell
docker-compose -f kafka-cluster.yml up -d
```

### Остановка
Для остановки кластера можно использовать
```shell
docker-compose -f kafka-cluster.yml down
```

### Kafdrop UI
Доступен по адресу [http://localhost:9000/](http://localhost:9000/)

## Link:
[Курс LinkedinLeaning - Apache Kafka Essential Training: Building Scalable Applications, автор Kumaran Ponnambalam](https://www.linkedin.com/learning/apache-kafka-essential-training-building-scalable-applications/why-are-kafka-skills-so-high-in-demand)

