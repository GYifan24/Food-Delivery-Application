# food-delivery-application
food delivery application is an application implemented using Microservices architecture and Spring Cloud.

Services:
1. Restaurant Management Service
2. Order Management Service
3. Payment Management Service

API  architecture design

1. Restaurant Management Service:

1.1 API Overview

1.1.1. POST--------->/restaurants------------>Upload a list of restaurants
1.1.2. GET---------->/restaurants/{name}----->Get restaurant's menu by restaurant's name

1.2 DATABASE:
h2 database.



2. Order Management Service:

2.1 API Overview
2.1.1. POST---------->/order------>place an order, send credit card info and ordered items to order management server. If payment succeed, return paymentID, estimated delivery time and timestamp. 

2.2 DATABASE:
MySQL: Save order information after payment service return payment status.


3. Payment Management Service:

3.1 API Overview
POST----->/order/payment------------>Recieve payment information from order service. Then process payment, return the payment information to orderserice.
                 
3.2 DATABASE:
MySQL: Save payment information including payment id, timestamp and charged amount.


Intruction:

1. Execute docker-compose up from command line.
2. Bring up 3 services
3. Open Postman

Restaurant Service:
1. Send post request to the below url from postman 
POST:  http://localhost:9001/foodDeliveryAPI/restaurants
2. Send get request to search by restaurant name, return its menu
GET:   http://localhost:9001/foodDeliveryAPI/restaurants/BB_noodle


Order Service:
1. Send post request to the below url from postman
POST:   http://localhost:9005/order

Return: timestamp, estimated delvery time and whether order is success.





