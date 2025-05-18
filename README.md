**Pet Sore API Automation Framework**

This is a REST-assured API automation framework built using **Java**, **RestAssured**, **Cucumber**, and **Maven**. It is designed to perform regression testing on the PetStoe Api.

**Attributes:**
- Maven-based project structure for dependency management through POM.xml file
- REST API automation using **RestAssured**
- **BDD**-style scenarios with **Cucumber**
- Regression suite covering **Pet** entities
- **Cucumber HTML Report** generation
- CI run via **GitHub Actions CI**

**Steps to Project Execution**
-----------**On Local**:------------------
1. **Clone the code from the github respository on your Local machine**
   - git clone https://github.com/<githubuser>/cbatest.git
   - cd cbatest

2. **Set up System Pre requisites**:
   - Install Java 11 or higher
   - Maven 3.x
   - Internet access to download maven repositories

3. **RUn the test**
   - mvn test verify
   -This command will:
     - Execute all Cucumber BDD scenarios
     - Perform regression testing on Petstore APIs
     - Generate reports
    
  
**Steps to Project Execution**
-----------**GITHUB Actions**:------------------

This project is also configured to run in a CI/CD pipeline using GitHub Actions.
Navigate to the Actions tab in this repository to view the latest CI run.
**Workflow file: Run API Tests **


**View Test Report**
  - After test execution, refresh the project and open the Cucumber HTML report:
  - Get reports at location : /target/cucumber-html-reports/overview-features.html
  - You can open it in your browser to view a detailed summary of test results.
  - Pass and Fail summary will be displayed as below:

![image](https://github.com/user-attachments/assets/4dc5f2cb-cccf-4f2a-9232-7b8984521e9a)


**View logs**
 -  After test execution logs can be accessed at location : /target/logs/logging.txt
