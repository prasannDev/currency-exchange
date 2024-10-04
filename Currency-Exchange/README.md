# Currency Exchange and Discount Calculation Application

This Spring Boot application calculates the total payable amount for a bill in a specified currency after applying applicable discounts and converting it to a different currency.

---

## Prerequisites
- **Java 17** (or compatible version)
- **Maven** or **Gradle** (for building the project)
- **Lombok**: Ensure your IDE supports Lombok annotations.
    - For IntelliJ IDEA: Install the Lombok plugin and enable annotation processing.
        - Go to: `File > Settings > Build, Execution, Deployment > Compiler > Annotation Processors` and enable "Annotation Processing."

---

## Features
- Integration with a third-party currency exchange API to retrieve real-time exchange rates.
- Discounts applied based on user type (e.g., employee, affiliate) and bill amount.
- REST API to submit bills and calculate the payable amount in a specified target currency.

---

## 1. Setting Up the Project

### Clone the repository:
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
Ensure that Lombok is configured in your IDE to avoid build-time issues.

---

## 3. Build the Project

### Using Maven:
To build the project and create a JAR file, run the following command:
```bash
mvn clean package
```
This will generate the JAR file in the `target` directory.

### Using Gradle:
If you prefer Gradle, run the following command:
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
The application will start on `http://localhost:8080` (or the port you specified in the `application.properties`).

---

## 5. Testing the Application Using Postman

### Endpoint: `/api/calculate` (POST Request)
Use the following JSON payload in Postman to test the API:

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

You will receive the calculated payable amount in the specified target currency.

---

## 6. Authentication (Basic Auth)
Since this API uses Basic Authentication, follow these steps in Postman:

1. Go to the **Authorization** tab.
2. Choose **Basic Auth**.
3. Enter the following credentials:
    - Username: `admin`
    - Password: `admin123`

---

## UML Diagram

![UML Diagram](https://github.com/user-attachments/assets/6ba966d8-adb8-4517-90b9-80528c87fd29)

---

## Conclusion

By following the above steps, you will be able to:

- Run the Currency Exchange and Discount Calculation application.
- Build the JAR file.
- Test the API using Postman.

---

## Test Report

| Test Case               | Description                                          | Expected Outcome     | Actual Outcome        | Status |
|-------------------------|------------------------------------------------------|----------------------|-----------------------|--------|
| `calculateFinalAmount()` | Verifies discount application and currency conversion | Final amount = ₹59.5 | Final amount = ₹59.5  | Pass   |

--- 

This refined `README.md` is structured for clarity, making it easier to set up, configure, and test the application.