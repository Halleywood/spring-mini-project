# Chickstagram 🐔💞
a RESTful API application where people can register and share egg-cellent information about their chickens. Application users can create, modify, and delete their chickens entries as well as like other users chickens. 🐣🥚
***
### Table of Contents 
1. [Tools/Technologies](#tools)
2. [My Approach](#summary)
3. [Problems/Hurdles](#problems)
4. [User Stories](#userstories)
5. [ERD](#erd)
6. [Planning](#planning)
7. [Install and Get Started](#install)

***
### Tools/Technologies Used <a name="tools"></a>
* Java Spring Boot and Java Spring Framework
* Postgres database
* JPA (Java Persistence API) for object-relational mapping and data persistence
* Spring Security was then installed to ensure registered user is authorized 
* JSON Web Tokens for user authentication
***
### Brief Summary Of Approach <a name="summary"></a>
order of operations???  
Creating the models  
creating entities and using JPA for ORM   
connecting models together 
Controller  
Service  
Repository  

| Request Type | URL                       | Functionality                                                        |
|--------------|---------------------------|----------------------------------------------------------------------|
| POST         | /auth/users/register      | a person can register to be a user                                   |
| POST         | /auth/users/register      | a user can log in securely, receiving a JWT to access following URLs |
| GET          | /api/chickens             |                                                                      |
| GET          | /api/chickens/{chickenId} |                                                                      |
| POST         | /api/chickens             |                                                                      |
| PUT          |                           |                                                                      |
| DELETE       |                           |                                                                      |
| GET          |                           |                                                                      |
| GET          |                           |                                                                      |
| PUT          |                           |                                                                      |
| DELETE       |                           |                                                                      |
| GET          |                           |                                                                      |
| GET          |                           |                                                                      |

***
### Unsolved Problems/Hurdles <a name="problems"></a>
definitely getting OneToOne and Many to Many relationships to link
***
### Link To User Stories <a name="userstories"></a>
link to user stories project kanban board!  
Link to table of routes here???
***
### Link To ERD Diagram <a name="erd"></a>
here I need to put picture of ERD and discuss relationships 
***
### Link to Planning Documentation <a name="planning"></a>
You need excel sheet here! or link to other project kanban board???
***
### Installation for any dependencies <a name="install"></a>
spring io documentation! 