# RSS Parser
A Spring Boot application that polls a RSS feed every 5 minutes,and stores any in-memory database H2

## Project Technologies
   - Java 17
   - Spring boot 2.7.6
   - H2 Database
   - MVN buil tool
## Project Set-Up and Environment
   - Install java 17 and Mysql 8 after run the gradle file
   - used application.yml file for the active environment
   - application-dev.yml development environment
   - application-qa.yml QA environment
   - application-prod.yml production environment

## Project Structure 
   - adapter
   - config - project configuration(kafka,logging,etc)
   - dto - Used only to transfer data from one process or context to another.
   - entity
   - exception
   - mapper
   - repository
   - response
   - service
   - utility
   - 
# swagger documentation
http://localhost:8084/swagger-ui/index.html
