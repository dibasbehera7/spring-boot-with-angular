# Spring Boot with Angular
A Secure Single Page Application based on Spring Boot


## Create a New Project
We are going to step through creating this application in some detail, so that anyone who isn't completely au fait with Spring and Angular can follow what is happening. There are various options for creating a new project:


## Step 1: setup your Spring Boot application
Go ahead and initialize your Spring boot application anyway you like. I personally find https://start.spring.io/ a convenient way to get started, so I’m going to go ahead and generate a Maven Spring Boot application, with a Web dependency.

![image](https://user-images.githubusercontent.com/24310550/80279184-7bd96b80-8719-11ea-8656-46aeecf400f0.png)

When you’re all setup and ready, open the project with your favorite IDE.

![image](https://user-images.githubusercontent.com/24310550/80279215-a62b2900-8719-11ea-8d19-b31736cde9c2.png)

Let’s setup a restcontroller quickly and get a response back from the web server to make sure everything is working fine
if we run it and navigate to http://localhost:8080 this should be the result:

![image](https://user-images.githubusercontent.com/24310550/80279244-da064e80-8719-11ea-810b-325488cd5a5b.png)

If everything works fine, go back to the class RestController class and remove the following code:

[source]
----
	@RequestMapping
	public String welcome(){
		return "It's works!!!";
	}
----

## Step 2: setup your Angular application

Start by creating a new directory called frontend (under resources), and navigate in your terminal to it src/main/resources/frontend/
Run the command ng new angular-app to create a new angular project within our Spring Boot project.

![image](https://user-images.githubusercontent.com/24310550/80279280-281b5200-871a-11ea-88dd-61881c6e2ed0.png)

Now we need to change the configuration in such a way that Angular can build it’s files and provides them for Spring Boot to use. To do that we must edit the angular.json file and change the outputPath value to generate the build files in src/main/resources/public/ directory of the project.

![image](https://user-images.githubusercontent.com/24310550/80279302-4f721f00-871a-11ea-9798-693771f25d4a.png)

In order to inform Maven that the Angular project needs to be compiled first before the Spring Boot files we need to inset a plugin into the pom.xml file:

![image](https://user-images.githubusercontent.com/24310550/80279314-72043800-871a-11ea-9b70-e31254c3374d.png)

![source]
----
			<plugin>
				<groupId>org.codehaus.mojo</groupId>
				<artifactId>exec-maven-plugin</artifactId>
				<version>1.6.0</version>
					<executions>
						<execution>
							<phase>validate</phase>
							<goals>
								<goal>exec</goal>
							</goals>
						</execution>
					</executions>
					<configuration>
						<executable>ng</executable>
						<workingDirectory>src/main/resources/frontend/angular-app</workingDirectory>
						<arguments>
							<argument>build</argument>
						</arguments>
					</configuration>
			</plugin>
----


## Step 3: package your project
From the root of the project, type mvn package. Maven will now build the Angular project and place the files in the public directory.
![image](https://user-images.githubusercontent.com/24310550/80279490-af1cfa00-871b-11ea-9d99-61558d4a99a9.png)

## Done:
Now navigate %WORKSPCAE%\spring-boot-angular\target> and go ahead, run your jar using java -jar spring-boot-angular-0.0.1-SNAPSHOT.jar and navigate to http://localhost:8080, you should see the the default Angular project index.html:

![image](https://user-images.githubusercontent.com/24310550/80280720-74b75b00-8723-11ea-82a2-00911fb96ffb.png)



NOTE: all Copyright reserved.
