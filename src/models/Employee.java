package models;

import static utilities.Utilities.*;
import static models.EmployeeManagement.sc;
import utilities.Gender;
import static models.EmployeeManagement.df;

public class Employee {

    public static int employeeNumberGenerator = 1;
    private int employeeNr;
    private String name;
    private Gender gender;
    private double salary;
    private double bonus;
    private double salaryWithBonus;
    private static double noOfMaleEmployees;
    private static double noOfFemaleEmployees;

    public Employee() {
        this.employeeNr = employeeNumberGenerator++;
    }

    public Employee(String name, Gender gender, double salary) {

        this.employeeNr = employeeNumberGenerator++;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.salaryWithBonus = salary;

        if (gender.getText().equalsIgnoreCase("male")) {
            noOfMaleEmployees += 1;
        } else if (gender.getText().equalsIgnoreCase("female")) {
            noOfFemaleEmployees += 1;
        }

    }

    public static double getNoOfMaleEmployees() {
        return noOfMaleEmployees;
    }

    public static void setNoOfMaleEmployees(int aNoOfMaleEmployees) {
        noOfMaleEmployees = aNoOfMaleEmployees;
    }

    public static double getNoOfFemaleEmployees() {
        return noOfFemaleEmployees;
    }

    public static void setNoOfFemaleEmployees(int aNoOfFemaleEmployees) {
        noOfFemaleEmployees = aNoOfFemaleEmployees;
    }

    public double getSalaryWithBonus() {
        return salaryWithBonus;
    }

    public void setSalaryWithBonus(double salaryWithBonus) {
        this.salaryWithBonus = salaryWithBonus;
    }

    public int getEmployeeNr() {
        return employeeNr;
    }

    public void setEmployeeNr(int employeeNr) {
        this.employeeNr = employeeNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void bonus() {
    }

    public void updateEmployee() {
    }
    
    public void genderCounter(){
    }
            
    public void genderDecrementer(){
    }

    public void addEmployee() {

        System.out.println("Input name:");
        this.setName(sc.nextLine());
        System.out.println("Input gender:");
        Gender.readGender(this);   
        System.out.println("Input salary:");
        this.setSalary(readDouble());
        this.bonus();

        if (this.getGender().getText().equalsIgnoreCase("male")) {
            noOfMaleEmployees += 1;
       } else if (this.getGender().getText().equalsIgnoreCase("female")) {
            noOfFemaleEmployees += 1;
        }

    }


    @Override
    public String toString() {

        return theStringTrimmer(String.valueOf(employeeNr)) + theStringTrimmer(name) + theStringTrimmer(gender.getText()) + theStringTrimmer(df.format(salary)) + theStringTrimmer(df.format(salaryWithBonus));

    }


}
