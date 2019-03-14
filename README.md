## Test Automation Framework Training

Test automation framework built for training purposes
Amazon (Europe location) was selected as demo website.

### Setup
* Install [Java SE Development Kit 8u201](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* Install [Eclipse IDE](https://www.eclipse.org/downloads/)
* Install [Apache Maven 3.6.0](https://maven.apache.org/download.cgi)
* Make sure jdk1.8.0 is used by Eclipse
![Installed JREs - jdk1.8.0_](https://i.ibb.co/PjMnTgc/jdk180.png) 
<!-- .element height="50%" width="50%" -->
* Import AmazonMaven project from file system
* Update Project with Maven if it haven't updated yet
![Maven Update Project](https://i.ibb.co/QXnL6yz/Maven-Update-Project.png)
<!-- .element height="50%" width="50%" -->
* Run testng.xml As TestNG Suite
![Maven Update Project](https://i.ibb.co/JyHgM2J/Test-NGrun.png)
<!-- .element height="50%" width="50%" -->


### Built With
* Selenium-Java
* TestNG

### Maven pom.xml
<details>
  <summary>Click to expand!</summary>

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	
	<groupId>AmazonMaven</groupId>
	<artifactId>AmazonMaven</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>
	
	<name>AmazonMaven</name>
	<url>http://maven.apache.org</url>
	
	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	</properties>
	
	<dependencies>
		<dependency>
	      <groupId>org.seleniumhq.selenium</groupId>
	      <artifactId>selenium-java</artifactId>
	      <version>3.141.59</version>
	    </dependency>

	    <dependency>
	      <groupId>org.testng</groupId>
	      <artifactId>testng</artifactId>
	      <version>6.11</version>
	      <scope>compile</scope>
	    </dependency>

		<dependency>
		    <groupId>log4j</groupId>
		    <artifactId>log4j</artifactId>
			<version>1.2.17</version>
		</dependency>

		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-simple</artifactId>
			<version>1.7.26</version>
	  	</dependency>

		<dependency>
			<groupId>org.apache.poi</groupId>
	    	<artifactId>poi</artifactId>
	    	<version>4.0.1</version>
		</dependency>

		<dependency>
		    <groupId>org.apache.poi</groupId>
		    <artifactId>poi-ooxml</artifactId>
		    <version>4.0.1</version>
		</dependency>

		<dependency>
			<groupId>io.github.bonigarcia</groupId>
			<artifactId>webdrivermanager</artifactId>
			<version>3.3.0</version>
		</dependency>
	</dependencies>
	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.3</version>
				<configuration>
					<source>1.8</source>
					<target>1.8</target>
				</configuration>
			</plugin>
		</plugins>
	</build>
</project>
```
</details>
