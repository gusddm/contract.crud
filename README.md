# contract.crud
Spring Boot based solution for a Rest Api exposing Crud operations, including patch updates!

Installation
------------

This is a maven project, so just run:

  mvn compile

There's a docker-compose file included, so if you like docker, you can set the mysql database up and running, including schema and tables creation with this command:

  docker-compose up mysql

-Once the db is running, you can import the included Addresses.json and Contracts.json data files from some Sql tool like MysqlWorkbench.

-Then just simple run the contract.crud/src/main/java/contract/ContractApplication.java main method.

-The app will run on this local address: http://localhost:8080

REST API USAGE
--------------

There are a few endpoints exposed for the different operations:

*Get Contract By ID

curl -H "Content-Type: application/json" -X GET http://localhost:8080/contract/1
  
*Adding a new contract (PUT HEADER):

curl -H "Content-Type: application/json" -X PUT -d '{"name":"Don Ramon", "company":"El chavo", "image":"myself.jpg", "email":"chavo@gmail.com", "birthdate":"2012-04-23T18:25:43.511Z", "phone_number":"39234702", "addresses":[{"city":"Mexico", "address":"avenida 123", "postal_code":"1657", "state":"Distrito Federal"}]}' http://localhost:8080/contract/

*Updating the ID 1 Contract Name only (PATCH HEADER)

curl -H "Content-Type: application/json" -X PATCH -d '{"name":"Kiko"}' http://localhost:8080/contract/1

*Get all Contracts on which their address elements have the 100-777-2568 phone number:

curl -H "Content-Type: application/json" -X GET http://localhost:8080/contract?phoneNumber=100-777-2568

*Get all Contracts of the Los Angeles city:

curl -H "Content-Type: application/json" -X GET http://localhost:8080/contract/address?city=Los+Angeles

*Delete the ID 2 Contract record:

curl -H "Content-Type: application/json" -X DELETE http://localhost:8080/contract/2


