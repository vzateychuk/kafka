# Apache Kafka project

Using Kafka cluster with Java

����: 2021-09-12

## ���������� kafka-cluster.yml
��������� ������� ����� ���������:
- Zookeeper;
- Kafka1/Kafka2/Kafka3 broker;
- KafDrop UI

### ������ Kafka ��������
��� ������� ����� ������������ �������
```shell
docker-compose -f kafka-cluster.yml up -d
```

### ���������
��� ��������� �������� ����� ������������
```shell
docker-compose -f kafka-cluster.yml down
```

### Kafdrop UI
�������� �� ������ [http://localhost:9000/](http://localhost:9000/)

## Link:
[���� LinkedinLeaning - Apache Kafka Essential Training: Building Scalable Applications, ����� Kumaran Ponnambalam](https://www.linkedin.com/learning/apache-kafka-essential-training-building-scalable-applications/why-are-kafka-skills-so-high-in-demand)

