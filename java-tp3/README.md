# EFREI – LSI - L3 | JAVA - PROJET FINAL

[![Generic badge](https://img.shields.io/badge/Build-Passing-color.svg)](https://shields.io/)
[![License: MIT](https://img.shields.io/badge/License-MIT-color.svg)](https://opensource.org/licenses/MIT)
[![Generic badge](https://img.shields.io/badge/Contributors-3-red.svg)](https://shields.io/)
[![made-with-bash](https://img.shields.io/badge/Made%20with-Java-1f425f.svg)](https://www.gnu.org/software/bash/)

**Created by Arsene LAPOSTOLET, Jean-Michel REMEUR, Thomas LACAZE**
__L3 APP Promotion 2022__

## Usage: 

Use the provided jar file :
- Run GesProg.jar :

```bash
java -jar ./target/GesProg.jar
```

OR

Compile it yourself : 
- Use maven to build the project and generate a jar file
- Run the generated jar file

## Explanation: 
- Database : Using POSTGRESQL, hosted on Heroku (AWS), common database for the project.
  This way we have nothing to change from one development environment to another. 
  Due to the school firewall blocking Postgres' 5432 TCP port please check if the port is not closed.
  Finally, since the database is hosted in the cloud, no need to import/export data (bonus 3)
  Database connection lifecycle is managed using the singleton design pattern to hold the reference to the connection
- Maven : Manage dependencies and IDE agnostic development environment.
- Material UI for Swing : A sleeker UI than the default Windows Look & Feel

## Features:
- All requested features are complete
- All Bonuses are completed
- Using config files (db.properties) to connect the database (POSTGRESQL)
- Future birth and hire date cannot be set in the future (input safety)
- Generic table model to display programmer list
- Logger
- Provided jar file properly packages resources (.properties files and images) in the
src/main/resources as instructed by maven directory layout. They are accessed in the code via :

```java
ClassLoader classLoader = getClass().getClassLoader();
classLoader.getResourceAsStream(Constants.PATH_DB);
```

## Tools:
- [Git](https://framagit.org/Ombrelin/java-tp3) 
- Trello
- Maven
- JDK 1.8

## Dependencies:
- [Material-ui-swing](https://search.maven.org/artifact/io.github.vincenzopalazzo/material-ui-swing/1.0.3/jar) : 1.0.3
- [Log4j Core](https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core) : 2.12.1
- [Log4j Api](https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api) : 2.12.1
- [Postgresql](https://mvnrepository.com/artifact/org.postgresql/postgresql) : 42.2.8