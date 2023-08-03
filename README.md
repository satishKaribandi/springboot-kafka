springboot-kafka
----------------

##Sequence of steps: 

	1.Created a Springboot project 
	2.Added Kafka dependencies, created a consumer and producer classes to test simple Kafka setup with replication factor 1 and 1 partitions. 
	3.Created a controller and added an endpoint to post message so I can invoke this using Apache Bench. 
          ab -n 1000 localhost:8080/postmessage