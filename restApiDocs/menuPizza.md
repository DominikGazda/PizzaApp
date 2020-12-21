
# MenuPizza Rest Documentation

## Table of contents
* [Show all menu pizza](#show-all-menu-pizza)
* [Save menu pizza](#save-menu-pizza)
* [Get pizza menu by id](#get-pizza-menu-by-id)
* [Update pizza menu by id](#update-pizza-menu-by-id)
* [Delete pizza menu by id](#delete-pizza-menu-by-id)
* [Get dough type from menu pizza](#get-dough-type-from-menu-pizza)
*  [Get orders from menu pizza](#get-orders-from-menu-pizza)
*  [Get pizza from menu pizza](#get-pizza-from-menu-pizza)
*  [Get pizza size from menu pizza](#get-pizza-size-from-menu-pizza) 


## Show all menu pizza
----
  Returns json data about all menu pizza records

* **URL**
  /api/menuPizza
* **Method:**
  `GET`
*  **URL Params**
none

* **Success Response:**

  * **Code:** 200 
  * **Content:** 
``` 
[
	{
			"id":  1,
		"pizzaName":  "MARGHERITTA",
		"pizzaSize":  "duża",
		"doughType":  "średnie"
	}
]
 ```  
* **Error Response:**
```No error response (returns empty list if waiters don't exist)```

## Save menu pizza

  Save single menu pizza in database

* **URL**
  /api/menuPizza
* **Method:**
  `POST`
*  **URL Params**
none

* **JSON Request Body:**
``` 
{
	"id":  1,
	"pizzaName":  "MARGHERITTA",
	"pizzaSize":  "duża",
	"doughType":  "średnie"
}
 ```
* **Success Response:**

  * **Code:** 201 
    **Content:** 
``` 
{
	"id":  1,
	"pizzaName":  "MARGHERITTA",
	"pizzaSize":  "duża",
	"doughType":  "średnie"
}
 ```  
* **Error Response:**

  * **Code:** 400 Bad Request (if menu pizza has id)
    *  Message: ```Menu pizza cannot have id```
  * **Code:** 400 Bad Request  (if empty pizza name field)
    * Message: ```Pizza name cannot be empty !```
   * **Code:** 400 Bad Request  (if empty pizza size field)
	    * Message: ```Pizza size cannot be empty !```  * 
   * **Code:** 400 Bad Request  (if empty dough type field)
	    * Message: ```Pizza dough type cannot be empty !```  * 

## Get pizza menu by id

  Get single pizza menu with provided id

* **URL**
  /api/menuPizza/{id}
* **Method:**
  `GET`
*  **URL Params**
    `id=[Long}`

* **Success Response:**

  * **Code:** 200
    **Content:** 
``` 
{
	"id":  1,
	"pizzaName":  "MARGHERITTA",
	"pizzaSize":  "duża",
	"doughType":  "średnie"
}
 ```  
* **Error Response:**

  * **Code:** 404 Not found (if menu pizza with provided id doesn't exist)
    * Message: ``` Cannot found menu pizza with provided id ``` 
## Update pizza menu by id

  Update single menu pizza data

* **URL**
  /api/menuPizza/{id}
* **Method:**
  `PUT`
*  **URL Params**
    `id=[Long}`

* **JSON Request Body:**
``` 
{
	"id":  1,
	"pizzaName":  "MARGHERITTA",
	"pizzaSize":  "mała",
	"doughType":  "średnie"
}
 ```
* **Success Response:**

  * **Code:** 201 Created
    **Content:** 
``` 
{
	"id":  1,
	"pizzaName":  "MARGHERITTA",
	"pizzaSize":  "mała",
	"doughType":  "średnie"
}
 ```  
* **Error Response:**

  * **Code:** 400 Bad Request (if menu pizza has id different from id in path variable)
    * Message: ```Menu pizza id must be same as path variable```
## Delete pizza menu by id

  Delete single menu pizza from database

* **URL**
  /api/menuPizza/{id}
* **Method:**
  `DELETE`
*  **URL Params**
    `id=[Long}`

* **Success Response:**

  * **Code:** 200 OK
    **Content:** 
``` 
{
	"id":  1,
	"pizzaName":  "MARGHERITTA",
	"pizzaSize":  "duża",
	"doughType":  "średnie"
}
 ```  
* **Error Response:**

  * **Code:** 404 Not found (if menu pizza with provided id doesn't exist)
    * Message: ```Cannot find menu pizza with provided id```

## Get dough type from menu pizza
  Returns dough type from menu pizza

* **URL**
  /api/menuPizza/{id}/doughType
* **Method:**
  `GET`
*  **URL Params**
    `id=[Long}`

* **Success Response:**

  * **Code:** 200 OK
    **Content:** 
``` 
	średnie
 ```  
* **Error Response:**

  * **Code:** 404 Not found (if menu pizza with provided id doesn't exist)
    * Message: ``` Cannot find menu pizza with provided id``` 
## Get orders from menu pizza
  Returns orders from menu pizza

* **URL**
  /api/menuPizza/{id}/orders
* **Method:**
  `GET`
*  **URL Params**
    `id=[Long}`

* **Success Response:**

  * **Code:** 200 OK
    **Content:** 
``` 
[
	{
		"id":  1,
		"tableNumber":  2,
		"status":  "NEW",
		"waiterId":  3
	}
]
 ```  
* **Error Response:**

  * **Code:** 404 Not found (if menu pizza with provided id doesn't exist)
    * Message: ``` Cannot find menu pizza with provided id``` 
## Get pizza from menu pizza
  Returns pizza from menu pizza

* **URL**
  /api/menuPizza/{id}/pizza
* **Method:**
  `GET`
*  **URL Params**
    `id=[Long}`

* **Success Response:**

  * **Code:** 200 OK
    **Content:** 
``` 
{
	"id":  1,
	"name":  "MARGHERITTA",
	"toppingsList":  [
		{
			"id":  1,
			"name":  "sos pomidorowy",
			"price":  3.5
		},
		{
			"id":  2,
			"name":  "ser",
			"price":  2.0
		},
		{
			"id":  3,
			"name":  "oregano",
			"price":  1.5
		}
	]
}
 ```  
* **Error Response:**

  * **Code:** 404 Not found (if menu pizza with provided id doesn't exist)
    * Message: ``` Cannot find menu pizza with provided id``` 

## Get pizza size from menu pizza
  Returns pizza size from menu pizza

* **URL**
  /api/menuPizza/{id}/sizePizza
* **Method:**
  `GET`
*  **URL Params**
    `id=[Long}`

* **Success Response:**

  * **Code:** 200 OK
    **Content:** 
``` 
	duża
 ```  
* **Error Response:**

  * **Code:** 404 Not found (if menu pizza with provided id doesn't exist)
    * Message: ``` Cannot find menu pizza with provided id``` 


