# Account System in Java 

This program has developed in Java 17 using Spring Boot 3.3.4, Gradle and PostgreSQL 17 for database.

## How execute the program?

### Database Configuration

First create an empty database in Postgres, in this case I use the default user and port of Postgres. If you need to update the settings of database, you can update the file application.properties. However if you want to use the same default 
settings, just set the same variables you can see in this image:

![image](https://github.com/user-attachments/assets/3af822be-cb11-499e-9a6d-835fec3560a3)

However, if you want to restore a database, there is a backup file in "sql" folder:

![image](https://github.com/user-attachments/assets/f52e646d-c5fc-4b7a-b8b5-44c8927fb593)

### Run Program

To run the program, open the "accountsystem" folder in your IDE. The java project was made using Gradle, so check it first in your IDE. Execute The program in your IDE and you will something like this:

![image](https://github.com/user-attachments/assets/7100a93d-017a-4166-916c-648c9201cfd8)

![image](https://github.com/user-attachments/assets/3df25efc-0184-42e7-8220-286d580f3f0f)

If is the first time you run the program, it will create the tables to database automatically.

### How to prove it?

In "postman" folder, you will see a collection file of Postman in JSON. If you import it. You will see this folders with all data you need, so just run it one by one:

![image](https://github.com/user-attachments/assets/ed9694f8-bf91-4486-85ac-6ac858a3d930)

### Funcionality Examples

After run in Postman the POST options, you can check by ID or get all registers:

![image](https://github.com/user-attachments/assets/60c4056a-49c7-47a0-ad52-8a15d1b2932b)

![image](https://github.com/user-attachments/assets/a0b51559-d476-47e8-881e-a989dca37964)

![image](https://github.com/user-attachments/assets/d98a7eab-4468-43fd-9e62-b199ee263b73)

![image](https://github.com/user-attachments/assets/4c5e8165-da9a-485c-a4c8-2b28b66b9878)

![image](https://github.com/user-attachments/assets/39456905-9ddf-430b-a540-6ed46bcc3614)









