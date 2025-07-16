# servicebox
Photo App Upload Service


## Versions 
java -version

java version "17.0.13" 2024-10-15 LT

## Buid

mvn package 

## Run

java -jar target/servicebox-0.0.1-SNAPSHOT.jar


## Test

mvn test

## Visit the File Storage H2 Database

http://localhost:8080/h2-console

Driver Class=org.h2.Driver
User Name=sa
Password=
JDBC URL=jdbc:h2:mem:testdb

####Important:
Password is empty. There is no password, and JDBC URL should be set to jdbc:h2:mem:testdb, and not jdbc:h2:~/test


 