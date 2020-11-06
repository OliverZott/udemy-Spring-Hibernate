# Setup and configure project

1.  Setup Project  
	- Create Database and user-access
	- Create Web-Project (Eclipse) with **WebContent** structure  
	- Download MySQL JAR [(Link)](https://dev.mysql.com/downloads/connector/j/)  
	- Create **Servlet** for database connection testing
	https://docs.spring.io/spring-framework/docs/3.0.x/spring-framework-reference/html/mvc.html#mvc-servlet

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
	
### Remarks
- before all Hibernate config was in `hibernate.cfg.xml` because we didn't use Spring

# Spring-MVC and Hibernate
ToDo:
- Create Entity
- Create DAO and DAO implementation
- Create Controller
- Create JSP

- also: Handle all DI / Spring MVC config ...

1. Setup basic infrastructure (Eliminate Tomcat / Eclipse Errors before starting gory database stuff)  
    - Simple Controller + View 
    
1. Entity  
    - **Create Entity** with all Annotations
    - **Entity Scanning** is configured in `SessionFactory`-**Bean** in Spring-MVC config file

1. DAO  
    - Interface and Implementation (SessionFactory is injected)
    - DI: SessionFactory (needs DataSource)
    - DI: DataSource injected into SessionFactory in MVC-Config file  (line 47)
    - Annotations: `@Repository` `@Transactional`
    
1. Controller     
    - **DI - DAO** into Controller


#### Improvement Changes
1. Use Constructor-Injection instead field injection
1. Make SessionFactory a Singleton and inject it
https://www.onlinetutorialspoint.com/hibernate/singleton-hibernate-sessionfactory-example.html

# Resources and Remarks
- Best practice **Dependency-Injection** [(Link)](https://stackoverflow.com/questions/39890849/what-exactly-is-field-injection-and-how-to-avoid-it)

