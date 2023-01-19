<h1 align="center">
  <p align="center"> Klx Test </p>
</h1>

***

## Tools and plugins used in this project

* Java JDK 17.0.5
* Spring Boot 2.70
* Maven 3.87
* Lombok
* Postgres
* Docker
* OpenApi 1.62
* Flyway 8.5.11
* Developed with: IntelliJ IDEA 2022.3 (Ultimate Edition)

*******

## Swagger Documentation

* Check the Swagger documentation on browser: http://localhost:8080/swagger-ui/index.html
* If you need, you can get a [Postman Collection] to help the execution of the tests.

*******

## Running this project

1. Generate the project .jar file running the command:

    ```sh
      mvn clean install -DskipTests=true
    ```

2. Enter in the root of the project and run the project image with the command above:

   ```sh
     docker compose up
    ```

3. Consume the api: /api/v1/translate, informing the parameters below:

   Example: [http://localhost:8080/api/v1/translate?words=Eu bebo água]()
   #### Parameters:
   ```sh
      words = Words to be translated 
      Example: Eu bebo água
      
    ```

   The api will generate a response like this:
     ```sh
         "I drink water " 
     ```

4. Consume the api: /api/v1/validate/json to show all flight records in history

   Example: POST http://localhost:8080/api/v1/validate/json

   #### Request Body:
   ```sh
            {
                "json_list": [
                    "teste {[]}",
                    "{ teste {[]}}",
                    "[{[]}]",
                    "{[]}{}[{1}{}]",
                    "{ teste {[]}",
                    "{[}[]",
                    "[{[{]}]",
                    "{[]}{}[{1}{}]{"
                ]
            }      
   ```

   #### Response Body:
   ```sh
            {
                "{ teste {[]}}": "JSON Valid",
                "{[]}{}[{1}{}]{": "JSON Invalid",
                "{ teste {[]}": "JSON Invalid",
                "{[]}{}[{1}{}]": "JSON Valid",
                "teste {[]}": "JSON Valid",
                "[{[]}]": "JSON Valid",
                "[{[{]}]": "JSON Invalid",
                "{[}[]": "JSON Invalid"
            }      
   ```

[Postman Collection]: https://we.tl/t-mirAtdzfyZ


