# Hibernate

- sudo /opt/lampp/lampp start  
- localhost/phpadmin or workbench

## Initialize Project
1. Create Project  

1. Hibernate JAR files (only required ones)  
https://hibernate.org/orm/releases/5.4/

1. MYSQL Connector JAR files  
https://dev.mysql.com/downloads/connector/j/

1. Add JAR files to project
[IntelliJ](https://stackoverflow.com/questions/1051640/correct-way-to-add-external-jars-lib-jar-to-an-intellij-idea-project)   
[Eclipse](https://stackoverflow.com/questions/3280353/how-to-import-a-jar-in-eclipse)
Now new dir in project ("Reference Libraries" in Eclipse)


## Hibernate Development Process
1. Add Hibernate Config file `hibernate.cfg.xml` ...tell hibernate hot to connect to database  
[Session context/management](https://stackoverflow.com/questions/34859136/using-hibernate-thread-session-context-in-production)

1. Annotate Java Class  `Entity Class`  
**Best Practice:** Use JPA Annotations (API in package: `javax.persistence`)
    - Map class to db-table
    - Map fields to table-columns  
    
1. HQL - Develop code to perform db-operations  
    - `SessionFactory` read hibernate config, creates sessions, only once created
    - `Session` wraps JDBC-connection , used to save/retrieve objects, short-lived object
    - CREATE `session.save()`
    - GET `session.get()` or with query 
    - UPDATE
        - `session.createQuery("HQL").getResultList();`  
        - `session.createQuery("HQL").executeUpdate()`  (single update just get and commit)
    - DELETE `session.delete()` or with query 
    - [Criteria vs HQL](https://sites.google.com/site/anaki808built/hibernate/when-to-use-hql-or-criteria-queries)

1. SQL
    1. **Primary Key**  
        - unique / not-null
        - Alter primary key `ALTER TABLE hb_student_tracker.student AUTO_INCREMENT=3000`
        - delete data `TRUNCATE hb_student_tracker.student`
    
    
<br>
<br>
<br>

## Complete Project Examples
https://javawebtutor.com/articles/spring/spring-mvc-hibernate-crud-example.php    
http://zetcode.com/spring/propertyplaceholder/   
    

<br>
<br>
<br>

## Remarks:
- [try with resources management](https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html)
- [Create table with java code](https://www.dineshonjava.com/hibernate/hbm2ddl-configuration-and-name/)