# employee-portal-challenge

This project enable authentication service for employee portal

## API Reference

First it will create jwt token to authenticate API present.
Validate jwt token with claims

RequestBody -
{
	"username" : "admin",
	"password" : "password"
}
----------------------------------------
Rest API - localhost:8080/authenticate
----------------------------------------
Second use this token to authorize number of API 

Request Header - Key - Authorization Value - Bearer + token (generated above)

---------------------------------------------------------------------

@RequestMapping("/allianz/api")

RequestBody -
{
	"firstName" : "aaa",
	"lastName" : "bbb",
	"emailId":"aaa.bbb@gmail.com",
	"dept":"Dev",
	"salary": 40700.0
}



Find all employee -  Get - localhost:8080/allianz/api/employees

Get details of employee - Get - localhost:8080/allianz/api/employees/{id}
update employee - Put - localhost:8080/allianz/api/employees/{id}
create employee - Post - localhost:8080/allianz/api/employees
delete employee - Delete - localhost:8080/allianz/api/employees/{id}
----------------------------------------------------------------------

## Tech/framework used
Spring Boot framework is used along with spring security to generate jwt token and validate token.
In memory h2database is used

## Tests
EmployeeControllerIntegrationTest class will run junit integration tests

## How to use?
Download project 
Run as Spring boot application
Open Postman - Run Authentication API specified above
Second Employee Portal API specified above.


