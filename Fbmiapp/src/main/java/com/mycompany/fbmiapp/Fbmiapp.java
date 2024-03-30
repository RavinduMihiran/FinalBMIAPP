/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fbmiapp;

/**
 *
 * @author Mihiran
 */
import java.util.*;


class Tester {
    private int id;
    private String name;
    private int yob;
    private int height; // in cm
    private int weight;

    // Constructor
    public Tester(int id, String name, int yob, int height, int weight) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.height = height;
        this.weight = weight;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYob() {
        return yob;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    // Calculate Age
    public int calculateAge(int currentYear) {
        return currentYear - yob;
    }

    // Calculate BMI
    public double calculateBMI() {
        return weight / ((height / 100.0) * (height / 100.0));
    }

    // Display method
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Year of Birth: " + yob);
        System.out.println("Height: " + height + " cm");
        System.out.println("Weight: " + weight + " kg");
        System.out.println("BMI: " + calculateBMI()+ "Kg/m2");
        System.out.println("Age: " + calculateAge(2024)); // Assuming current year is 2024
    }
}

class Bmi extends Tester {

    public Bmi(int id, String name, int yob, int height, int weight) {
        super(id, name, yob, height, weight);
    }

    // Overriding the display method to include BMI
    @Override
    public void display() {
        super.display();
        System.out.println("BMI Category: " + calculateBMICategory());
    }

    // Choose BMI Category
    private String calculateBMICategory() {
        double bmi = calculateBMI();
        if (bmi < 16)
            return "Severe undernourishment";
        else if (bmi <= 16.9)
            return "Medium undernourishment";
        else if (bmi <= 18.4)
            return "Slight undernourishment";
        else if (bmi <= 24.9)
            return "Normal nutrition state";
        else if (bmi <= 29.9)
            return "Overweight";
        else if (bmi <= 39.9)
            return "Obesity";
        else
            return "Pathological obesity";
    }

   
}

public class Fbmiapp {
    private static List<Bmi> userList = new ArrayList<>();

    public static void main(String[] args) {
        displayMenu();
    }

    // Display Menu method
    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create a record");
            System.out.println("2. Show BMI data for all users");
            System.out.println("3. Show BMI data for a selected user");
            System.out.println("4. Delete all records");
            System.out.println("5. Exit application");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    index();
                    break;
                case 3:
                    System.out.print("Enter user ID: ");
                    int id = scanner.nextInt();
                    view(id);
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    exit();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Show all records
    public static void index() {
        for (Bmi user : userList) {
            user.display();
        }
    }

    // Show one record for the given id
    public static void view(int id) {
        for (Bmi user : userList) {
            if (user.getId() == id) {
                user.display();
                return;
            }
        }
        System.out.println("User not found with ID: " + id);
    }

    // Create a new record
    public static void create() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter year of birth: ");
        int yob = scanner.nextInt();
        System.out.print("Enter height (in cm): ");
        int height = scanner.nextInt();
        System.out.print("Enter weight (in kg): ");
        int weight = scanner.nextInt();
        Bmi newUser = new Bmi(id, name, yob, height, weight);
        userList.add(newUser);
        System.out.println("Record added successfully.");
    }

    // Delete all records
    public static void delete() {
        userList.clear();
        System.out.println("All records deleted successfully.");
    }

    // Exit application
    public static void exit() {
        System.out.println("Exiting application. Goodbye!");
        System.exit(0);
    }
}
