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
For this project I took a very linear approach. It was easier for my to use a GitHub project board and write each step as a To-Do. Once I finished a step I pushed to my git hub and reran my server so that I didn't write too much code before testing. 

The premise was to create the models, map the models to eachother and use those relationships to write database queries. I used the ModelViewController design principle to separate the logic needed to take a user request from the database and the corresponding response. There is a Controller class that handles all of the routes, that talks to a Service class that handles all of the business logic. The Service class talks to the model repository which retrieves the information from databse using JPA. So the data is protected by many layers.  

Here is a link to my project board/to-do list. As you can see it is very long but very specific and detail oriented. 



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