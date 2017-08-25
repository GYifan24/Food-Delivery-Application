# food-delivery-application
food delivery application is an application implemented using Microservices architecture and Spring Cloud.

Services:
1. Restaurant Management Service
2. Order Management Service
3. Payment Management Service


1. Restaurant Management Service:

1.1 API Overview

1.1.1. POST--------->/restaurants------------>Upload a list of restaurants
1.1.2. GET---------->/restaurants/{name}----->Get restaurant's menu by restaurant's name

1.2 DATABASE:
MongoDB: Save restaurants including their menus information to database.

2. Order Management Service:

2.1 API Overview
2.1.1. POST---------->/restaurants/{name}/order------>place an order, send credit card info and total price to payment service. If payment succeed, return true, return estimated delivery time. If not, return false. Save payment info to database

2.2 DATABASE:
MySQL: Save order information after payment service return payment status(including order is success or not)

3. Payment Management Service:
3.1 API Overview
POST----->/restaurants/{name}/order/payment------------>Send payment info to order management service. Save payment info to database
                 
3.2 DATABASE:
MySQL: Save payment information including payment id, timestamp and charged amount.


