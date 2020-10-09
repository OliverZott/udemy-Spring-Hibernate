# Udemy -spring-demo-one

[Spring 5 Documentation](https://docs.spring.io/spring-framework/docs/5.2.9.RELEASE/spring-framework-reference/)  
[Spring 4 Documentation](https://docs.spring.io/spring-framework/docs/4.2.4.RELEASE/spring-framework-reference/html/index.html)
## Content
- Configuration:  
    - **IoC**  
    	- 3 ways (XML, XML+annotations, annotations) ...Annotations only:  
    	- @Configuration ...**Configuration class**  
    	- Rest analog to xml version (read config-class / retrieve beans from spring container)
    - **DI** 
        - Constructor injection
        - Setter injection
        - Inject Literals
        - all equal (68)
    - Bean **scope** (lifecycle, amount of instances, how is it shared) 
    (video 43)  
        - default scope: *Singleton* (Prototype, Session,...)
        - *init* / *destroy* methods
    - XML
    - Annotations + XML   
        - enable component scanning in config
        - @Component (ioc)
        - @Autowired (di)   ...also working without autowired on setter / constructor
        https://www.udemy.com/course/spring-hibernate-tutorial/learn/lecture/6933960#questions   
        https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-autowired-annotation
        - @Qualifier ...(tricky with a constructor!)
        - @PostConstruct     @PreDestroy (78 / 89)
    - Annotations (no XML)  
        - @Bean ...Exposure Beans
        - ... DI  
        - ... read Spring-Java Config Class
        - ... retrieve  Bean from Spring Container  
        
- MVC (Chapter 11-17) [docs](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/web.html)  
    - Configuration  
        - `WEB-INF/web.xml` ...
        - ...for configure Spring MVC Servlet Dispatcher
        - ...setup URL Mapping to Spring MVC Servlet Dispatcher
        - `WEB-INF/spring-mvc-demo-servlet.xml` ...
        - ...for Spring Component scanning
        - ...support for conversion, validation, formatting
        - ...configure Spring MVC View Resolver
        - Context-Root [link](https://www.udemy.com/course/spring-hibernate-tutorial/learn/lecture/6724782?%24web_only=true&~channel=email&~stage=published&%24fallback_url=https%3A%2F%2Fwww.udemy.com%2Fcourse%2Fspring-hibernate-tutorial%2Flearn%2F&_branch_match_id=843036747392158573#questions/12748393/&utm_campaign=email&utm_source=sendgrid.com&utm_medium=email)
        [StackOverflow](https://stackoverflow.com/questions/25818429/correct-use-of-getcontextpath-on-jsp)  [doc](https://docs.oracle.com/javaee/1.4/tutorial/doc/JSPIntro7.html)
    - Controller & View  
        - Steps: 
            1. Create Controller 
            1. Define Controller Method
            1. Add Request Mapping
            1. Return View Name
            1. Develop View Page
            1. ERRORS: [Clear Tomcat Cache](https://www.udemy.com/course/spring-hibernate-tutorial/learn/lecture/5609866#questions)
        - **@RequestParam** for Form-Parameter-Binding
        - Parent/Child RequestMapping
    - Model  
        - Download mising **JAR** `https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api/4.0.1`
    - WAR-Files [Link](https://www.udemy.com/course/spring-hibernate-tutorial/learn/lecture/5633776#overview)
    - Form **Tags & Data-Binding**  
      - form:form / select / button / checkbox...for input
      - c:forEach [doc](https://docs.oracle.com/javaee/5/jstl/1.1/docs/tlddocs/c/tld-summary.html)
      - Properties-Files for external data source   
    - Form **Validation**   
    	- Java Bean Validation (specification)  
    	- Hibernate [(Hibernate Validator)](http://hibernate.org/validator/) original ORM also JSR   
    	- `BindingResult` / Errors right behind `@Valid @ModelAttribute...`  [doc](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/web.html#mvc-ann-methods)  
    	- **Developement process** (validation in model (class) -> error msg in template (html) -> validation in controller -> confirmation page update)  
    	- 
      
        
        
        

## Spring Container
[Course Link](https://www.udemy.com/course/spring-hibernate-tutorial/learn/lecture/5181680?start=30#overview)

- Primary Functions 
  - Create and manage objects (Inversion of Control)
  - Inject object's dependencies (Dependency Injection)
 
- Configuration Spring Container 
  - XML config (legacy)
  - Java Annotations (modern)
  - Java Source Code (modern)
 
- Spring Development Process   
  - Configure Spring Beans
  - Create Spring Container (Application Context)
  - Retrieve Beans from Spring Container         
 

### Inversion of Control
[Course Link](https://www.udemy.com/course/spring-hibernate-tutorial/learn/lecture/5181682#overview)  
[Difference: IoC - DI](https://stackoverflow.com/questions/6550700/inversion-of-control-vs-dependency-injection)


### Dependency Injection
[Course Link](https://www.udemy.com/course/spring-hibernate-tutorial/learn/lecture/5205952#overview)

- Constructor Injection  
  - Define dependency interface class
  - Create a constructor for injection
  - Configure DI in Spring config file
- Setter Injection  
  - Create Setter in class
  - Configure DI in Spring config file
- Autowiring 


### Inject Literal Values
- hard-coded in config.xml: `property name=... value=`
- modular in property-file   
  - create property file
  - load property file in Spring config
  - reference values from property file 

 
 
 
# Remarks
**Beans** 
... Java Object created by Spring
https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-introduction 
https://www.udemy.com/course/spring-hibernate-tutorial/learn/lecture/8845630#overview

**Artifacts** [Maven Artifacts](https://stackoverflow.com/questions/2487485/what-is-a-maven-artifact)

**'this'**  
https://stackoverflow.com/questions/2411270/when-should-i-use-this-in-a-class

# Java-Remarks
**.class** ... = getClass()   
https://stackoverflow.com/questions/15078935/what-does-class-mean-in-java

**Array vs ArrayList**   
https://www.geeksforgeeks.org/array-vs-arraylist-in-java/