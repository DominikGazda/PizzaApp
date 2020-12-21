# Pizza-app
#### Pizza ordering online application with staff panel
## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Features](#Features)

## General info
By using this application we can order pizza in local restaurant. Additionally application has an staff panel which employee can use to change the order status.
	
## Technologies
Project is created with:
* Java 11
* Spring Boot 2.4.0
* Spring REST
* Spring/Bean Validation
* Spring Data
* Spring MVC
* JPA/Hibernate
* Bootstrap
* HTML/CSS
* H2 Database
	
## Setup
To run this project, install it locally using npm:

1. Download or Clone project:
```
https://github.com/DominikGazda/PizzaApp.git
```
2. Import project as maven
```
Import -> Import as Maven project
```
3. Run PizzeriaApplication.class
4. Go to url below (application is using embedded server)
```
http://localhost:8080/
```
5. To check database go to url below
```
http://localhost:8080/h2-console
```
5. Link to staff panel 
```
http://localhost:8080/zamowienia/panel
```
## Features

* order pizza by using application in local restaurant
* use staff panel to change order status  `(http://localhost:8080/zamowienia/panel) `

## Rest documentation
*  [Client entity](/restApiDocs/client.md)
*   [Pizza entity](/restApiDocs/pizza.md)
*  [Order entity](/restApiDocs/order.md)
*  [Waiter entity](/restApiDocs/waiter.md)
*  [Toppings entity](/restApiDocs/toppings.md)
*  [MenuPizza entity](/restApiDocs/menuPizza.md)
*  [Size Pizza entity](/restApiDocs/sizePizza.md)
*  [Dough Type entity](/restApiDocs/doughType.md)

