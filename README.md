# microservice-demo

This Project is POC of Microservice Architecture. Project contains 3 microservices (AccountService,InventoryService, ShippingService), 
Event Driven Data Management (microservice level transaction management - SAGA) will impl. 

This project was prepared for educational purposes. It is open for contribution :)

# Technologies & Tools
- Java 8
- Maven
- Spring Boot 2.1.0
- Spring Cloud Netflix - Eureka
- Spring Cloud Config Server
- Spring Cloud Api Gateway
- Spring Cloud Messaging
- Zipkin
- Apache Kafka
- Spring Data-JPA (H2)
- Swagger2
- Lombok
- ModelMapper


# Addresses
- ConfigServer -> http://localhost:8888
- EurekaServer -> http://localhost:62500
- HystrixDashboard -> http://localhost:62501
- ApiGateway -> http://localhost:80
- ZipkinServer -> http://localhost:62502

- Account Service -> http://localhost:62511
- Inventory Service -> http://localhost:62513
- Shipping Service -> http://localhost:62512


All Spring Boot applications require already running ConfigServer for startup