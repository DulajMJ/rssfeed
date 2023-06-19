# RSS Parser
A Spring Boot application that polls a RSS feed every 5 minutes and stores any in-memory database H2

## Project Technologies
   - Java 17
   - Spring boot 2.7.6
   - H2 Database
   - MVN build tool
## Project Set-Up and Environment
   - Install Java 17 
   - used application.yml file for the active environment
   - application-dev.yml development environment
   - application-qa.yml QA environment
   - application-prod.yml production environment

## Project Structure 
   - config    - Project configuration(Kafka,logging,etc)
   - dto       - Used only to transfer data from one process or context to another.
   - entity    - Database entity class.
   - exception - Application exception
   - mapper    - DTO and Entity map.
   - repository- Database repository
   - service   - Business logic layer
   - utility   - Constant file.
## To run a Spring Boot project using the command line 
  1. Open a command prompt or terminal.
  2. Navigate to the root directory of your Spring Boot project. This is the directory that contains your pom.xml 
  3. Build the project (if necessary) by running one of the following commands 
      -- mvn clean install
      * This command will compile your code, resolve dependencies, and generate the executable JARy
   4. Once the build is successful, you can run the Spring Boot application by executing the following command
      --mvn spring-boot:run
      * This command starts the embedded Tomcat server and deploys your Spring Boot application

# Swagger API documentation
http://localhost:8084/swagger-ui/index.html
