## Project Description

The intention of the project was to provide a proof of concept illustration of a Spring Boot application
which can connect to multiple databases. This was achieved by configuring Spring Data JPA to allow for 
multiple datasource's. This project uses Docker to run both the application and databases in containers. 

MySQL and PostgreSQL were the databases chosen simply for ease of setup and configuration in Spring and Docker.

---

## Project Installation

The application was developed on Windows and using Docker Desktop. To run this project, Docker should be 
installed on the machine which it is to be run.

Steps on Docker installation can be found here: https://docs.docker.com/engine/install/

---

## Project Deployment

### Dockerfile
- **base**: build the base image
- **test**: separate stage to specifically execute tests
- **development**: deploys the app container using a single in memory h2 databases in place of the actual databases
- **build**: runs tests and package
- **production**: deploys the packaged build into a container with additional containers for MySQL and PostgreSQL

### docker-compose.dev.yml

Points at the **development** stage. In a terminal from the projects root directory, run command:
- <code>docker compose -f docker-compose.dev.yml up --build</code>

### docker-compose.yml

Points at the **production** stage. In a terminal from the projects root directory, run command:
- <code>docker compose -f docker-compose.yml up --build</code>

---

## API

The project has swagger configured, once running use this link http://localhost:8080/swagger-ui/index.html to access API
in browser.

Below endpoints are configured to retrieve data from each database:
- <summary><code>GET</code> <code><b>/user/all</b></code> <code>(gets all users from postgres)</code></summary>
- <summary><code>GET</code> <code><b>/item/all</b></code> <code>(gets all items from mysql)</code></summary>

---
## Key Features
When the application is started it will load data into database tables from files contained here:
- <code>/src/main/resources/db/{database}</code>

Data is persisted through the use of the below Docker volumes (however, currently no way of writing to DB):
- mysql_data:
- mysql_config:
- postgres_data:

