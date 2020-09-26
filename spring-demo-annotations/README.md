# Udemy -spring-demo-one
**Configuration with Java Annotations**  
Chapter 7 / 8 / 9
## Content
- Configuration:  
    - **IoC**
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
    - Annotations   
        - enable component scanning in config
        - @Component (ioc)
        - @Autowired (di)   ...also working without autowired on setter / constructor
        https://www.udemy.com/course/spring-hibernate-tutorial/learn/lecture/6933960#questions   
        https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-autowired-annotation
        - @Qualifier ...(tricky with a constructor!)
    - Pure Java

  


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

**'this'**  
https://stackoverflow.com/questions/2411270/when-should-i-use-this-in-a-class

# Java-Remarks
**.class** ... = getClass()   
https://stackoverflow.com/questions/15078935/what-does-class-mean-in-java

**Array vs ArrayList**   
https://www.geeksforgeeks.org/array-vs-arraylist-in-java/