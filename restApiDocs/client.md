# Client Rest Documentation

## Table of contents
* [Show client](#show-client)
* [Save client](#save-client)
* [Get client by id](#get-client-by-id)
* [Update client by id](#update-client-by-id)
* [Delete client by id](#delete-client-by-id)
* [Get client orders](#get-client-orders)
* [Get client order by id](#get-client-order-by-id)

## Show client
----
  Returns json data about a single user.

* **URL**
  api/clients/
* **Method:**
  `GET`
*  **URL Params**
none

* **Success Response:**

  * **Code:** 200 
  * **Content:** 
``` 
    {
        "id": 1,
        "clientName": "clientName",
        "clientSurname": "clientSurname"
    }
 ```  
* **Error Response:**
```No error response (returns empty list if clients don't exist)```

## Save client
----
  Save single user in database

* **URL**
  api/clients/
* **Method:**
  `POST`
*  **URL Params**
none

* **JSON Request Body:**
``` 
    {
        "id": null,
        "clientName": "clientName",
        "clientSurname": "clientSurname"
    }
 ```
* **Success Response:**

  * **Code:** 201 
    **Content:** 
``` 
    {
        "id": 1,
        "clientName": "clientName",
        "clientSurname": "clientSurname"
    }
 ```  
* **Error Response:**

  * **Code:** 400 Bad Request (if user has id)
    *  Message: ```User cannot have id ```
  * **Code:** 400 Bad Request  (if empty clientName field)
    * Message: ```Name cannot be empty```
  * **Code:** 400 Bad Request (if empty clientSurname field)
    * Message: ```Surname cannot be empty```
 
## Get client by id
----
  Show single user with provided id

* **URL**
  api/clients/{id}
* **Method:**
  `GET`
*  **URL Params**
    `id=[Long}`

* **Success Response:**

  * **Code:** 200
    **Content:** 
``` 
    {
        "id": 1,
        "clientName": "clientName",
        "clientSurname": "clientSurname"
    }
 ```  
* **Error Response:**

  * **Code:** 404 Bad Request (if user with provided id doesn't exist)
    * Message: ``` Cannot find client with provided id ``` 
## Update client by id
----
  Update single user data

* **URL**
  api/clients/{id}
* **Method:**
  `PUT`
*  **URL Params**
    `id=[Long}`

* **JSON Request Body:**
``` 
    {
        "id": 1,
        "clientName": "clientName",
        "clientSurname": "clientSurname"
    }
 ```
* **Success Response:**

  * **Code:** 201 Created
    **Content:** 
``` 
    {
        "id": 1,
        "clientName": "clientName",
        "clientSurname": "clientSurname"
    }
 ```  
* **Error Response:**

  * **Code:** 400 Bad Request (if user has id different from id in path variable)
    * Message: ```Updated object must have same id as path variable ```
  * **Code:** 400 Bad Request  (if id is null)
    * Message: ```Updated object must have an id```
  
## Delete client by id
----
  Delete single user from database

* **URL**
  api/clients/{id}
* **Method:**
  `DELETE`
*  **URL Params**
    `id=[Long}`

* **Success Response:**

  * **Code:** 200 OK
    **Content:** 
``` 
    {
        "id": 1,
        "clientName": "clientName",
        "clientSurname": "clientSurname"
    }
 ```  
* **Error Response:**

  * **Code:** 404 Not found (if user with provided id doesn't exist)
    * Message: ```Cannot find client with provided id ```

## Get client orders
----
  Returns orders assigned to client with provided id

* **URL**
  api/clients/{id}/orders
* **Method:**
  `GET`
*  **URL Params**
    `id=[Long}`

* **Success Response:**

  * **Code:** 200 OK
    **Content:** 
``` 
    {
        "orderId": 3,
        "deskNumber": 2,
        "waiterId": 3,
        "status": "NEW"
    }
 ```  
* **Error Response:**

  * **Code:** 404 Not found (if user with provided id doesn't exist)
    * Message: ``` Cannot find client with provided id ``` 

## Get client order by id
----
  Returns order assigned to client with provided client and order id

* **URL**
  api/clients/{id}/orders/{id}
* **Method:**
  `GET`
*  **URL Params**
    `id=[Long}`
    `orderId=[Long}`

* **Success Response:**

  * **Code:** 200 OK
    **Content:** 
``` 
    {
        "orderId": 3,
        "deskNumber": 2,
        "waiterId": 3,
        "status": "NEW"
    }
 ```  
* **Error Response:**

  * **Code:** 404 Not found (if user with provided id doesn't exist)
    * Message: ``` Cannot find client with provided id ``` 
  * **Code:** 404 Not found (if order with provided id doesn't exist)
    * Message: ``` Cannot find order with provided id ``` 


