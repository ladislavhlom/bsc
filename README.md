## Requirements

For building and running the application you need:

- JDK 11
- Maven 3

## Running the application locally
Create application jar:
```shell
mvn spring-boot:run
```
it will create jar `target/application-0.0.1-SNAPSHOT.jar`

Run jar
```shell
java -jar application-0.0.1-SNAPSHOT.jar
```

## Configuration
In application.properties is possible to configure scheduled task for printing actual state and output format for weight.

Fixed rate for job in milliseconds. Default value is 60000 - every 60 seconds
`job.fixedRate=60000`

Initial delay for job in milliseconds. Default value is 20000 - every 20 seconds
`job.initialDelay=20000`

Fractions for output. Default value is 3 - with produce weight in format 1.123
`output.fraction.digits=3`

## Terminate application
Input `quit` ends application
