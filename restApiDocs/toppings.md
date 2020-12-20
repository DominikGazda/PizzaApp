
# Toppings Rest Documentation

## Table of contents
* [Show toppings](#show-toppings)
* [Save topping](#save-topping)
* [Get topping by id](#get-topping-by-id)
* [Update topping by id](#update-topping-by-id)
* [Delete topping by id](#delete-topping-by-id)
* [Get pizza with topping](#get-pizza-with-topping)


## Show toppings
----
  Returns json data about all toppings

* **URL**
  /api/toppings
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
		"name":  "sos pomidorowy",
		"price":  3.5
	},
	{
		"id":  2,
		"name":  "ser",
		"price":  2.0
	}
]	
 ```  
* **Error Response:**
```No error response (returns empty list if clients don't exist)```

## Save Topping

  Save single topping in database

* **URL**
  /api/toppings
* **Method:**
  `POST`
*  **URL Params**
none

* **JSON Request Body:**
``` 
 {
	"id":  null,
	"name":  "sos pomidorowy",
	"price":  3.5
}
 ```
* **Success Response:**

  * **Code:** 201 
    **Content:** 
``` 
 {
	"id":  2,
	"name":  "sos pomidorowy",
	"price":  3.5
}
 ```  
* **Error Response:**

  * **Code:** 400 Bad Request (if topping has id)
    *  Message: ```Topping cannot have id```
  * **Code:** 400 Bad Request  (if empty name field)
    * Message: ```Name field cannot be empty```

## Get topping by id

  Get single topping with provided id

* **URL**
  /api/toppings/{id}
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
	"name":  "sos pomidorowy",
	"price":  3.5
}
 ```  
* **Error Response:**

  * **Code:** 404 Not found (if topping with provided id doesn't exist)
    * Message: ``` Cannot find pizza topping ``` 
## Update topping by id

  Update single topping data

* **URL**
  /api/toppings/{id}
* **Method:**
  `PUT`
*  **URL Params**
    `id=[Long}`

* **JSON Request Body:**
``` 
{
	"id":  1,
	"name":  "sos czosnkowy",
	"price":  4.0
}
 ```
* **Success Response:**

  * **Code:** 201 Created
    **Content:** 
``` 
{
	 "id":  1,
	 "name":  "sos czosnkowy",
	 "price":  4.0
} 
 ```  
* **Error Response:**

  * **Code:** 400 Bad Request (if toping has id different from id in path variable)
    * Message: ```Updated topping id must be same as path variable```
## Delete topping by id

  Delete single topping from database

* **URL**
  /api/toppings/{id}
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
	"name":  "sos pomidorowy",
	"price":  3.5
}
 ```  
* **Error Response:**

  * **Code:** 404 Not found (if topping with provided id doesn't exist)
    * Message: ```Cannot found topping with provided id```

## Get pizza with topping
  Returns pizzas with provided id topping data

* **URL**
  /api/toppings/{id}/pizza
* **Method:**
  `GET`
*  **URL Params**
    `id=[Long}`

* **Success Response:**

  * **Code:** 200 OK
    **Content:** 
``` 
{
"toppingsId":  1,
"pizzaList":  [
	{
		"id":  1,
		"name":  "MARGHERITTA",
		"imageUrl": url 		
		"toppingsList":  [
				"sos pomidorowy",
				"ser",
				"oregano"
			]
		}
	]
}	
 ```  
* **Error Response:**

  * **Code:** 404 Not found (if user with provided id doesn't exist)
    * Message: ``` Cannot found topping with provided id ``` 


