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

<br>

## Hibernate Development Process
1. Add Hibernate Config file `hibernate.cfg.xml` ...tell hibernate hot to connect to database  
[Session context/management](https://stackoverflow.com/questions/34859136/using-hibernate-thread-session-context-in-production)

1. Annotate Java Class  `Entity Class`  
**Best Practice:** Use JPA Annotations (API in package: `javax.persistence`)  

    - Map class to db-table
    - Map fields to table-columns  
    
1. HQL - Develop code to perform db-operations [(HQL Syntax)](https://www.tutorialspoint.com/hibernate/hibernate_query_language.htm)

    - `SessionFactory` read hibernate config, creates sessions, only once created
    - `Session` wraps JDBC-connection , used to save/retrieve objects, short-lived object
    - CREATE `session.save()`
    - GET `session.get()` or with query 
    - UPDATE
        - `session.createQuery("HQL").getResultList();`  
        - `session.createQuery("HQL").executeUpdate()`  (single update just get and commit)
    - DELETE `session.delete()` or with query 
        [(3 ways to delete)](https://www.codejava.net/frameworks/hibernate/hibernate-basics-3-ways-to-delete-an-entity-from-the-datastore)
    - [Criteria vs HQL](https://sites.google.com/site/anaki808built/hibernate/when-to-use-hql-or-criteria-queries)
    
1. DateTime in table  
    - Alter database table  
    - Class for parsing&formatting dates `DateUtils`   
    - Add field to Class

1. SQL
    1. **Primary Key**  
        - unique / not-null
        - Alter primary key `ALTER TABLE hb_student_tracker.student AUTO_INCREMENT=3000`
        - delete data `TRUNCATE hb_student_tracker.student`
    1. **DateTime** vs **Timestamp** [(Link)](https://www.tutorialspoint.com/What-is-the-difference-between-MySQL-DATETIME-and-TIMESTAMP-data-type)

#### Best Practice 
https://thorben-janssen.com/hibernate-best-practices/  
https://thorben-janssen.com/hibernate-best-practices-for-readable-and-maintainable-code/

<br>

## Advanced Mapping
- https://stackoverflow.com/questions/55400177/hibernate-jpa-mappedby-vs-owner-of-the-relation-cascades
- https://www.baeldung.com/jpa-joincolumn-vs-mappedby
- https://www.udemy.com/course/spring-hibernate-tutorial/learn/lecture/9195648#questions/11856864
- https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/
- https://stackoverflow.com/questions/25053792/who-is-owner-in-association-with-jpa-and-hibernate


- Owning side identification: 
    - table contains foreign_key
    - mappedBy refers to owner (thus is placed on child side)  
    - ManyToOne association on the child side ?!
    
1. One-To-One  
    - Database table definition `foreign key`
    - Map classes correctly  `@OneToOne` `@JoinColumn(name=...)`

1. One-To-Many  
    - `@ManyToOne`  
    - `List<>` field with `add()` method
    
1. Basics  
    - `save()` vs `persist()` [(Link)](https://www.udemy.com/course/spring-hibernate-tutorial/learn/lecture/8058282#questions/12499548)
    - Entity Lifecycle [(Link)](https://www.udemy.com/course/spring-hibernate-tutorial/learn/lecture/7667988#questions)
        - Detach, Merge, Persist, Remove, Refresh  
        - [(Link1)](https://www.objectdb.com/java/jpa/persistence/managed) 
        [(Link2)](https://www.baeldung.com/hibernate-entity-lifecycle)
    - Cascade Types [(Links)](https://www.udemy.com/course/spring-hibernate-tutorial/learn/lecture/7667990#questions)
        - "sync" related entity (respective foreign key)
        - Persist, Remove, Refresh, Detach, Merge, All   ...can use various  
        - 
    - Reverse Engineer Diagram !
    - **Question**  
        - [Sql statement](https://www.udemy.com/course/spring-hibernate-tutorial/learn/lecture/7668004#questions/11992872)
        - [IntelliJ Debugging](https://www.udemy.com/course/spring-hibernate-tutorial/learn/lecture/7668004#questions/12576376)


    
    
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
- **JPA** `Entity Manager` vs **Hibernate** `Session`
- **List<>** vs **ArrayList<>**  [(Link)](https://techdifferences.com/difference-between-list-and-arraylist-in-java.html)
- [try with resources management](https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html)
- [Create table with java code](https://www.dineshonjava.com/hibernate/hbm2ddl-configuration-and-name/)
- [MySQL Indexing](https://dev.mysql.com/doc/refman/8.0/en/mysql-indexes.html)
- [MySql index and foreign keys](https://dev.mysql.com/doc/refman/5.7/en/create-table.html#create-table-indexes-keys)
