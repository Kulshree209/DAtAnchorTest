# DAtAnchorTest

# Selenium Test Automation Project

This project is a Selenium-based test automation framework using Java, TestNG, and WebDriver. It includes a parallel test execution setup, and page object model (POM) structure.

## Project Structure

- `src/main/java/pages/`
  - Contains page object classes (e.g., `LoginPage.java`).
- `src/main/java/utils/`
   - Contains utils files.
- `src/main/java/resources`
   - Contains resources required for automation project (e.g., `drivers`).
- `src/main/java/tests/`
  - Contains test classes (e.g., `FileListTest.java`).
- `testng.xml`
  - TestNG configuration file for parallel execution.
- `pom.xml`
  - Dependencies present in pom.xml file, which we need to .  
- `path/to/chromedriver`
  - WebDriver executable (e.g., ChromeDriver).

## Setup and Installation

### Prerequisites

- Java Development Kit (JDK) 8 or above.
- IDE (e.g., Eclipse)
- Apache Maven (for managing dependencies).
- WebDriver executable (e.g., ChromeDriver).

### Steps to Set Up

1. **Clone the Repository**
   git clone <repository-url>
   cd <repository-directory>
2. **Install Dependencies**
   mvn install
4. **Download WebDriver**
   Place the WebDriver executable in the path/to/chromedriver directory, or update the path in BaseTest.java:
   System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

### Running the Tests
**Running Tests Locally**
You can run the tests locally using your IDE or from the command line.

**Using IDE**
1. Open your project in your IDE (e.g., Eclipse).
2. Right-click on the testng.xml file.
3. Select "Run As > TestNG Suite".
or
1. Open your project in your IDE (e.g., Eclipse).
2. Open the java file from package tests (e.g., testScenarios).
3. Right-click on the file
4. Select "Run As > TestNG Test".

**Using Command Line**
Navigate to the project directory and run:
mvn test

**Running Tests in Parallel**
The tests are configured to run in parallel using the TestNG configuration specified in testng.xml.

**TestNG Configuration**
The testng.xml file is configured to run tests in parallel:

<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="Parallel Test Suite" parallel="tests" thread-count="2">
    <test name="Login Tests">
        <classes>
            <class name="tests.FileListTest"/>
        </classes>
    </test>
</suite>

parallel="tests": Executes tests in parallel.
thread-count="2": Specifies the number of parallel threads.

### Page Object Model (POM)
The framework uses the Page Object Model (POM) design pattern to enhance test maintainability and readability. The pages/ directory contains page object classes, and each page object class is responsible for interacting with a specific page.

### Easy steps to run the project locally - 
1. Clone the repository
2. Open the project in IDE as the existing Maven project
3. Right-click on the project and Run As > Maven clean, then Run As > Maven install - to install all dependencies
4. Chromedriver version 127 is on the path - 
5. The testng.xml file is kept in the root directory
6. Pom.XML file contains all required dependencies 

### Troubleshooting
**WebDriver Issues:** Ensure that the path to the WebDriver executable is correct and that the correct version of the WebDriver is used for your browser.
**Dependencies:** Ensure that all dependencies are correctly added to your project by running mvn install.





