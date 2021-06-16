# Code Sample : my service
The project is about a microservice implementing a simple functionality : a person id validator (DNI, NIE).

The microservice exposes and endpoint on http://localhost:8080/api/idvalidator. The http method used on this endpoint 
is a POST and the person Id to be validated in informed into the request body. The request must be a json message.

The project compliants with REST architecture specification and is built on the following technological stack :

  - Spring Boot framework as main the application development basis.   
  - Spring Security for security config and oauth2 (extended by OpenID) as token securization method. Any request (excepting 
    calls to the status endpoint) must include a token header. For demo purposes we excluded "api/idvalidator" endpoint
    from security token policy
  - Spring Cloud for application context. Bootstrap properties are stored on a remote configuration-server
  - Eureka service for registering the service on a hypothetical microservice based architecture with a pool of 
    different microservices.
  - Status endpoint from health check (we could use springboot actuator instead of this ad-hoc service).   
  - Junit for unit testing
  - Swagger for api documentation
  - Lombok utility library
  - The microservice is adapted to be deployed on hypothetical container (Docker)
  - There is a simple jenkins File that would be read and load by jenkins to generate a deployment pipeline. it uses
    a shared jenkins library. I have considered it out of the scope for the code-sample project. 
  - CI/CD is configured on build_option.txt file :  sonar scan ,fortify scan (security vulnerabilities scan) amd other 
    additional job stages.
  - Project includes jacoco plugin for code coverage reports when running locally (reports are generated on my-service-jar/target/site/jacoco)   


Notes
-----------------------
Please notice that some code is commented in order to allow the service to be run locally (i.e ConfigSecurity class)
Also eruka registry is deactivated because of the same reason


Structure of the proyect
------------------------

```
my-service-parent   <- Parent pon for dependency management
my-service     		<- Core functionality
```

How to build the proyect
------------------------
mvn clean install


How to run the proyect
------------------------
mvn spring-boot:run


Endpoints
---------
```
http://localhost:8080/my-service/api/status
http://localhost:8080/my-service/api/idValidator
```

Request Sample
---------------------

```
{
    "applicants": {
        "primaryConsumer": {
            "personalInformation": {
                "idType":"ID",
                "idCode": "71279276E"
            }

        }
    }
}
```

Response Sample
---------------------
```
{
    "idDocumentType": "DNI"
}
```

Additional control - Bonus track
--------------------------------
 - Ideally there should and completary project to implement acceptance/proformace/smoke test and would be run automatically 
as part of deployment pipeline on jenkins. I would used Gauge framework for the simplicity to define test specs and 
because of being java compatible.
 - As we are adding new controllers-functionalities to the service we could have role-permissions method control using
Spring Security and @Preauthorize (hasRole()) annotation
