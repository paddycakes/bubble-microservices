knowledge-service-command
-------------------------

## Overview


## Maven Build

To build a multi module project, we have to run build commands from the top level directory of the project. In this case that is from the knowledge-service parent project.

## Build Tasks

### Clean the output directories:

    mvn clean -pl knowledge-service-query -am

### Running tests

    mvn test -pl knowledge-service-query -am

Test reports can be found at:

	

### Running application

Firstly, build and package the application

    mvn clean package -pl knowledge-service-query -am

Then to run it you should execute

    java -jar knowledge-service-query/target/knowledge-service-query-<version>.jar

replacing `<version>` with the correct version number. It will start the micro-service on port 8080 by default.