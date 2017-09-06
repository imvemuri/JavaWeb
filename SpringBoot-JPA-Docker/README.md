## Steps to setup and run the Springboot webapp on Docker

### Prerequiste:
Docker installed Linux machine.

### Package Structure:
* <b>/src</b>: All the web application source code and pom.xml to put all necessary jars into project lib folder.<br>
* <b>/src/main/resources/application.properties</b>: Configure the SQL server. <br>
* <b>/Target</b>: The docker.spring-0.0.1-SNAPSHOT.war after building is stored in this folder.<br>
* <b>/Docker/webapp/spring</b>: Contains Dockerfile to build an image of webapp and run the .war. Manually copy and place the .war(/src/target) in ../spring/target/ folder
* <b>/Docker/webapp/sql</b>: Contains Dockerfile to build an image of sql and set the password for root. 
* <b>/Docker/webapp/docker-compose.yml</b>: To build and run the webapp and sql containers. The sql container is exposed on port 3306 and volume is mounted on host space.The spring webapp container is exposed on port 8085.<br> Command to run and up the containers : <b> docker-compose up.
  
### Execution:
  After executing the above command with proper directory structure all our services will be up and running, but database is empty for the first time. Insert the records can be done either using bash on running SQL container or MYSQL client on Host machine. To access the webapp use http://docker-ip-address:8085 on host Windows machine.
