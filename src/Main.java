import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Vehicle{
    private String id;
    private String brand;
    private String model;
    //private String color;
    //private int year;
    private double basePricePerDay;
    private boolean isRented;

    public Vehicle(String id, String brand, String model, double basePricePerDay) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
    }
    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getBasePricePerDay() {
        return basePricePerDay;
    }

    public boolean isRented() {
        return isRented;
    }
    public void rent(){  //Mark the vehicle as Rented
        isRented = true;
    }
    public void returnVehicle(){  //Mark the vehicle as available
        isRented = false;
    }
    public double calculatePrice(int rentalDays){
        return basePricePerDay * rentalDays;
    }

    @Override
    public String toString() {  // Provides the string representation of the vehicle's details
        return "id: " + id+", Brand: " + brand+", Model: " + model+", Price Per Day: " + basePricePerDay+", Rented: "+(isRented ? "Yes":"No");
    }
}
class car extends Vehicle{

    public car(String id, String brand, String model, double basePricePerDay) {
        super(id, brand, model, basePricePerDay);
    }
}
class bike extends Vehicle{
    public bike(String id, String brand, String model, double basePricePerDay) {
        super(id, brand, model, basePricePerDay);
    }
}

class Customer{
    private String name;
    private String phone;
    private String email;
    private String address;
    private String licenseNumber;

    public Customer(String name, String phone, String email, String address, String licenseNumber) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.licenseNumber = licenseNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    @Override
    public String toString() {  // Provides the string representation of the customer's details
        return "Customer{" +
                "Name='" + name + '\'' +
                ", Mobile Number=" + phone +
                ", Email='" + email + '\'' +
                ", Address='" + address + '\'' +
                ", License Number=" + licenseNumber +
                '}';
    }
}
class Rental{
    private Vehicle vehicle;
    private Customer customer;
    private int days;

    public Rental(Vehicle vehicle, Customer customer, int days) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getRentalDays() {
        return days;
    }

    public double getTotalPrice() {
        return vehicle.calculatePrice(days);
    }
    @Override
    public String toString() {
        return "\nRental" +
                "Vehicle= " + vehicle +
                "\n"+  customer +
                "\nRental Days= " + days +
                "\nTotal Price= " + getTotalPrice();
    }
}

public class Main {
    private List<Vehicle> vehicles = new ArrayList<>();  // A list of available vehicles
    private List<Customer> customers = new ArrayList<>();  // A list of registered customers
    private List<Rental> rentals = new ArrayList<>();  // A list of rental transactions


    // Adds a vehicle to the System
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    // Adds a customer to the System
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Finds a vehicle by its ID
    public Vehicle findVehicleById(String id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId().equals(id)) {
                return vehicle;
            }
        }
        return null;
    }

    // Finds a customer by their name
    public Customer findCustomerByName(String name) {  // take number in place of name
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }

    // Rents a vehicle to a customer for a specified number of days.
    public void rentVehicle(String vehicleId, String customerName, String phone, String email, String address, String licenseNumber, int days){
        /*
           findVehicleById() find the vehicle by its ID
           and iterates through the list of vehicles to find a match.
        */
        Vehicle vehicle = findVehicleById(vehicleId);
        /*
           First check whether vehicle exist, Second the vehicle not already rented.
           If all conditions are met, the vehicle's "isRented" status is set to be true by calling the rent().
           A new Rental object is created, linking the vehicle, customer, and rental duration.
           The new rental record is added to the list of rentals.
        */
        if(vehicle !=null) {
            if (!vehicle.isRented()){
                vehicle.rent();
                Customer customer  = new Customer(customerName, phone, email, address, licenseNumber);
                Rental rental = new Rental(vehicle, customer, days);
                rentals.add(rental);
                System.out.println("Vehicle rented successfully:\n" + rental);
            }else {
                System.out.println("The vehicle you have selected is currently on rent, please select another vehicle or we will definitely contact you as soon as we get the vehicle.");
            }
        }else {
            System.out.println("Vehicle not available.");
        }
    }

    // Returns a rented vehicle
    public void returnVehicle(String vehicleId){ //String customerName
        /*
        Find the vehicle by its ID using the findVehicleById()
        Check Rental Status whether the vehicle exists or it is currently rented.
        */
        Vehicle vehicle = findVehicleById(vehicleId);
        if(vehicle != null && vehicle.isRented()) {
            vehicle.returnVehicle();
            System.out.println("Vehicle returned successfully.");
        }else{
            System.out.println("Vehicle not found or already returned.");
        }
    }

    // Display all available (non-rented) vehicle
    public void displayAvailableVehicle(){
        for(Vehicle vehicle : vehicles){
            if (!vehicle.isRented()) {
                System.out.println(vehicle);
            }  //else
        }
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Main main = new Main();

        // Adding some vehicle and customer for demonstration
        main.addVehicle(new car("C1", "BMW", "7 series", 62000));
        main.addVehicle(new car("C2", "Audi", "A8", 55000));
        main.addVehicle(new car("C3", "Rolls-Royce", "Phantom", 110000));
        main.addVehicle(new car("C4", "Rolls-Royce", "Ghost", 105000));
        main.addVehicle(new bike("B1", "Ducati","Panigale v4 R",30000));
        main.addVehicle(new bike("B2", "Harley-Davidson", "Street 750", 25000));
        main.addVehicle(new bike("B3", "Harley-Davidson", "Sportster S", 28000));
        main.addVehicle(new bike("B4", "Harley-Davidson", "Fat Boy", 24000));

        while(true){
            System.out.println("****  Welcome to Our Luxury Vehicle Showroom  ****");
            System.out.println("     ----================================----     ");
            System.out.println("1. Display available vehicle");
            System.out.println("2. Rent a vehicle");
            System.out.println("3. Return a vehicle");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume new line

            switch(choice){
                case 1:
                    main.displayAvailableVehicle();
                    break;
                case 2:
                    System.out.print("Enter Vehicle ID to Rent: ");
                    String vehicleId = scanner.nextLine();
                    System.out.print("Enter Your name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter Your Mobile Number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter Your Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Your Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Your Driving License Number: ");
                    String licenseNumber = scanner.nextLine();
                    System.out.print("Please tell us for how many days you want to rent: ");
                    int days = scanner.nextInt();
                    scanner.nextLine();
                    main.rentVehicle(vehicleId, customerName, phone, email, address, licenseNumber, days);

                    break;
                case 3:
                    System.out.println("Enter vehicle ID to Return: ");
                    vehicleId = scanner.nextLine();
                    main.returnVehicle(vehicleId);
                    break;
                case 4:
                    System.out.println("Thank you for using our service.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        }

    }
}