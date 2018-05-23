Author: Tan Lee Chiang
Company: Cognizant Technology Solution
Title: Technology Architect
Date: 23-May-2018
=======================================
Application Structure Explaination
=======================================
com.cts.mom.assign: This package contains the main package of the program
com.cts.mom.assign.controller: This package contains the classes that controls the flow of the program
com.cts.mom.assign.service: This package contains the business service classes that implements the business logics
com.cts.mom.assign.model: This package contains the data transfer objects
com.cts.mom.assign.view: This package contains the classes that helps to render the display based on the model objects
com.cts.mom.assign.util: This package contains the classes that performs the common utilties such as loading from properties file etc.

========================================
Design Pattern Used
========================================
Factory Design pattern used in this application for future scalability such as having more than 
just MAS interface.

Model-View-Controller pattern is used in the entire structure of this application.
Model classes are mainly on storing the data.
View classes are mainly on displaying and rendering logic.
Controller is where the sequence of flow among views.
The reason is because if in future the application has to move to a different interface such as
web based or mobile based then most the logic and model can be reused. 

Business Delegate pattern is used in the application.
The reason is the details of making calls to MAS API is been encapsulated from the rest of the program.
This makes it loosely coupled and aligns to Open Closed software design principle. 
It means Open for extension but closed for modification.

=========================================
Build and Run
=========================================
I have adopted Gradle 3.5 as the build tool.
First in command prompt where the build.gradle is found MomAssign/

gradle clean build

to build

Secondly, in the same location run the following command to create a jar

gradle jar

Run the program by

java -jar build/libs/mom_tech_assign.jar <from-date> <to-date>

<from-date> and <to-date> should be in mmm-yyyy eg Jan-2017

The mmm or month is case insensitive







