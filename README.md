# SauceDemo Test Automation Web Project

This repository contains a functional test automation framework for the website [https://www.saucedemo.com/](https://www.saucedemo.com/).

## ✨ Framework Features

  * **Page Object Model (POM)**: The project is architected using the POM design pattern, which separates test logic from UI element definitions.
  * **Selenium PageFactory**: It leverages the `@FindBy` annotation and the `PageFactory` class to initialize WebElements in an efficient and readable manner.
  * **Centralized Wait Handling**: A utility class has been implemented to centrally manage explicit waits (`WebDriverWait`).
  * **TestNG Listeners**: The framework uses TestNG Listeners (`ITestListener`) to enhance reporting and event handling during test execution. 
  * **TestNG Test Suites**: Tests are organized into suites (`.xml` files).
  * **Maven Dependency Management**: All project libraries and dependencies are managed through Maven.

## 🛠️ Technology Stack

  * **Language**: Java 24
  * **Automation Tool**: Selenium WebDriver
  * **Testing Framework**: TestNG
  * **Project & Dependency Management**: Apache Maven
  * **WebDriver Management**: WebDriverManager

## 📂 Project Structure

The project follows a standard Maven and POM structure to ensure clarity and separation of concerns:

```
.
├── src
│   ├── main
│   └── test
│       ├── java
│       │   └── com
│       │       └── globant
│       │           ├── base      # Base classes (BaseTest, BasePage)
│       │           ├── pages     # Page Object classes for each page
│       │           ├── tests     # TestNG test classes
│       │           └── utils     # Utility classes (WaitManager, etc.)
│       └── resources
│           └── testSauceDemo.xml # Suite for cart-specific tests
└── pom.xml                       # Maven configuration file
```

## 🚀 Getting Started

Follow these steps to clone and run the project on your local machine.

### Prerequisites

  * **Java JDK 24** or higher must be installed.
  * **Apache Maven** must be installed.
  * **Git** must be installed.

### Installation and Setup

1.  **Clone the repository:**

    ```sh
    git clone https://github.com/Valentina-Londono/web-automation-saucedemo.git
    ```

2.  **Navigate to the project directory:**

    ```sh
    cd web-automation-saucedemo
    ```

3.  **Install Maven dependencies:**
    This command will download all the necessary libraries defined in the `pom.xml` file.

    ```sh
    mvn clean install
    ```

## ⚡ Running the Tests

You can run the automated tests in two ways:

### 1\. From the Command Line (using Maven)

  * **To run the main suite (all tests):**

    ```sh
    mvn clean test
    ```

### 2\. From an IDE (IntelliJ IDEA / Eclipse)

1.  Import the project as a Maven project.
2.  Ensure all dependencies have been downloaded.
3.  Navigate to the `src/test/resources/` folder.
4.  Right-click on the `testSauceDemo.xml` suite file.
5.  Select **"Run '...testSauceDemo.xml'"**.

-----
