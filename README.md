## Spring University App

The application manages the students, professors and courses within a university and the relationships between them. 

It is a  web application built using Spring Boot and Gradle. 

Other technologies used: JPA, PostgreSQL, REST APIs, Postman, Swagger, Actuator, Logging, Rabbit MQ.


## Steps to run 

To run this application you need to have the following: Java 11, Gradle, Rabbit MQ.

Go to spring-university-app/ro.fasttrackit.university/
```
gradle clean build 
```
```
gradle bootRun
```
The web application is accessible via  
```
http://localhost:8085/swagger-ui/index.html/
```
## Send a message using Rabbit MQ 

You need to schedule a course:

In Swagger go to scheduled-courses-controller -> POST -> Try it out,  and write the Ids of an existing, course, semester and professor, such as:
```
{
  "courseId": 5,
  "professorId": 1,
  "semesterId": 1
}
```
The messag is now sent. To open the consumer go to spring-university-app/demo-consumer/

```
gradle clean build 
```
```
gradle bootRun
```
