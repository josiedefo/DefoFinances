------- DefoFinances Web Application -------------

Money Management Web Application for Defo family 

Technology Stack
- Java 
- Spring 
- SpringBoot to create a stand-alone Spring application
- Hibernate / JPA  to model the data 
- H2 Database  (embedded) 
- Apache Tomcat (embedded) 
- HTML / Thymeleaf / Bootstrap to view the content  
- Spring Security to ensure authentication before viewing all transactions

Features
- Login (with user: josie and password: 2512)
- View all transactions loaded in db 
- Add a Transaction (manually)


------- Run the aplication 

-- Requirement: 
1) Java is installed
2) Maven is set in the environment variables 



---- Run 
1) clone (Git) project on your local 
2) navigate to Defo-Finances/ folder 
3) run 'mvn clean package' to build the executable jar 
4) run 'java -jar target\Defo-Finances-0.0.1-SNAPSHOT.jar' to run the application
5) In a browser, navigate to http://localhost:8080/transactions


