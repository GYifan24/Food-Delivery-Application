# food-delivery-application
food delivery application is an application implemented using Microservices architecture and Spring Cloud.

Services:
1. Restaurant Management Service
2. Order Management Service
3. Payment Management Service

Restaurant Management Service:

API Overview
Method      URL                 Description
POST        /restaurants        Upload a list of restaurants
GET         /restaurants/{name} get restaurant's menu by restaurant's name

DATABASE:
MongoDB: Save restaurants including their menus information to database.



Order Management Service:

APIOverview
Method      URL                         Description
POST        /restaurants/{name}/order   place an order, 
                                        send credit card info and total price to payment service
                                        if payment succeed, return true, return estimated delivery time
                                        if not, return false
                                        Save payment info to database

DATABASE:
MySQL: Save order information after payment service return payment status(including order is success or not)


Payment Management Service:
Method    URL                           Description
POST      /restaurants/{name}/          Send payment info to order management service
            order/payment               Save payment info to database
            
            
DATABASE:
MySQL: Save payment information including payment id, timestamp and charged amount.


