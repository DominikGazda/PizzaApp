
# Toppings Rest Documentation

## Table of contents
* [Show waiters](#show-waiters)
* [Save waiter](#save-waiter)
* [Get waiter by id](#get-waiter-by-id)
* [Update waiter by id](#update-waiter-by-id)
* [Delete waiter by id](#delete-waiter-by-id)
* [Get waiter orders](#get-waiter-orders)


## Show waiters
----
  Returns json data about all waiters

* **URL**
  /api/waiter
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
		"name":  "waiterName",
		"surname":  "waiterSurname"
	},
	{
		"id":  2,
		"name":  "waiterName",
		"surname":  "waiterSurname"
	}
]
 ```  
* **Error Response:**
```No error response (returns empty list if waiters don't exist)```

## Save waiter

  Save single waiter in database

* **URL**
  /api/waiter
* **Method:**
  `POST`
*  **URL Params**
none

* **JSON Request Body:**
``` 
 {
		"id":  null,
		"name":  "waiterName",
		"surname":  "waiterSurname"
}
 ```
* **Success Response:**

  * **Code:** 201 
    **Content:** 
``` 
 {
	"id":  1,
	"name":  "waiterName",
	"surname":  "waiterSurname"
}
 ```  
* **Error Response:**

  * **Code:** 400 Bad Request (if waiter has id)
    *  Message: ```Waiter cannot have id```
  * **Code:** 400 Bad Request  (if empty name field)
    * Message: ```Name field cannot be empty```
   * **Code:** 400 Bad Request  (if empty surname field)
	    * Message: ```Surname field cannot be empty```  * 

## Get waiter by id

  Get single waiter with provided id

* **URL**
  /api/waiter/{id}
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
	"name":  "waiterName",
	"surname":  "waiterSurname"
}
 ```  
* **Error Response:**

  * **Code:** 404 Not found (if waiter with provided id doesn't exist)
    * Message: ``` Cannot find waiter with provided id ``` 
## Update waiter by id

  Update single waiter data

* **URL**
  /api/waiter/{id}
* **Method:**
  `PUT`
*  **URL Params**
    `id=[Long}`

* **JSON Request Body:**
``` 
 {
	"id":  1,
	"name":  "Bob",
	"surname":  "Bobek"
}
 ```
* **Success Response:**

  * **Code:** 201 Created
    **Content:** 
``` 
 {
	"id":  1,
	"name":  "Bob",
	"surname":  "Bobek"
}
 ```  
* **Error Response:**

  * **Code:** 400 Bad Request (if waiter has id different from id in path variable)
    * Message: ```Waiter id must be same as in path variable```
## Delete waiter by id

  Delete single waiter from database

* **URL**
  /api/waiter/{id}
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
	"name":  "Bob",
	"surname":  "Bobek"
}
 ```  
* **Error Response:**

  * **Code:** 404 Not found (if waiter with provided id doesn't exist)
    * Message: ```Cannot find waiter with provided id```

## Get waiter orders
  Returns waiter with provided id orders

* **URL**
  /api/waiter/{id}/orders
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
		"clientName":  "Bob",
		"clientSurname":  "Bobek",
		"pizza":  {
			"id":  1,
			"name":  "MARGHERITTA"
		},
		"pizzaSize":  "duża",
		"doughType":  "średnie",
		"deskNumber":  2,
		"dateTime":  "2020-12-16"
	}
]
 ```  
* **Error Response:**

  * **Code:** 404 Not found (if waiter with provided id doesn't exist)
    * Message: ``` Cannot find waiter with provided id ``` 


