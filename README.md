# Pizza-app
#### Pizza ordering online application with staff panel
## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [General features](#general-features)
* [Rest documentation](#rest-documentation)
* [Database schema](#database-schema)
## General info
By using this application we can order pizza in local restaurant. Additionally application has an staff panel which employee can use to change the order status.

# Main Page
## Features
* Add pizza to order
* Delete pizza from order
<img src="https://github.com/DominikGazda/PizzaApp/blob/main/img/main.png"/>

# Pizza details
## Features
* Choose pizza size
* Choose pizza dough type
<img src="https://github.com/DominikGazda/PizzaApp/blob/main/img/pizza-details.png"/>

# Order summary
## Features
* Show order details
* Show which waiter was assigned to the order
<img src="https://github.com/DominikGazda/PizzaApp/blob/main/img/summary.png"/>

# Success Page
## If everything is fine you will see success site 
<img src="https://github.com/DominikGazda/PizzaApp/blob/main/img/success.png"/>

# Error Page
## If something went wrong you will see error site
<img src="https://github.com/DominikGazda/PizzaApp/blob/main/img/error.png"/>

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
## General features

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

## Database schema
<img src="https://github.com/DominikGazda/PizzaApp/blob/main/database_schema.png" alt="schema" width="1030" height= "820"/>
