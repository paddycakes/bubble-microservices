knowledge-service-command
-------------------------

## Overview


## Maven Build


## Build Tasks

### Clean the output directories:

	mvn clean

### Running tests

	mvn test
	
Test reports can be found at:

	

### Running application

Firstly, build and package the application

    mvn clean package
    
and then to run it you should execute

    java -jar target/knowledge-service-query-<version>.jar

replacing <version> with the correct version number. It will start the micro-service on port 8080 by default.