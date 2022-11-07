# spring-boot-rest-jpa

Sprint Boot Rest API Boilerplate with JPA - Swagger - Actuator &amp; other commonly used spring dependencies.

- [spring-boot-rest-jpa](#spring-boot-rest-jpa)
    * [Introduction](#introduction)
    * [Modules (or) Packages](#modules--or--packages)
        + [Models](#models)
            - [Entities](#entities)
            - [Repositories](#repositories)
        + [Servlets](#servlets)
        + [Controllers](#controllers)
    * [How to Test and Run Application](#how-to-test-and-run-application)
        + [Test](#test)
        + [Run](#run)
    * [How Can I use this ?](#how-can-i-use-this--)

<small><i><a href='http://ecotrust-canada.github.io/markdown-toc/'>Table of contents generated with
markdown-toc</a></i></small>

-----

## Introduction

This project is designed to make it easier to understand spring boot and different plugins / libraries it provides to
design and implement crisp - clean - robust REST API.

-----

## Modules (or) Packages

Having modules or packages makes it easier for us to logically understand or group different components in our code. All
different classes and interfaces under same module or package will have exactly similar function set `(in broad sense)`.

This boilerplate template has the following modules / packages:

* models
    * entities
    * repositories
* servlets
* controllers

### Models

This package or module is responsible for containing all the data entities with repositories which will be used by
Hibernate & JPA to work with connected Database.

#### Entities

The data entities are essentially Table Row Definitions for Tables present in our database. Users are encouraged to
define all the JPA and Hibernate related Data Entities here under this package.

#### Repositories

The defined data entities need repositories for Hibernate - JPA to correctly and efficiently retrieve information from
JDBC Datasources. Users are encouraged to define their CRUD Repositories associated with data entities under this
package.

### Servlets

Servlets are supposed to have complex logic which we would like to use inside controllers. This extra layer has been
added since often there is a requirement for having some medium complex logics which we would like to re-use.

Instead of placing this code in controllers, it's desirable to place it inside servlets. Since auto-wiring servlets into
multiple controllers and testing it becomes fairly simpler.

### Controllers

This is the actual controller where we are defining actual route bindings to java functions using Spring Boot
annotations. Ideally apart from information related to route definition, there should not be any kind of logic happening
here. The controller code should make calls to servlets where the actual route's application logic is present.

-----

## How to Test and Run Application

### Test

```shell
# execute all tests
mvn clean test
```

### Run

```shell
# test and generate shaded jar 
# file in target folder
mvn clean install

# execute the jar generated 
# in target folder
java -jar target/spring-boot-rest-jpa-*.jar
```

[SWAGGER UI (app must be running in localhost)](http://localhost:8080/swagger-ui/index.html)

-----

## How Can I use this ?

To use this service / rest code please make sure you complete the following:

1. update the `pom.xml` file to have correct artifact and org names.
2. update the package to be same as your organization.
3. test everything is working as expected with H2DB (`mvn clean test`).
4. update `pom.xml` and add your jdbc driver
5. update `application.properties` and correctly configure your jdbc configuration.
6. create new model - repository for any 1 table in your actual data source.
7. write unit tests for newly created repository.
8. verify new unit test works as expected `(only run tests for new repository)`
9. create new servlet - controller associated with selected table
10. write unit tests for newly created servlet and controller.
11. verify new unit tests work as expected `(only run tests for new controller & servlet)`
12. remove sample (or) example models - repository - servlets - controllers.
13. remove or update demo method in `AppEntryPoint.java` class since it was present to add sample data to H2DB.
14. run tests and ensure everything is working as expected. 