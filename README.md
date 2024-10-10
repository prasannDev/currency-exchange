---

# Currency Exchange and Discount Calculation Application

This Spring Boot application calculates the total payable amount for a bill in a specified currency after applying applicable discounts and converting the amount to a different currency.

---

## Prerequisites

- **Java 17** (or compatible version)
- **Maven** or **Gradle** (for building the project)
- **Lombok**: Ensure your IDE supports Lombok annotations.
    - For **IntelliJ IDEA**: Install the Lombok plugin and enable annotation processing.
        - Go to `File > Settings > Build, Execution, Deployment > Compiler > Annotation Processors`, and enable "Annotation Processing."

---

## Features

- Real-time exchange rate retrieval using a third-party currency exchange API.
- Apply discounts based on user type (e.g., employee, affiliate) and bill amount.
- REST API to submit bills and calculate the payable amount in the target currency after discounts and currency conversion.
- Store bill data in an H2 in-memory database.

---

## Project Structure

```
src/
 └── main/
     ├── java/
     │    └── com.example.currencyapp/
     │         ├── controller/
     │         │    └── CurrencyController.java
     │         ├── service/
     │         │    ├── CurrencyService.java
     │         │    └── DiscountService.java
     │         ├── model/
     │         │    ├── Bill.java
     │         │    └── UserType.java
     │         ├── client/
     │         │    └── CurrencyExchangeClient.java
     │         ├── config/
     │         │    └── FeignConfig.java
     │         ├── exception/
     │         │    └── CustomException.java
     │         ├── repository/
     │         │    └── ExchangeRepository.java
     │         └── CurrencyAppApplication.java
     └── resources/
         └── application.properties
```

### Explanation:

- `controller/`: Contains the `CurrencyController.java` which handles the REST API endpoints.
- `service/`: Contains business logic in `CurrencyService.java` and `DiscountService.java`.
- `model/`: Contains application models like `Bill.java` and `UserType.java`.
- `client/`: Defines the Feign client in `CurrencyExchangeClient.java` to interact with the third-party currency exchange API.
- `config/`: Contains Feign client configurations and other beans in `FeignConfig.java`.
- `exception/`: Handles custom exceptions defined in `CustomException.java`.
- `repository/`: Manages data storage and retrieval in `ExchangeRepository.java`.
- `resources/`: Contains configuration files such as `application.properties`.

---

## 1. Setting Up the Project

### Clone the Repository:
```bash
git clone https://github.com/prasannDev/currency-exchange.git
cd currency-exchange
```

---

## 2. Configure the Application

### A. `application.properties` Configuration:

Update the `application.properties` file with your API key for the currency exchange service and configure H2 database settings.

```properties
# Third-party API key configuration
currency.api.key=your-api-key-here

# Server port configuration (optional)
server.port=8080

# H2 Database
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:test
spring.jpa.generate-ddl=true
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create-drop
```

### B. Lombok Configuration:

Ensure Lombok is properly configured in your IDE to avoid build-time issues.

---

## 3. Steps to Create a JAR File Using Maven in IntelliJ IDEA

### Open Your Project in IntelliJ IDEA:
1. Launch **IntelliJ IDEA**.
2. Open the Maven project by navigating to `File > Open` and selecting the folder that contains your `pom.xml` file.

### Ensure Maven is Configured:
1. In the right-hand side **Maven** tool window, you should see the Maven project structure. If the window is not visible, open it by going to `View > Tool Windows > Maven`.
2. Verify that Maven is configured correctly by checking the `pom.xml` file.

### Clean and Build the Project:
1. In the Maven tool window, expand your project structure to show lifecycle phases.
2. Navigate to `Lifecycle > clean`. Double-click `clean` to remove previous build artifacts.
3. Next, double-click `install` (found under Lifecycle) to compile the project, run tests, and create a JAR file.
4. Alternatively, you can run the following command directly from the terminal within IntelliJ:

```bash
mvn clean install
```

### Locate the Generated JAR File:
- After the build process completes, the JAR file will be located in the `target` directory inside your project folder.
- Right-click the project folder and select `Show in Explorer` (on Windows) or `Reveal in Finder` (on macOS) to quickly access the directory.

### (Optional) Skip Tests During Build:
If you want to skip the tests during the build, use the following Maven command:

```bash
mvn clean install -DskipTests
```

---

## 4. Running the Application

Once the project is set up and configured, you can run the Spring Boot application directly from your IDE (e.g., IntelliJ, Eclipse) or build a JAR file and run it using:

```bash
java -jar target/currency-exchange-1.0.0.jar
```

The application will start on `http://localhost:8080` (or the port specified in `application.properties`).

You can access the H2 database console by visiting `http://localhost:8080/h2-console`.

---

## 5. Testing the Application Using Postman

### Endpoint: `/api/calculate` (POST Request)

You can test the API endpoint by sending a POST request to `/api/calculate` using Postman.

Example request body (JSON):

```json
{
  "items": ["TV"],
  "categories": ["ELECTRONICS"],
  "totalAmount": 300,
  "userType": "EMPLOYEE",
  "customerTenure": 3,
  "originalCurrency": "USD",
  "targetCurrency": "EUR"
}
```

This request will return the payable amount in the specified target currency after applying discounts and currency conversion. The bill data will be stored in the H2 database.

---

## 6. Authentication (Basic Auth)

The API is protected by Basic Authentication. To test in Postman:

1. Go to the **Authorization** tab.
2. Select **Basic Auth**.
3. Enter the following credentials:
    - Username: `admin`
    - Password: `admin123`

---

## UML Diagram

![UML Diagram](https://github.com/user-attachments/assets/6ba966d8-adb8-4517-90b9-80528c87fd29)

---

## Test Report

| Test Case               | Description                                          | Expected Outcome     | Actual Outcome        | Status |
|-------------------------|------------------------------------------------------|----------------------|-----------------------|--------|
| `calculateFinalAmount()` | Verifies discount application and currency conversion | Final amount = ₹59.5 | Final amount = ₹59.5  | Pass   |

---

## Conclusion

By following the steps provided in this `README.md`, you can:

- Set up the project.
- Create a JAR file using Maven.
- Run the application.
- Test the APIs using Postman with proper authentication.
- Store bill data in an H2 database and access it via the H2 console.

---

This `README.md` provides all the necessary instructions to set up, run, and test the Currency Exchange and Discount Calculation application, including storing bill data in an H2 database.

--- 
