# spring-boot-kafka-producer-sample

Step # 1 

Install Kafka on your local Machine and do these things before writing Spring boot application.

bin/zookeeper-server-start.sh config/zookeeper.properties

bin/kafka-server-start.sh config/server.properties.

bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions --topic Harsha_Sample

bin/kafka-topics.sh --list --zookeeper localhost:2181 - should list all topics created.

In above case Harsha_Sample.

Step # 2 

A Consumer that will show message posted.

bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic Harsha_Sample --from-beginning 


http://localhost:8082/kafka/publish1/FirstKafkaMessage 

what ever after publish1 —> can be seen on the console if consumer is running.


FirstKafkaMessage

JSON Stream created to topic - Model was sent.

{"shipmentId":"12345","shipmentName":"ST12345","transportMode":"TruckLoad","srcLocation":"SRCLOC12345","destLocation":null}


