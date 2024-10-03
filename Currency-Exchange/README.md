# Currency Exchange Application

This Spring Boot application calculates the total payable amount for a bill 
in a specified currency after applying applicable discounts and converting 
to a different currency.

## Prerequisites

- Java 17 (or compatible version)
- Maven or Gradle
- Internet connection for third-party API calls

## Building the Project

### Using Maven

To build the project and create a JAR file, run the following command:

bash
mvn clean package

#
-test API using POST method in postman 
-http://localhost:8080/api/calculate
-used below JSON body in row as request 
{
  "items": ["TV"],
  "categories": ["ELECTRONICS"],
  "totalAmount": 300,
  "userType": "EMPLOYEE",
  "customerTenure": 3,
  "originalCurrency": "USD",
  "targetCurrency": "EUR"
}

you will get appropriate result

uml digram :
![1A80072A-D848-4307-B4C5-A8C11E43F020](https://github.com/user-attachments/assets/6ba966d8-adb8-4517-90b9-80528c87fd29)



