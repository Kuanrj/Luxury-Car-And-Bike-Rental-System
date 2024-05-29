# Luxury-Car-And-Bike-Rental-System
Explore 🚗luxury car and 🏍️bike rental system in Java involves developing a console-based application. These projects provide a practical way to apply core Java concepts such as object-oriented programming.
# Features
This  program simulates a luxury car and bike rental system. It handles various functionalities like adding vehicles, renting vehicles, returning vehicles, manages rental transactions and displaying the available vehicles. The system checks for vehicle availability, processes rentals, and calculates rental prices based on the number of days. The main class provides a simple user interface for interacting with the system through a console menu.
# Explanation
let’s go through the program in detail, breaking down each component and explaining their roles and interactions.

Step 1: Vehicle Classes
The Vehicle class is an abstract class that represents the common attributes and behaviors of both cars and bikes.

Attributes:

id: Unique identifier for the vehicle.

brand: The brand of the vehicle (e.g., BMW, Ducati).

model: The model of the vehicle (e.g., 7 Series, Panigale V4).

basePricePerDay: The cost to rent the vehicle per day.

isRented: Indicates whether the vehicle is currently rented.

Methods:

rent(): Marks the vehicle as rented.

returnVehicle(): Marks the vehicle as available.

calculatePrice(int rentalDays): Calculates the rental cost based on the number of days.

toString(): Provides a string representation of the vehicle's details.

Step 2: Customer Class
The Customer class represents the customers who rent vehicles.

Attributes:

name: The name of the customer.

phone: The Mobile number of the customer.

email: The Email of the customer.

address: The Address of the customer.

licenseNumber: The driving license number of the customer.

Methods:

toString(): Provides a string representation of the customer's details.

Step 3: Rental Class
The Rental class represents the rental transaction, linking a vehicle with a customer for a specified number of days.

Attributes:

vehicle: The rented vehicle.

customer: The customer who rented the vehicle.

days: The number of days the vehicle is rented for.

Methods:

getTotalPrice(): Calculates the total rental price based on the vehicle’s daily rate and the number of days.

toString(): Provides a string representation of the rental details, including the customer and vehicle information and the total price.

Step 4: LuxuryCarBikeRentalSystem Class
The LuxuryCarBikeRentalSystem class contains the main application logic, managing the vehicles, customers, and rental transactions.

Attributes:

vehicles: A list of available vehicles.

customers: A list of registered customers.

rentals: A list of rental transactions.

Methods:

addVehicle(Vehicle vehicle): Adds a vehicle to the system.

addCustomer(Customer customer): Adds a customer to the system.

findVehicleById(String id): Finds a vehicle by its ID.

findCustomerByName(String name): Finds a customer by their name.

rentVehicle(String vehicleId, String customerName, String phone, String email, String address, String licenseNumber, int days): Rents a vehicle to a customer for a specified number of days.

returnVehicle(String vehicleId): Returns a rented vehicle.

displayAvailableVehicles(): Displays all available (non-rented) vehicles.

Main Method: Provides a console menu for interacting with the system. It allows users to:

1. Display available vehicles.

2. Rent a vehicle.

3. Return a vehicle.

4. Exit the application.
