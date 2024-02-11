# Dynamic Function Executor

## Overview

Dynamic Function Executor is a Spring Boot application designed to interpret and execute JavaScript functions dynamically passed as strings through a REST API. This project showcases how to use the `ScriptEngine` to run JavaScript code dynamically in Java.

## Features

- **Function Interpreter**: Execute JavaScript functions passed as string along with their arguments.
- **REST API**: A simple REST API endpoint to receive function strings and arguments, and return execution results.

## Getting Started

### Prerequisites

- JDK 1.8 or later
- Maven 3.2+
- Spring Boot 2.x
- JUnit for testing

### Running the Application

1. **Clone the repository**

```bash
git clone https://github.com/doryngal/DynamicFunctionExecutor.git
cd DynamicFunctionExecutor
```

2. **Build and run the project using Maven**

```bash
mvn spring-boot:run
```

The application starts running on `http://localhost:8080`.

## Usage

### REST API

**Endpoint**: `POST /api/func-interpreter`

**Request Body**:

```json
{
  "function": "function multiply(x, y) { return x * y; }",
  "arguments": "multiply(5, 3);"
}
```

**Response**:

- On Success: Returns the result of the function execution.
- On Error: Returns an error message.

### Example

Using `curl` to send a request:

```bash
curl -X POST http://localhost:8080/api/func-interpreter \
     -H "Content-Type: application/json" \
     -d '{"function":"function multiply(x, y) { return x * y; }", "arguments":"multiply(5, 3);"}'
```

## Testing

The project includes unit tests to test the functionality of the service. The tests are written using the JUnit library.

### Running the Tests

The tests can be run using the following Maven command:

```bash
mvn test
```

## Development

This project uses Spring Boot for the REST API and the `ScriptEngineManager` for executing JavaScript code. The `FunctionInterpreterService` handles the logic for evaluating and executing the JavaScript code.

### Structure

- `FunctionController`: REST controller that accepts function strings and arguments.
- `FunctionInterpreterService`: Service that uses `ScriptEngine` to execute JavaScript functions.

## Contributing

Contributions are welcome. Please open an issue or submit a pull request with your changes.
