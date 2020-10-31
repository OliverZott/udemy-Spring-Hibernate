# Setup and configure project

1.  Setup Project  
	- Create Database and user-access
	- Create Web-Project (Eclipse) with **WebContent** structure  
	- Download MySQL JAR [(Link)](https://dev.mysql.com/downloads/connector/j/)  
	- Create **Servlet** for database connection testing 

1. Setup Dev Environment  
	- `web.xml` and spring config `spring-mvc-crud-demo-servlet.xml`  
	- JAR and JSTL  
		- `javax.servlet.jsp.jstl...`  
		- [(Spring JAR)](https://repo.spring.io/release/org/springframework/spring/)  
		- [(Hibernate JAR)](https://hibernate.org/orm/) in **required** folder / **c3po** in optional folder   
		- >Java9 additional JAR (javax.activation-1.2.0.jar, jaxb-api-2.3.0.jar, jaxb-core-2.3.0.jar, jaxb-impl-2.3.0.jar) butmeanwhile included in **hibernate JARs**  
		
1. Configuration for Spring and Hibernate  (in spring mvc configuration file)  
	- Define database dataSource / connection pool  
	- Setup Hibernate **session factory**  
	- Setup Hibernate **transaction manager**  
	- Enable configuration of transactional annotations  

# Spring-MVC and Hibernate

1. Setup basic infrastructure (Eliminate Tomcat / Eclipse Errors before starting gory database stuff)  

