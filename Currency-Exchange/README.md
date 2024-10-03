### Currency Exchange and Discount Calculation Application
This Spring Boot application calculates the total payable amount for a bill in a specified currency after applying applicable discounts and converting to a different currency.

### Prerequisites
- Java 17 (or compatible version)
- Maven or Gradle (ensure either of them is installed for building the project)
- Lombok: Make sure your IDE supports Lombok annotations
- For IntelliJ IDEA: Install the Lombok plugin and enable annotation processing (File > Settings > Build, Execution, Deployment > Compiler > Annotation Processors > Enable annotation processing).

### Features
- Integrates with a third-party currency exchange API to retrieve real-time exchange rates.
- Apply discounts based on user type and bill amount.
- Exposes a REST API for submitting bills and retrieving the payable amount in a specified target currency.

1. Setting up the Project
Clone the repository 
 git clone https://github.com/prasannDev/currency-exchange.git
 cd currency-exchange
..............................................................................................................................

### Configure the Application
A. Application.properties: Update the application.properties file with your API key for the currency exchange service.
# Third-party API key configuration
currency.api.key=your-api-key-here

# Server port configuration (optional)
server.port=8080

B. Lombok Configuration: Ensure that Lombok is set up in your IDE to avoid build-time issues due to Lombok annotations.

..............................................................................................................................

2. Build the Project

## Using Maven
   To build the project and create a JAR file, run the following command:
        -  mvn clean package
   This will generate the JAR file in the target directory.

## Using Gradle
If you prefer using Gradle, run the following command:
        -  ./gradlew bootJar
This will generate the JAR file in the build/libs directory.

..............................................................................................................................

3. Running the Application
   Once the JAR file is built, you can run the application using the following command:
        -  java -jar target/currency-exchange-1.0.0.jar

The application will start, and you can access it on http://localhost:8080 (or the port you specified in application.properties).

..............................................................................................................................


# Testing the Application Using Postman
   You can test the API endpoint /api/calculate using Postman.

# Endpoint: /api/calculate (POST Request)
  Request Body:
The API expects a JSON payload with the following structure:
- test API using POST method in postman 
- http://localhost:8080/api/calculate
  - used below JSON body in row as request 
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

# Authentication (Basic Auth)
Since we are using Basic Authentication for this project, the API requests need to be authenticated. In Postman:

Go to the Authorization tab.
Choose Basic Auth.
Enter the username and password.
Username: admin
Password: admin123
uml digram :
![1A80072A-D848-4307-B4C5-A8C11E43F020](https://github.com/user-attachments/assets/6ba966d8-adb8-4517-90b9-80528c87fd29)



# Conclusion
By following these steps, you will be able to run the Currency Exchange application, generate JAR files, 
test the APIs in Postman


## test report 

Test Case              | Description	                                        |Expected Outcome	    |Actual Outcome	        |Status
calculateFinalAmount()	| Verifies discount application and currency conversion	|Final amount = ₹59.5	|Final amount = ₹59.5	|Pass