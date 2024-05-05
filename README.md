# Cucumber BDD Automation using Java-Selenium4


## System Requirements
- Java v17.0.9
- Maven v3.9.2
- IntelliJ IDEA (IDE)


## Development

Test are divided into 3 stages:

1. Page Objects - Test to interact with the Web Driver (Browser Driver) to perform actions on the web-application.
2. Step Definitions - Integrate with the Page Objects to perform actions based on Cucumber steps.
3. Feature Files - The actual tests that are run



## Configuring the Test Environment
You need to open the `src/test/resources/config.properties` file and set the required properties.

- browser = Chrome / Safari / Edge
- url = # Set the URL of the application



## Running the tests
To run the tests, run the following command from the root of the project:

 -> mvn clean test
