# AA Insurance Automation

This project provides Backend APIs for properties rental websites , IOS and Android devices.

## Getting Started

### Prerequisites

- [Git](https://git-scm.com/) Source Code Management
- [JDK8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) JDK 1.8
- [Maven 3](https://maven.apache.org/download.cgi) Maven Build Tool
- [Junit 4](http://junit.org/junit4/) Unit Testing Tool
- [AA Insurance](https://www.aainsurance.co.nz/) - Website.
- [Cucumber](https://cucumber.io/) - Cucumber
 
### Cucumber Dependencies
    <dependency>
		<groupId>info.cukes</groupId>
		<artifactId>cucumber-java</artifactId>
		<version>1.2.4</version>
	</dependency>
    <dependency>
		<groupId>info.cukes</groupId>
		<artifactId>cucumber-junit</artifactId>
		<version>1.2.4</version>
	</dependency>

### Prepare Test Cases

![](https://raw.githubusercontent.com/lilliancheng2012/lilliancheng2012.github.io/master/public/img/posts/06-12-16/testcases.PNG)

#### Example for feature and step definitions

1. Create test case for AAInsuranceGetQuoteCar.feature
![](https://raw.githubusercontent.com/lilliancheng2012/lilliancheng2012.github.io/master/public/img/posts/06-12-16/BDDFeatures.PNG)
2. Create Step definitions for the AAInsuranceGetQuoteCar.feature
![](https://raw.githubusercontent.com/lilliancheng2012/lilliancheng2012.github.io/master/public/img/posts/06-12-16/StepDefinition1.PNG)
![](https://raw.githubusercontent.com/lilliancheng2012/lilliancheng2012.github.io/master/public/img/posts/06-12-16/StepDefinition2.PNG)
![](https://raw.githubusercontent.com/lilliancheng2012/lilliancheng2012.github.io/master/public/img/posts/06-12-16/StepDefinition3.PNG)
![](https://raw.githubusercontent.com/lilliancheng2012/lilliancheng2012.github.io/master/public/img/posts/06-12-16/StepDefinition4.PNG)
![](https://raw.githubusercontent.com/lilliancheng2012/lilliancheng2012.github.io/master/public/img/posts/06-12-16/StepDefinition5.PNG)
![](https://raw.githubusercontent.com/lilliancheng2012/lilliancheng2012.github.io/master/public/img/posts/06-12-16/StepDefinition6.PNG)
![](https://raw.githubusercontent.com/lilliancheng2012/lilliancheng2012.github.io/master/public/img/posts/06-12-16/StepDefinition7.PNG)
![](https://raw.githubusercontent.com/lilliancheng2012/lilliancheng2012.github.io/master/public/img/posts/06-12-16/StepDefinition8.PNG)

### Add Cucumber report plugin in pom.xml

    <plugin>
		<groupId>net.masterthought</groupId>
		<artifactId>maven-cucumber-reporting</artifactId>
		<version>3.2.0</version>
		<executions>
				<execution>
					<id>execution</id>
					<phase>verify</phase>
					<goals>
						<goal>generate</goal>
					</goals>
					<configuration>
						<projectName>cucumber-jvm-example</projectName>
						<outputDirectory>${project.build.directory}/cucumber-html-reports</outputDirectory>
						<cucumberOutput>${project.build.directory}/cucumber.json</cucumberOutput>
						<parallelTesting>false</parallelTesting>
					</configuration>
				 </execution>
		</executions>
	</plugin>

### Run Test Cases
Run `mvn clean install` to execute test cases.

![](https://raw.githubusercontent.com/lilliancheng2012/lilliancheng2012.github.io/master/public/img/posts/06-12-16/MvnCleanTest.jpg)

After run completed, check the status and results.
![](https://raw.githubusercontent.com/lilliancheng2012/lilliancheng2012.github.io/master/public/img/posts/06-12-16/MvnCleanTestPass.PNG)

### Testing Report

The Cucumber report plugin will generated the report after executing the test cases, go to Project folder, check report under `\target\cucumber-html-reports\cucumber-html-reports`

