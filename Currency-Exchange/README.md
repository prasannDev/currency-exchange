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
- `repository/`: Manages data storage and retrieval in `CurrencyRepository.java`.
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

Update the `application.properties` file with your API key for the currency exchange service.

```properties
# Third-party API key configuration
currency.api.key=your-api-key-here

# Server port configuration (optional)
server.port=8080
```

### B. Lombok Configuration:

Ensure Lombok is properly configured in your IDE to avoid build-time issues.

---

## 3. Build the Project

### Using Maven:

To build the project and create a JAR file, run the following command:

```bash
mvn clean package
```

This will generate the JAR file in the `target` directory.

### Using Gradle:

If you prefer using Gradle, run the following command:

```bash
./gradlew bootJar
```

This will generate the JAR file in the `build/libs` directory.

---

## 4. Running the Application

After building the JAR file, run the application with the following command:

```bash
java -jar target/currency-exchange-1.0.0.jar
```

The application will start on `http://localhost:8080` (or the port specified in `application.properties`).

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

This request will return the payable amount in the specified target currency after applying discounts and currency conversion.

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

## Conclusion

By following the steps provided in this `README.md`, you can:

- Set up the project.
- Build the JAR file.
- Run the application.
- Test the APIs using Postman with proper authentication.

---

## Test Report

| Test Case               | Description                                          | Expected Outcome     | Actual Outcome        | Status |
|-------------------------|------------------------------------------------------|----------------------|-----------------------|--------|
| `calculateFinalAmount()` | Verifies discount application and currency conversion | Final amount = ₹59.5 | Final amount = ₹59.5  | Pass   |

---