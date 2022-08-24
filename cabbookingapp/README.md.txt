Sample TestCases:

DriverClass Main function:
	1. Creates and onboards sample users and drivers;

API Calls:

1. Update user location

url: localhost:8080/users/Abhishek/location

body:    
    {
        "location": {
            "x": 0,
            "y": 0
        }        
    }


url: localhost:8080/users/Rahul/location

body:
    {
        "location": {
            "x": 10,
            "y": 0
        }        
    }


url: localhost:8080/users/Nandini/location

body:
    {
        "location": {
            "x": 15,
            "y": 6
        }        
    }

2. 
localhost:8080/findRides?userName=Abhishek&source=0,0&destination=20,1

3.
localhost:8080/findRides?userName=Rahul&source=10,0&destination=15,3

4.
localhost:8080/choose?userName=Rahul&driverName=Driver1

5.
localhost:8080/findRides?userName=Nandini&source=15,6&destination=20,4

6.
localhost:8080/calculateBill?userName=Rahul

7.
localhost:8080/totalEarnings


