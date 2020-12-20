
# Dough Type Rest Documentation

## Table of contents
* [Show dough Types](#show-dough-types)
* [Get dough type by id](#get-dough-type-by-id)
## Show dough types

  Returns json data about all dough types

* **URL**
  /api/doughTypes
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
		"doughType":  "cienkie",
		"price":  10.0
	},
	{
		"id":  2,
"	 	doughType":  "średnie",
		"price":  15.0
	}
]	
 ```  
* **Error Response:**
```No error response (returns empty list if dough types don't exist)```

## Get dough type by id

  Returns json data about single dough type

* **URL**
  /api/doughTypes/{id}
* **Method:**
  `GET`
*  **URL Params**
	  `id=[Long]`

* **Success Response:**

  * **Code:** 200 
  * **Content:** 
``` 
	{
		"id":  1,
		"doughType":  "cienkie",
		"price":  10.0
	}
 ```  
* **Error Response:**

  * **Code:** 404 Not found (if dough type with provided id doesn't exist)
    * Message: ```Cannot find dough type with provided id ``` 
