# Weather Rest Backend

GET-POST-PUT-DELETE (CRUD) demo in-memory backend


- GET http://WildFly16:8080/measurements/rest/profile {header: user}
- PUT http://WildFly16:8080/measurements/rest/profile {header: user}

- GET http://WildFly16:8080/measurements/rest/measurements {header: user}
- GET http://WildFly16:8080/measurements/rest/measurements/123 {header: user}
- DELETE http://WildFly16:8080/measurements/rest/measurements/123 {header: user}
- POST http://WildFly16:8080/measurements/rest/measurements {header: user}

- HEADER: API-Key !
