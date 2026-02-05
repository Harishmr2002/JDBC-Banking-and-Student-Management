### **🏦 Banking \& 🎓 Student Management Console Application (Java + JDBC)**



This repository contains two Java console-based applications built using Core Java and JDBC to demonstrate database connectivity, transactions, and CRUD operations.



#### **📌 Projects Included**



###### **1️⃣ Banking Console Application**



* A simple banking system that allows users to:
* Login using Account Number \& PIN
* Check account balance
* Transfer money securely between accounts
* Perform transactions with commit \& rollback



###### **🔑 Features**



* User authentication
* Balance inquiry
* Money transfer
* Prevents self-transfer
* Transaction management using JDBC
* Auto-commit disabled for safe money transfer



###### **2️⃣ Student Management Console Application**



* A CRUD-based student management system that allows:
* Insert student details
* Insert multiple students using transactions
* Update student information
* Delete student records
* Fetch student details using SID



###### **📚 Features**



* Add single \& multiple students
* Update student name
* Delete student by ID
* Fetch specific student data
* Uses PreparedStatement for security
* Transaction handling for bulk insert



###### **🛠️ Technologies Used**



**Java (Core Java)**



* JDBC
* MySQL
* SQL
* Eclipse / IntelliJ IDEA
* Git \& GitHub



**🗂️ Project Structure**



**Banking-Student-Management/**

│

├── bank/

│   └── Bank.java

│

├── student/

│   ├── InsertingStudentInformation.java

│   ├── Transaction.java

│   ├── UPDATESTUDENTINFORMATION.java

│   ├── deletestudentinformatiom.java

│   └── fetchingspecificdata.java

│

├── db/

│   └── Myconnection.java

│

└── README.md



###### **🗄️ Database Details**



**🔹 Banking Table**



CREATE TABLE accounts (

&nbsp;   accountN0 INT PRIMARY KEY,

&nbsp;   name VARCHAR(50),

&nbsp;   pin INT,

&nbsp;   balance INT

);



**🔹 Student Table**



CREATE TABLE student (

&nbsp;   sid INT PRIMARY KEY,

&nbsp;   sname VARCHAR(50),

&nbsp;   age INT

);



###### **🚀 How to Run the Project**





1. **Clone the repository:**



git clone https://github.com/your-username/your-repo-name.git





2\. **Open the project in Eclipse / IntelliJ**



3\. **Configure database connection in Myconnection.java**



4\. **Run:**



* Bank.java for Banking Application
* Student classes for Student Management operations



###### **🔐 JDBC Concepts Used**



* Connection
* PreparedStatement
* ResultSet
* Transactions (commit, rollback)
* Auto-commit handling
* Exception handling
