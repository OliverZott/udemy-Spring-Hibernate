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
    1. Map class to db-table
    1. Map fields to table-columns

1. Develop code to perform db-operations