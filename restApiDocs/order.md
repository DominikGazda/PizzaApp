
# Order Rest Documentation

## Table of contents
* [Show all orders](#show-all-orders)
* [Save order](#save-order)
* [Get order by id](#get-order-by-id)
* [Update order by id](#update-order-by-id)
* [Delete order by id](#delete-order-by-id)
* [Get client from order](#get-client-from-order)
* [Add client to order](#add-client-to-order)
* [Delete client from order](#delete-client-form-order)
* [Get waiter from order](#get-waiter-from-order)
* [Add waiter to order](#add-waiter-to-order)
* [Delete waiter from order](#delete-waiter-from-order)
* [Find order by status](#find-order-by-status) 

## Show all orders
  Returns json data about all orders
* **URL**
  /api/orders
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
		"orderId":  1,
		"clientId":  1,
		"clientName":  "clientName",
		"clientSurname":  "clientSurname",
		"pizzaList":  {
			"id":  1,
			"pizzaName":  "MARGHERITTA",
			"pizzaSize":  "duża",
			"doughType":  "średnie"
			},
		"waiterId":  3,
		"waiterName":  "waiterName",
		"waiterSurname":  "waiterSurname",
		"deskNumber":  2,
		"dateTime":  "2020-12-16"
	}
]
 ```  
* **Error Response:**
```No error response (returns empty list if orders don't exist)```

## Save order

  Save single order in database

* **URL**
  /api/orders
* **Method:**
  `POST`
*  **URL Params**
none

* **JSON Request Body:**
``` 
{
	"orderId":  4,
	"clientId":  2,
	"clientName":  "clientName",
	"clientSurname":  "clientSurname",
	"pizzaList":  {
		"id":  4,
		"pizzaName":  "CAPRICIOSA",
		"pizzaSize":  "duża",
		"doughType":  "średnie"
		},
	"waiterId":  3,
	"waiterName":  "waiterName",
	"waiterSurname":  "waiterSurname",
	"deskNumber":  2,
	"dateTime":  "2020-12-16"
}
 ```
* **Success Response:**

  * **Code:** 201 Created
    **Content:** 
``` 
{
	"orderId":  4,
	"clientId":  2,
	"clientName":  "clientName",
	"clientSurname":  "clientSurname",
	"pizzaList":  {
		"id":  4,
		"pizzaName":  "CAPRICIOSA",
		"pizzaSize":  "duża",
		"doughType":  "średnie"
		},
	"waiterId":  3,
	"waiterName":  "waiterName",
	"waiterSurname":  "waiterSurname",
	"deskNumber":  2,
	"dateTime":  "2020-12-16"
}
 ```  
* **Error Response:**

  * **Code:** 400 Bad Request (if order has id)
    *  Message: ```Cannot add order with id"```
  * **Code:** 400 Bad Request  (if client id is null)
    * Message: ```Client id cannot be null !```
  *   **Code:** 400 Bad Request  (if empty client name field)
	    * Message: ```Client name cannot be empty !```
    *   **Code:** 400 Bad Request  (if empty client surname field)
	    * Message: ```Client surname cannot be empty !```
    *   **Code:** 400 Bad Request  (if pizza list id is not null)
	    * Message: ```Cannot add order with pizza list id ```
    *    **Code:** 400 Bad Request  (if waiter id  is null)
		    * Message: ```Waiter id cannot be null !```
  *    **Code:** 400 Bad Request  (if empty waiter name field)
	    * Message: ```Waiter name cannot be empty !```
	  * **Code:** 400 Bad Request  (if empty waiter surname field)
		* Message: ```Waiter surname cannot be empty !```
	  * **Code:** 400 Bad Request  (if desk number is null)
		* Message: ```Desk number cannot be null !```
	  * **Code:** 400 Bad Request  (if date time is null)
		* Message: ```Date time cannot be null !```


## Get order by id

  Get single order with provided id

* **URL**
  /api/orders/{id}
* **Method:**
  `GET`
*  **URL Params**
    `id=[Long]`

* **Success Response:**

  * **Code:** 200
    **Content:** 
``` 
{
	"orderId":  1,
	"clientId":  1,
	"clientName":  "clientName",
	"clientSurname":  "clientSurname",
	"pizzaList":  {
		"id":  1,
		"pizzaName":  "MARGHERITTA",
		"pizzaSize":  "duża",
		"doughType":  "średnie"
		},
	"waiterId":  3,
	"waiterName":  "waiterName",
	"waiterSurname":  "waiterSurname",
	"deskNumber":  2,
	"dateTime":  "2020-12-16"
}
 ```  
* **Error Response:**

  * **Code:** 404 Not found (if order with provided id doesn't exist)
    * Message: ``` Cannot find order with provided id``` 
## Update order by id

  Update single order data

* **URL**
  /api/orders/{id}
* **Method:**
  `PUT`
*  **URL Params**
    `id=[Long]`

* **JSON Request Body:**
``` 
{
	"orderId":  1,
	"clientId":  1,
	"clientName":  "clientName",
	"clientSurname":  "newSurname",
	"pizzaList":  {
		"id":  1,
		"pizzaName":  "MARGHERITTA",
		"pizzaSize":  "duża",
		"doughType":  "średnie"
		},
	"waiterId":  3,
	"waiterName":  "waiterName",
	"waiterSurname":  "waiterSurname",
	"deskNumber":  2,
	"dateTime":  "2020-12-16"
}
 ```
* **Success Response:**

  * **Code:** 201 Created
    **Content:** 
``` 
{
	"orderId":  1,
	"clientId":  1,
	"clientName":  "clientName",
	"clientSurname":  "newSurname",
	"pizzaList":  {
		"id":  1,
		"pizzaName":  "MARGHERITTA",
		"pizzaSize":  "duża",
		"doughType":  "średnie"
		},
	"waiterId":  3,
	"waiterName":  "waiterName",
	"waiterSurname":  "waiterSurname",
	"deskNumber":  2,
	"dateTime":  "2020-12-16"
}
 ```  
* **Error Response:**

  * **Code:** 400 Bad Request (if order has id different from id in path variable)
    * Message: ```Updated order must have same id as in path variable```
  * **Code:** 400 Bad Request  (if client id is null)
    * Message: ```Client id cannot be null !```
  *   **Code:** 400 Bad Request  (if empty client name field)
	    * Message: ```Client name cannot be empty !```
    *   **Code:** 400 Bad Request  (if empty client surname field)
	    * Message: ```Client surname cannot be empty !```
    *   **Code:** 400 Bad Request  (if pizza list id is not null)
	    * Message: ```Cannot add order with pizza list id ```
    *    **Code:** 400 Bad Request  (if waiter id  is null)
		    * Message: ```Waiter id cannot be null !```
  *    **Code:** 400 Bad Request  (if empty waiter name field)
	    * Message: ```Waiter name cannot be empty !```
	  * **Code:** 400 Bad Request  (if empty waiter surname field)
		* Message: ```Waiter surname cannot be empty !```
	  * **Code:** 400 Bad Request  (if desk number is null)
		* Message: ```Desk number cannot be null !```
	  * **Code:** 400 Bad Request  (if date time is null)
		* Message: ```Date time cannot be null !```


## Delete order by id

  Delete single order from database

* **URL**
  /api/orders/{id}
* **Method:**
  `DELETE`
*  **URL Params**
    `id=[Long]`

* **Success Response:**

  * **Code:** 200 OK
    **Content:** 
``` 
{
	"orderId":  1,
	"clientId":  1,
	"clientName":  "clientName",
	"clientSurname":  "clientSurname",
	"pizzaList":  {
		"id":  1,
		"pizzaName":  "MARGHERITTA",
		"pizzaSize":  "duża",
		"doughType":  "średnie"
		},
	"waiterId":  3,
	"waiterName":  "waiterName",
	"waiterSurname":  "waiterSurname",
	"deskNumber":  2,
	"dateTime":  "2020-12-16"
}
 ```  
* **Error Response:**

  * **Code:** 404 Not found (if order with provided id doesn't exist)
    * Message: ```Cannot find order with provided id```

## Get client from order
  Returns client data from order

* **URL**
  /api/orders/{id}/client
* **Method:**
  `GET`
*  **URL Params**
    `id=[Long]`

* **Success Response:**

  * **Code:** 200 OK
    **Content:** 
``` 
{
	"orderId":  1,
	"clientId":  1,
	"clientName":  "aaa",
	"clientSurname":  "Gazda"
}
 ```  
* **Error Response:**

  * **Code:** 404 Not found (if order with provided id doesn't exist)
    * Message: ``` Cannot find order with provided id``` 
## Add client to order
  Save client in order with provided id

* **URL**
  /api/orders/{id}/client
* **Method:**
  `POST`
*  **URL Params**
    `id=[Long]`
    
* **JSON Request Body:**
``` 
{
	"orderId":  1,
	"clientId":  null,
	"clientName":  "clientName",
	"clientSurname":  "clientSurname"
}
 ```
* **Success Response:**

  * **Code:** 201 
    **Content:** 
``` 
{
	"orderId":  1,
	"clientId":  1,
	"clientName":  "clientName",
	"clientSurname":  "clientSurname"
}
 ```  
* **Error Response:**

  * **Code:** 400 Bad Request (if order has assigned client id)
    *  Message: ```Order has assigned client"```
  * **Code:** 400 Bad Request  (if order has id different from id in path variable)
    * Message: ```Object must have same id as in path variable !```
  *   **Code:** 400 Bad Request  (if empty client name field)
	    * Message: ```Client name cannot be empty !```
  *   **Code:** 400 Bad Request  (if empty client surname field)
	    * Message: ```Client surname cannot be empty !```
## Delete client from order

  Delete client from order

* **URL**
  /api/orders/{id}/client
* **Method:**
  `DELETE`
*  **URL Params**
    `id=[Long]`

* **Success Response:**

  * **Code:** 200 OK
    **Content:** 
``` 
{
	"orderId":  1,
	"clientId":  1,
	"clientName":  "clientName",
	"clientSurname":  "clientSurname"
}
 ```  
* **Error Response:**

  * **Code:** 404 Not found (if order with provided id doesn't exist)
    * Message: ```Cannot find order with provided id```

## Get waiter from order
  Returns waiter data from order with provided id

* **URL**
  /api/orders/{id}/waiter
* **Method:**
  `GET`
*  **URL Params**
    `id=[Long]`

* **Success Response:**

  * **Code:** 200 OK
    **Content:** 
``` 
{
	"orderId":  1,
	"waiterId":  3,
	"waiterName":  "Bartek",
	"waiterSurname":  "Karol"
}
 ```  
* **Error Response:**

  * **Code:** 404 Not found (if order with provided id doesn't exist)
    * Message: ``` Cannot find order with provided id``` 
## Add waiter to order
  Save waiter in order with provided id (waiter must be in database)

* **URL**
  /api/orders/{id}/waiter
* **Method:**
  `POST`
*  **URL Params**
    `id=[Long]`
    
* **JSON Request Body:**
``` 
{
	"orderId":  1,
	"waiterId":  null,
	"waiterName":  "Bartek",
	"waiterSurname":  "Karol"
}
 ```
* **Success Response:**

  * **Code:** 201 Created
    **Content:** 
``` 
{
	"orderId":  1,
	"waiterId":  1,
	"waiterName":  "Bartek",
	"waiterSurname":  "Karol"
}
 ```  
* **Error Response:**

  * **Code:** 400 Bad Request (if order  has waiter id)
    *  Message: ```Order has assigned client"```
  * **Code:** 400 Bad Request  (if order has id different from id in path variable)
    * Message: ```Object must have same id as in path variable !```
  *   **Code:** 400 Bad Request  (if empty waiter name field)
	    * Message: ```Waiter name cannot be empty !```
  *   **Code:** 400 Bad Request  (if empty waiter surname field)
	    * Message: ```Waiter surname cannot be empty !```
## Delete waiter from order

  Delete waiter from order

* **URL**
  /api/orders/{id}/waiter
* **Method:**
  `DELETE`
*  **URL Params**
    `id=[Long]`

* **Success Response:**

  * **Code:** 200 OK
    **Content:** 
``` 
{
	"orderId":  1,
	"waiterId":  1,
	"waiterName":  "Bartek",
	"waiterSurname":  "Karol"
}
 ```  
* **Error Response:**

  * **Code:** 404 Not found (if order with provided id doesn't exist)
    * Message: ```Cannot find order with provided id```

## Find order by status
  Returns order with provided status

* **URL**
  /api/orders/search/findAllByStatus
* **Method:**
  `GET`
*  **URL Params**
    `id=[Long]`
    
   **Request Params**  
    `name=[String] (required = false)`

* **Success Response:**

  * **Code:** 200 OK
    **Content:** 
``` 
example url: /api/orders/search/findAllByStatus?status=NEW
[
	{
		"orderId":  1,
		"clientId":  1,
		"clientName":  "clientName",
		"clientSurname":  "clientSurname",
		"pizzaList":  {
			"id":  1,
			"pizzaName":  "CAPRICIOSA",
			"pizzaSize":  "duża",
			"doughType":  "średnie"
		},
		"waiterId":  3,
		"waiterName":  "waiterName",
		"waiterSurname":  "waiterSurname",
		"deskNumber":  2,
		"dateTime":  "2020-12-16"
	}
]
 ```  
* **Error Response:**

```No error response (returns empty list if orders don't exist)```


