
# Pizza Rest Documentation

## Table of contents
* [Show all pizzas](#show-all-pizzas)
* [Save pizza](#save-pizza)
* [Get pizza by id](#get-pizza-by-id)
* [Update pizza by id](#update-pizza-by-id)
* [Delete pizza by id](#delete-pizza-by-id)
* [Get pizza toppings](#get-pizza-toppings)
* [Get pizza by name](#get-pizza-by-name)



## Show all  pizzas
  Returns json data about all  pizzas
* **URL**
  /api/pizza
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
		"name":  "MARGHERITTA",
		"imageUrl": url,
		"toppingsList":  [
			"sos pomidorowy",
			"ser",
			"oregano"
		]
	}
]
 ```  
* **Error Response:**
```No error response (returns empty list if waiters don't exist)```

## Save pizza

  Save single pizza in database

* **URL**
  /api/pizza
* **Method:**
  `POST`
*  **URL Params**
none

* **JSON Request Body:**
``` 
{
	"id":  null,
	"name":  "MARGHERITTA",
	"imageUrl": "url",
	"toppingsList":  [
		"sos pomidorowy",
		"ser",
		"oregano"
	]
}
 ```
* **Success Response:**

  * **Code:** 201 
    **Content:** 
``` 
{
	"id":  1,
	"name":  "MARGHERITTA",
	"imageUrl": "url",
	"toppingsList":  [
		"sos pomidorowy",
		"ser",
		"oregano"
	]
}
 ```  
* **Error Response:**

  * **Code:** 400 Bad Request (if pizza has id)
    *  Message: ```Pizza cannot have id"```
  * **Code:** 400 Bad Request  (if empty pizza name field)
    * Message: ```Pizza name cannot be empty !```

## Get pizza by id

  Get single pizza with provided id

* **URL**
  /api/pizza/{id}
* **Method:**
  `GET`
*  **URL Params**
    `id=[Long]`

* **Success Response:**

  * **Code:** 200
    **Content:** 
``` 
{
	"id":  1,
	"name":  "MARGHERITTA",
	"imageUrl": "url",
	"toppingsList":  [
		"sos pomidorowy",
		"ser",
		"oregano"
	]
}
 ```  
* **Error Response:**

  * **Code:** 404 Not found (if pizza with provided id doesn't exist)
    * Message: ``` Cannot find pizza with provided id ``` 
## Update pizza menu by id

  Update single pizza data

* **URL**
  /api/pizza/{id}
* **Method:**
  `PUT`
*  **URL Params**
    `id=[Long]`

* **JSON Request Body:**
``` 
{
	"id":  1,
	"name":  "MARGHERITTA",
	"imageUrl": "url",
	"toppingsList":  [
		"kabanosy",
		"ser",
		"oregano"
	]
}
 ```
* **Success Response:**

  * **Code:** 201 Created
    **Content:** 
``` 
{
	"id":  1,
	"name":  "MARGHERITTA",
	"imageUrl": "url",
	"toppingsList":  [
		"kabanosy",
		"ser",
		"oregano"
	]
}
 ```  
* **Error Response:**

  * **Code:** 400 Bad Request (if pizza has id different from id in path variable)
    * Message: ```Pizza id must be same as in path variable```
   * **Code:** 400 Bad Request  (if empty pizza name field)
	    * Message: ```Pizza name cannot be empty !``` 
## Delete pizza by id

  Delete single pizza from database

* **URL**
  /api/pizza/{id}
* **Method:**
  `DELETE`
*  **URL Params**
    `id=[Long]`

* **Success Response:**

  * **Code:** 200 OK
    **Content:** 
``` 
{
	"id":  1,
	"name":  "MARGHERITTA",
	"imageUrl": "url",
	"toppingsList":  [
		"sos pomidorowy",
		"ser",
		"oregano"
	]
}
 ```  
* **Error Response:**

  * **Code:** 404 Not found (if pizza with provided id doesn't exist)
    * Message: ```Cannot find pizza with provided id```

## Get pizza toppings
  Returns topping assigned to pizza

* **URL**
  /api/pizza/{id}/toppingList
* **Method:**
  `GET`
*  **URL Params**
    `id=[Long]`

* **Success Response:**

  * **Code:** 200 OK
    **Content:** 
``` 
{
"pizzaId":  1,
"toppings":  [
		"sos pomidorowy",
		"ser",
		"oregano"
	]
}
 ```  
* **Error Response:**

  * **Code:** 404 Not found (if pizza with provided id doesn't exist)
    * Message: ``` Cannot find pizza with provided id``` 
## Get pizza by name
  Returns pizza with provided name

* **URL**
  /api/pizza/search/findByNameIgnoreCase
* **Method:**
  `GET`
*  **URL Params**
    `id=[Long]`
    
   **Request Params**  
    `name=[String]`

* **Success Response:**

  * **Code:** 200 OK
    **Content:** 
``` 
example url: /api/pizza/search/findByNameIgnoreCase?name=margheritta
{
	"id":  1,
	"name":  "MARGHERITTA",
	"imageUrl":  "url"
	"toppingsList":  [
		"sos pomidorowy",
		"ser",
		"oregano"
	]
}
 ```  
* **Error Response:**

  * **Code:** 404 Not found (if  pizza with provided id doesn't exist)
    * Message: ``` Cannot find pizza with provided id``` 
