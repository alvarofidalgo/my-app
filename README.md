# my-app
restServer with Spring Boot and JS in view

Aplication Rest that implement a Rest service . Rest server was implement with Spring Boot (server) , Spring REST (to consume Data).Server test if JSON object of the view is correct (all fields are filled) and insert in a Fake db . 
Server is implement with Clean Architecture ,in packages com.currencyfair.comsumptions is implement al server , in packages com.curencyfair.processor is implement al logic of aplication (useCase).
If Json Object is correct then send all objects inserted with a new format of de Date (one test to insert is that the format date is correct)
Server was disign with test (jUNit,Mockito,MockMVC...). Also there is a module Spring MVC to serve a initial page (/index)

View was implement in JavaScript all js files is in folder webApp/WEB-INf/view/* , used mocha,chai,karma and phantonJS to test. View send to server a rest petition every second , pair second send correct JSON object and unpair secod incorrect JSON object.
In view will show errors in last fail  JSON object and all inserted objects.
