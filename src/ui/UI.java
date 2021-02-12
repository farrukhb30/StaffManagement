
package ui;

import models.GraphicDesigner;
import static models.EmployeeManagement.*;
import models.Programmer;
import models.TestSpecialist;
import static utilities.Utilities.*;

public class UI {

    //The first menu runs when the program starts.
    public static void runProgram() {
        System.out.println("\nWelcome to the Employee Management System!");
        System.out.println("Please input number to choose from the menu.");
        System.out.println("1. Employee Management");
        System.out.println("2. Statistics");
        System.out.println("3. Input dummy data");
        System.out.println("4. Sorting TEST");
        System.out.println("0. Exit");

        switch (readInt()) {
            case 1:
                employeeManagement();
                break;
            case 2:
                statistics();
                break;
            case 3:
                loadDB();
                break;
            case 4:
                testsorting();
            case 0:
                System.exit(0);
            default:
                System.out.println("Invalid input. Please try again.");
        }
    }

    //Shows the menu for employee management when you get into subcategory of main menu.
    public static void employeeManagement() {
        System.out.println("\n1. Add employee");
        System.out.println("2. Update employee");
        System.out.println("3. Remove employee by ID");
        System.out.println("4. Remove employee by name");
        System.out.println("5. Show information about all employees");
        System.out.println("6. Show information about a specific employee");
        System.out.println("0. Go back to main menu");

        switch (readInt()) {
            case 1 ->
                addEmployeeByUser();
            case 2 ->
                updateEmployeeByID();
            case 3 ->
                removeEmployeeByID();
            case 4 ->
                removeEmployeeByName();
            case 5 ->
                printAllEmployees();
            case 6 ->
                printEmployeeByID();
            case 0 ->
                runProgram();
            default ->
                System.out.println("Invalid input! Please try again.");
        }
    }

    //Shows the menu for statistics when you get into subcategory of main menu.
    public static void statistics() {
        System.out.println("\n1. Average salary");
        System.out.println("2. Gender distribution");
        System.out.println("3. Bonus payments");
        System.out.println("4. Highest salary in company");
        System.out.println("5. Lowest salary in company");
        System.out.println("0. Go back to main menu");

        switch (readInt()) {

            case 1 ->
                calculateAverageSalary();
            case 2 ->
                genderDistribution();
            case 3 ->
                bonusMenu();
            case 4 ->
                findHighestPaidEmployee();
            case 5 ->
                findLowestPaidEmployee();
            case 0 -> {
            }
            default ->
                System.out.println("Invalid input! Please try again.");
        }
    }

    //Generates bonus Menu for calculation of Bonus based on different professional roles.
    public static void bonusMenu() {
        boolean bonusMenuLoop = true;
        while (bonusMenuLoop) {
            System.out.println("\n1. Total bonus for all employees ");
            System.out.println("2. Total bonus for all programmers");
            System.out.println("3. Total bonus for all graphic designers");
            System.out.println("4. Total bonus for all test specialists");
            System.out.println("5. Go back to Statistics");
            System.out.println("0. Go back to main menu");

            switch (readInt()) {

                case 1 ->
                    totalBonusPayments();
                case 2 ->
                    totalProgrammersBonusPayments();
                case 3 ->
                    totalGraphicDesignerBonusPayments();
                case 4 ->
                    totalTestSpecialistBonusPayments();
                case 5 ->{
                    bonusMenuLoop = false;
                    statistics();
                }
                case 0 -> {
                    bonusMenuLoop = false;
                    runProgram();
                }
                default ->
                    bonusMenuLoop = false;
            }
        }
    }

    //Adds the employee by asking different fields of employee from User.
    public static void addEmployeeByUser() {
        System.out.println("\nWhat kind of employee?");
        System.out.println("1. Programmer");
        System.out.println("2. Graphic Designer");
        System.out.println("3. Test Specialist");
        System.out.println("0. Go back to main menu");
        switch (sc.nextLine()) {
            case "1" -> {
                Programmer p = new Programmer();
                p.addEmployee();
            }
            case "2" -> {
                GraphicDesigner g = new GraphicDesigner();
                g.addEmployee();
            }
            case "3" -> {
                TestSpecialist t = new TestSpecialist();
                t.addEmployee();
            }
            case "0" -> {
            }
            default ->
                System.out.println("Invalid input. Please try again.");
        }
        printAllEmployees();
        System.out.println("");
    }

}