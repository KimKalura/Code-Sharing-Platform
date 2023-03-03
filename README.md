# Hi, I'm Raluca! 👋

Here you can find the documentation of the Code Sharing Platform

## 🚀 About Me
💻(Aspiring) back-end software developer | 👨‍💻Helping companies to build great back-ends | Java, Spring Boot | Passionate about solving problems using technology


## 🛠 Skills
Back-end development · Unit Testing · Java · Algorithms · OOP · Relational Databases · SQL · Git · HTML · CSS · Web services · REST APIs · Spring Boot · Spring Framework · MySQL · Data Structures · Web Development · Software Development


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://kimkalura.github.io/)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/floriana-raluca-deftu/)

# Code Sharing Platform

This platform allows programmers to share code without it being public. Each piece of code will have a limited number of views (that is, how many times that piece of code can be seen) and a limit for the time it can be seen. After a certain period of time, the code will expire and will be deleted from the database.

## Features
As a user, I can:
-	add shared code
-	view shared code
-	view the latest five public shared codes


## Built with

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)

## API Reference

#### Add a shared code

```http
  POST /code/add
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `body` | `json` | **Required**. The properties of code to be added  |

Request body example:

```json
{
 "code": "string",
 "allowedViewTime": 0,
 "views": 0
}
```  
Postman example:

![App Screenshot](https://i.imgur.com/mbAca78.png)

MySQL example:

![App Screenshot](https://i.imgur.com/iItx9dT.png)


#### View shared code

```http
  GET /code/${codeId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of code to fetch |


Postman example:

![App Screenshot](https://i.imgur.com/C0Ji4Wd.png)

#### View the latest five public shared codes

```http
  GET /code/latest
```

Postman example:

![App Screenshot](https://i.imgur.com/dO6kwju.png)

## API Authentication and Authorization

There are only two requests which don't require authorization headers.

#### Authenticate (login)

```http
  POST /authenticate
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `body` | `json` | **Required**. The properties of user to authenticate  |

Request body example:

```json
{
  "password": "string",
  "username": "string"
}
```  

#### Register

```http
  POST /authenticate
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `body` | `json` | **Required**. The properties of user to register  |

Request body example:

```json
{
  "email": "string",
  "password": "string",
  "username": "string"
}
```  
After running the authenticate request, the client will obtain an access token that will be used in all subsequent request in order to authenticate the user and to authorize the user based on its role.

This is an example of what should be included in the request header:

```http
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjcxMTQzMzEyfQ.dxIzsD9Bm8y_kw3MOoZ2JXIKOg--uZaA5XNtBLdGYc4Ps3nlzBFDwBJi0bEeHlCggonZ6nQ2zwCI0D5a7dXjmw
```  
## Prerequisites

For building and running the application you need:
- JDK 1.8 or higher
- Maven 3

For deploying on Heroku you need:
- GIT
- Heroku CLI
## Dependencies

You don't need any additional dependencies.
All dependecies related to database management, server management, security management and so on, will be automatically injected by Maven using the pom.xml file located in the root folder of the project.

## Installation

Clone the project

```bash
  git clone https://github.com/KimKalura/Code-Sharing-Platform
```

Go to the project directory

```bash
  cd my-project
```

## Run Locally

Use maven to build the app and, to run it, and to start the local embedded Tomcat server

```bash
  mvn spring-boot:run
```


## Running Tests

To run tests, run the following command

```bash
  mvn test
```


## Environment Variables

You can deploy this project using Heroku or other providers as well, by specifying the following environment variables:

`PROFILE`

`MYSQL_URL`

`MYSQL_USER`

`MYSQL_PASS`



## Deployment

To deploy this project run

```bash
  git push heroku master
```


## Usage

You cand use demo version of the app, using SwaggerUI and following this link:

--

First, obtain an access token by running the /authenticate endpoint with username "user" and password "pass", which will grant you admin rights in the application.

![App Screenshot](https://i.imgur.com/GX34Sdn.png)

After that, authorize yourself by clicking the authorize button and copy-pasteing the token from the response.

![App Screenshot](https://i.imgur.com/arTX2Ke_d.webp?maxwidth=760&fidelity=grand)

From now on, you can use all other available endpoints, as per swagger documentation.



## Badges


![Maintained](https://img.shields.io/badge/Maintained%3F-yes-green.svg)
![GIT](https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white)
![Heroku](https://img.shields.io/badge/heroku-%23430098.svg?style=for-the-badge&logo=heroku&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![JWT](https://img.shields.io/badge/json%20web%20tokens-323330?style=for-the-badge&logo=json-web-tokens&logoColor=pink)