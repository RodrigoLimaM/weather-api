# Weather API


Api made to consume data from HG Weather (https://hgbrasil.com/status/weather) api, format and convert them.

* **URL**\
/weather

* **Method:**\
 `GET`

*  **URL Params**

   **Required:**
    ##### City where climate data will be fetched:
   `city={String}`

   **Optional:**
    ##### Thermometric scale on which the temperature will be displayed:	
   `temperatureType={String}`
    ##### Types:
   `celsius` | `fahrenheit` | `kelvin`

* **Success Response:**

    * **Code:** 200 <br />
        **Content:**
    ```
    {
       "temperatureType":"CELSIUS",
       "currentTemperature":15,
       "description":"Tempo nublado",
       "weatherForecast":[
          {
             "date":"2020-06-14",
             "max":18,
             "min":15,
             "description":"Tempo nublado"
          },
          {
             "date":"2020-06-15",
             "max":20,
             "min":14,
             "description":"Tempo nublado"
          },
          {
             "date":"2020-06-16",
             "max":22,
             "min":14,
             "description":"Parcialmente nublado"
          },
          {
             "date":"2020-06-17",
             "max":23,
             "min":15,
             "description":"Parcialmente nublado"
          },
          {
             "date":"2020-06-18",
             "max":24,
             "min":13,
             "description":"Parcialmente nublado"
          },
          {
             "date":"2020-06-19",
             "max":25,
             "min":14,
             "description":"Parcialmente nublado"
          },
          {
             "date":"2020-06-20",
             "max":25,
             "min":14,
             "description":"Ensolarado"
          },
          {
             "date":"2020-06-21",
             "max":25,
             "min":14,
             "description":"Ensolarado"
          },
          {
             "date":"2020-06-22",
             "max":26,
             "min":14,
             "description":"Ensolarado"
          },
          {
             "date":"2020-06-23",
             "max":25,
             "min":15,
             "description":"Ensolarado com muitas nuvens"
          }
       ]
    }
    ```

* **Error Response:**

    * **Code:** 404 <br />
    **Content:** 
    ```
    {
       "timestamp":"2020-06-14T20:31:20.6932821",
       "status":404,
       "message":"City name not found"
    }
    ```
    * **Code:** 400 <br />
        **Content:** 
    ```
    {
       "timestamp":"2020-06-14T20:34:00.3158145",
       "status":400,
       "message":"Invalid temperature type"
    }
    ```
  
* **Sample Call:**
    ```
    curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET "https://weather-api1107.herokuapp.com/weather?city=orlando&temperatureType=celsius"
    ```
  
 * **Architecture:**
 
    ![Alt text](https://user-images.githubusercontent.com/51386403/87380174-4c900900-c568-11ea-9eb2-15cccdf6183d.jpg "Architecture")
    
 * **Swagger Api Documentation:**
 
    https://weather-api1107.herokuapp.com/swagger-ui.html
 
