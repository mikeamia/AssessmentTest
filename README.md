# AutomationTest

Desc:
- use OOP can be describe on StepDefinition.java
- use POM concept can be describe on "pages" package
- use BDD Gherkin approach to make stakeholder easy to read the scenario
- use extent report to make readable report result




Prerequisite apps installed:
- apache maven (set the PATH in environment variable)
- Java JDK 1.8 (set the PATH in environment variable)


How to run:
- Clone or download this code
- Extract in C:\
- Replace chromedriver (In directory 'driver') with your current version
- Replace path in src\test\java\extentReports\Configuration.properties (path for export the report result)
- Open command prompt
- type "cd \" then "cd: C:Assessment1" (without quotes)
- Install the required library using command
     mvn clean install
- Run the test with
     mvn clean verify
- See the report in "target\cucumber-reports\report.html"