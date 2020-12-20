
# SizePizza Rest Documentation

## Table of contents
* [Show pizza sizes](#show-pizza-sizes)
* [Get pizza size by id](#get-pizza-size-by-id)
## Show pizza sizes

  Returns json data about all pizza sizes

* **URL**
  /api/sizePizza
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
		"size":  "mała",
		"toppingDoublePrice":  0.8
	},
	{
		"id":  2,
		"size":  "średnia",
		"toppingDoublePrice":  1.0
	},
	{
		"id":  3,
		"size":  "duża",
		"toppingDoublePrice":  1.2
	}
]
 ```  
* **Error Response:**
```No error response (returns empty list if pizza sizes don't exist)```

## Get pizza size by id

  Returns json data about single pizza size

* **URL**
  /api/sizePizza/{id}
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
		"size":  "mała",
		"toppingDoublePrice":  0.8
	}
 ```  
* **Error Response:**

  * **Code:** 404 Not found (if pizza size with provided id doesn't exist)
    * Message: ```Cannot found pizza size with provided id ``` 