# Movie Awards

This is a coding exercise.

### Requirements
The application should read the csv data and import movies. 

If you want to disable the auto import, update the property application.features.auto-import on application.yml to false and import the csv by calling the /api/movies api.

At ./others/postman there is a postman collection with request examples.

## Build

> ./mvnw clean install

## Run

> ./mvnw spring-boot:run

## Test

> ./mvnw test