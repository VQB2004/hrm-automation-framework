# 🚀 HRM Automation Testing Framework

## 📌 Overview
A **Java-based Selenium Automation Testing Framework** for testing a Human Resource Management (HRM) web application.  
The framework is designed following **industry best practices**, focusing on **maintainability, scalability, and reusability**.

---

## 🛠️ Technologies & Tools
- Selenium WebDriver  
- TestNG  
- Maven  
- Page Object Model (POM)  
- Allure Report  

---

## ✨ Key Skills Demonstrated
- UI automation testing with Selenium WebDriver  
- Test framework design using TestNG  
- Page Object Model (POM) architecture  
- Data-driven testing with DataProvider  
- Reusable keywords and utility methods  
- Test execution reporting with Allure  

---

## 📂 Project Structure
hrm-automation-framework
│
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.quocbao.hrm/
│   │   │       ├── drivers/        # WebDriver initialization and lifecycle management
│   │   │       ├── helpers/        # Config, Excel, and system utilities
│   │   │       ├── keywords/       # WebUI keyword wrapper for Selenium actions
│   │   │       ├── reports/        # Allure report configuration
│   │   │       └── utils/          # Logging
│   │   │
│   │   └── resources/             
│   │
│   └── test/
│       ├── java/
│       │   └── com.quocbao.hrm/
│       │       ├── dataproviders/  # Data-driven testing (TestNG DataProvider)
│       │       ├── listeners/      # TestNG & Allure listeners
│       │       ├── pages/          # Page Object Model (POM)
│       │       └── testcases/      # Test cases / test scenarios
│       │
│       └── resources/
│           ├── configs/            # Test environment configurations
│           ├── data/               # Test data files
│           └── suites/             # TestNG suite XML files
│
├── pom.xml                    # Maven configuration & dependency management
├── README.md                  # Project documentation

---

## 🧪 Test Coverage
- Login functionality
- CRUD operations for Project Management
- File upload validation
- Regression testing on Project Management flows

---

## 📊 Reporting
- Integrated **Allure Report**
- Step-level test execution details
- Screenshot capture on test failure
