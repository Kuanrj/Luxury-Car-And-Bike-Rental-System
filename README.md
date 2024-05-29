# Luxury-Car-And-Bike-Rental-System
Explore 🚗luxury car and 🏍️bike rental system in Java involves developing a console-based application. These projects provide a practical way to apply core Java concepts such as object-oriented programming.
# Features
This  program simulates a luxury car and bike rental system. It handles various functionalities like adding vehicles, renting vehicles, returning vehicles, manages rental transactions and displaying the available vehicles. The system checks for vehicle availability, processes rentals, and calculates rental prices based on the number of days. The main class provides a simple user interface for interacting with the system through a console menu.
# Explanation
let’s go through the program in detail, breaking down each component and explaining their roles and interactions.

Step 1: Vehicle Classes
The Vehicle class is an abstract class that represents the common attributes and behaviors of both cars and bikes.

Attributes:

a) id: Unique identifier for the vehicle.

b) brand: The brand of the vehicle (e.g., BMW, Ducati).

c) model: The model of the vehicle (e.g., 7 Series, Panigale V4).

d) basePricePerDay: The cost to rent the vehicle per day.

e) isRented: Indicates whether the vehicle is currently rented.

Methods:

a) rent(): Marks the vehicle as rented.

b) returnVehicle(): Marks the vehicle as available.

c) calculatePrice(int rentalDays): Calculates the rental cost based on the number of days.

d) toString(): Provides a string representation of the vehicle's details.

Step 2: Customer Class
The Customer class represents the customers who rent vehicles.

Attributes:

a) name: The name of the customer.

b) phone: The Mobile number of the customer.

c) email: The Email of the customer.

d) address: The Address of the customer.

e) licenseNumber: The driving license number of the customer.

Methods:

a) toString(): Provides a string representation of the customer's details.

Step 3: Rental Class
The Rental class represents the rental transaction, linking a vehicle with a customer for a specified number of days.

Attributes:

a) vehicle: The rented vehicle.

b) customer: The customer who rented the vehicle.

c) days: The number of days the vehicle is rented for.

Methods:

a) getTotalPrice(): Calculates the total rental price based on the vehicle’s daily rate and the number of days.

b) toString(): Provides a string representation of the rental details, including the customer and vehicle information and the total price.

Step 4: LuxuryCarBikeRentalSystem Class
The LuxuryCarBikeRentalSystem class contains the main application logic, managing the vehicles, customers, and rental transactions.

Attributes:

a) vehicles: A list of available vehicles.

b) customers: A list of registered customers.

c) rentals: A list of rental transactions.

Methods:

a) addVehicle(Vehicle vehicle): Adds a vehicle to the system.

b) addCustomer(Customer customer): Adds a customer to the system.

c) findVehicleById(String id): Finds a vehicle by its ID.

d) findCustomerByName(String name): Finds a customer by their name.

e) rentVehicle(String vehicleId, String customerName, String phone, String email, String address, String licenseNumber, int days): Rents a vehicle to a customer for a specified number of days.

f) returnVehicle(String vehicleId): Returns a rented vehicle.

g) displayAvailableVehicles(): Displays all available (non-rented) vehicles.

Main Method: Provides a console menu for interacting with the system. It allows users to:

1. Display available vehicles.

2. Rent a vehicle.

3. Return a vehicle.

4. Exit the application.
