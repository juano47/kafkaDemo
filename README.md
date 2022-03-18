# kafkaDemo
Event Driven Microservice project using Spring Boot and Kafka

#RUN KAFKA SERVER
STEP 1: GET KAFKA
Download latest Kafka release from:
https://kafka.apache.org/quickstart


STEP 2: START THE KAFKA ENVIRONMENT
copy zookeeper.properties file from config folder to bin/windows/ folder

open cmd console, navigate to /bin/windows and run: 
zookeeper-server-start.bat zookeeper.properties

copy server.properties file from config folder to bin/windows/ folder

open another cmd console, navigate to /bin/windows and run: 
kafka-server-start.bat server.properties


READ THE EVENTS
open another cmd console, navigate to /bin/windows and run:
kafka-console-consumer.bat --topic kafkaTest --from-beginning --bootstrap-server localhost:9092


#Test Producer Service API
POST http://localhost:8080/consumer/api/v1/messages
Content-Type: application/json

{
  "message": "test2"
}

The message will be showing in the console of Consumer Service API
