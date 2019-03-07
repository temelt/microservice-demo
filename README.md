# microservice-demo

This Project is POC of Microservice Architecture. Project contains 3 microservices (AccountService,InventoryService, ShippingService), 
Event Driven Data Management (microservice level transaction management - SAGA) will impl. 

This project was prepared for educational purposes. It is open for contribution :)

# Technologies & Tools
- Java 8
- Maven
- Spring Boot 2.1.0
- Spring Cloud Netflix - Eureka Server
- Spring Cloud Config Server
- Spring Cloud ApiGateway
- Spring Cloud Messaging
- Spring Cloud Zipkin-Sleuth
- Spring Cloud Hystrix-Dashboard
- Apache Kafka
- Spring Data-JPA (H2)
- Swagger2
- Lombok
- ModelMapper


# Addresses
- ConfigServer -> http://localhost:8888
- EurekaServer -> http://localhost:62500
- HystrixDashboard -> http://localhost:62501
- ZipkinServer -> http://localhost:62503
- ApiGateway -> http://localhost:80

- Account Service -> http://localhost:62511
- Inventory Service -> http://localhost:62513
- Shipping Service -> http://localhost:62512


All Spring Boot applications require already running ConfigServer for startup