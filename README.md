# Chickstagram 🐔💞
a RESTful API application where people can register and share egg-cellent information about their chickens. Application users can create, modify, and delete their chickens entries as well as like other users chickens. 
***
### 🐣Table of Contents 
1. [Tools/Technologies](#tools)
2. [My Approach](#summary)
3. [Problems/Hurdles](#problems)
4. [User Stories](#userstories)
5. [ERD](#erd)
6. [Planning](#planning)
7. [Install and Get Started](#install)

***
### 🥚Tools/Technologies Used <a name="tools"></a>
* Java Spring Boot and Java Spring Framework
* Postgres database
* JPA (Java Persistence API) for object-relational mapping and data persistence
* Spring Security was then installed to ensure registered user is authorized 
* JSON Web Tokens for user authentication
***
### 🐣 Brief Summary Of Approach <a name="summary"></a>
For this project I took a very linear approach. It was easier for my to use a GitHub project board and write each step as a To-Do. Once I finished a step I pushed to my git hub and reran my server so that I didn't write too much code before testing. 

The premise was to create the models, map the models to eachother and use those relationships to write database queries. I used the ModelViewController design principle to separate the logic needed to take a user request from the database and the corresponding response. There is a Controller class that handles all of the routes, that talks to a Service class that handles all of the business logic. The Service class talks to the model repository which retrieves the information from databse using JPA. So the data is protected by many layers.  

Here is a link to my project planning. As you can see it is very long but very specific and detail oriented.   
[Project Board/ To-Do List](#https://github.com/users/Halleywood/projects/9)

Here are all of the routes created in my API along with their type of request and functionality. 

| Request Type | URL                                    | Functionality                                                                  |
|--------------|----------------------------------------|--------------------------------------------------------------------------------|
| POST         | /auth/users/register                   | a person can register to be a user                                             |
| POST         | /auth/users/register                   | a user can log in securely, receiving a JWT to access following URLs           |
| GET          | /api/chickens                          | see all the types of chickens                                                  |
| GET          | /api/chickens/{chickenId}              | see details about a specific chicken                                           |
| POST         | /api/chickens                          | make a chicken entry                                                           |
| PUT          | /api/chickens/{chickenId}              | if you are the user who created this chicken entry, you can update it          |
| DELETE       | /api/chickens/{chickenId}              | if you are the user who created this chicken entry, you can delete it          |
| GET          | /api/chickens/eggs                     | get all of the eggs from all of the chickens                                   |
| GET          | /api/chickens/{chickenId}/eggs/{eggId} | get specific egg of specific chicken                                           |
| POST         | /api/chickens/{chickenId}/eggs         | create an egg for a chicken you created                                        |
| PUT          | /api/chickens/{chickenId}/eggs/{eggId} | if you are the user who create the chicken entry, you can add an egg type      |
| DELETE       | /api/chickens/{chickenId}/eggs/{eggId} | if you are the user who created the chicken entry, you can delete the egg type |
| GET          | /api/chickens/{chickenId}/likes        | see the number of users that like a specific chicken                           |
| GET          | /api/chickens/like/{chickenId}         | a user can like a chicken and add it to their list of favorites                |

***
### 🥚 Unsolved Problems/Hurdles <a name="problems"></a>
I had a very hard time getting my model relationships right. I had created a User and a Chicken entity, but was not saving the user_id on my Chicken entities. Once I installed Spring Security and needed to run my JPA queries with a userId, I was unable to successfully return anything because my Optional Chicken or Optional Egg was returning Null because the userId was null. That took me more time than I would like to admit to debug and solve. Once I was able to correctly link my tables, I was able to successfully query the database with a User id and an entity id.   

I also wanted to try and create a Many-To-Many relationship and make URL endpoints to retrieve that relational data. While it was a noble attempt I do not think I was successful at linking those tables properly. 
***
### 🐣 User Stories <a name="userstories"></a>
For every application there should be a user story! These are the user stories I created for my MVP application: 
*   bullet one
  * bullet two 
  * bulltet three
  * bullet four 
  * bullet five 
  * bullet six 

***
### 🥚 Link To ERD Diagram <a name="erd"></a>
![crows feet diagram]("C:\Users\kelse\Desktop\crowsfeetERD.png")
***
### 🐣 Link to Planning Documentation <a name="planning"></a>
You need excel sheet here! or link to other project kanban board???
***
### 🥚 Installation for all Dependencies <a name="install"></a>
[Spring Boot Starter](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter/3.0.6)  
[Spring Boot Starter Test](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test/3.0.6)  
[Spring Boot Starter Web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web/3.0.5)  
[PostGres Driver](https://mvnrepository.com/artifact/org.postgresql/postgresql/42.6.0)  
[Spring Boot Data Jpa](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa/3.0.6)  
[Spring Security](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security)