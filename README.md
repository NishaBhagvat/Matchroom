# Matchroom

Matchroom test automation framework is designed to cover test automation of https://matchroom.live/ web application. It covers user acceptance and functional tests of the sports filter available in 'OnDemand' feature of the application.

## Description

* This is Selenium webdriver with Serenity-BDD framework which allows to write acceptance test in gherkin languge.
* A test scenario for the feature VOD Filtering has been written in 'VODFiltering.feature' file, and all the steps in feature file have been implemented in 'VODFilteringStepDef' stepdefinition class.
* All the validations take place in 'VODFilteringTest' class. 
* As per POM design pattern, object repository is created in page class 'VODFilteringWebPage' and all actions are defined in the same class. 

## Getting Started

### Tools

* Selenium Webdriver
* Serenity-BDD
* Maven
* Cucumber
* JUnit

### Dependencies

In order to run this project you need to have the following installed locally:

* Firefox/Edge browser to run the test scripts
* Any IDE tool for java like IntelliJ.
* Maven 3

### Installing

* Clone or download this repository to your local machine
* Open the project in your preferred IDE (e.g. Eclipse or IntelliJ)

### Project Structure

<img width="291" alt="Screenshot 2023-01-19 at 21 08 53" src="https://user-images.githubusercontent.com/39000967/213559854-45526fb9-8a60-47b7-85cd-2d2a524da339.png">


### Executing program

* Load the maven dependencies using command 'mvn dependency:resolve' in terminal
* Run the test scripts by command 'mvn clean verify' 
* Or simply execute your test cases by running the MyRunnerTestSuite class

### Reporting

* The framework uses an inbuilt reporting of Serenity. 
* Reports will be generated in the Reports directory after the test execution. 
  */Users-directory/Matchroom/Reports/report - latest-time/index.html*

