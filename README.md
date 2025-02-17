# Development

The application was developed with the help of [Docker](https://www.docker.com/) in [Visual Studio Code](https://code.visualstudio.com/) using the extension: [Dev Containers](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers)

# Build

- Clone repository using git, or simply download and unzip
- Install Docker
- Run the following commands where ```{PROJECT_DIRECTORY}``` is the root of the repository:
	- ```docker build -t java17-openjdk-maven {PROJECT_DIRECTORY}/.devcontainer```
	- ```docker build -t food-ordering-system-image {PROJECT_DIRECTORY}```
	- ```docker run -d -p 8080:8080 --name food-ordering-system-container food-ordering-system-image```
  
  For example, if already inside the project directory:
	- ```docker build -t java17-openjdk-maven ./.devcontainer```
	- ```docker build -t food-ordering-system-image .```
	- ```docker run -d -p 8080:8080 --name food-ordering-system-container food-ordering-system-image```
  
  ### Commands explanation
  - The first command builds the image containing the dev tools java and maven.
  - The second one builds an image that builds and runs the app based on the previous image.
  - The third one runs the image, exposing the 8080 port of it to local 8080 port

# Accessing application database
The application uses H2 in-memory database, but it could be replaced by a more permanent solution later.

The database can be accessed on the following url by default: http://localhost:8080/h2-console. The data required on this site is the following:
- Driver Class: org.h2.Driver
- JDBC URL: jdbc:h2:mem:testdb
- User name: sa
- Password: password

After entering these and pressign connect, the database editor of h2 console will be visible where the desired SQL commands can be run.

## Schema of database

By default, the database is empty and needs to applied some SQL script. This schema script is generated by the project if these lines are uncommented in the [application.properties](./src/main/resources/application.properties) file:
- ```spring.jpa.properties.javax.persistence.schema-generation.scripts.create-target=sql/generated/hibernate_schema.sql```
- ```spring.jpa.properties.javax.persistence.schema-generation.scripts.action=create```

The script will be written to the location: [./sql/generated/hibernate_schema.sql](./sql/generated/hibernate_schema.sql)

The last version of this script can be found at [./sql/hibernate_schema.sql](./sql/hibernate_schema.sql)

## Data of database

After applying the above mentioned schema, the database needs to be populated. AN example data can be found at [./sql/insert_data.sql](./sql/insert_data.sql)