package models;

import static utilities.Utilities.*;
import static models.EmployeeManagement.sc;
import utilities.Gender;
import static models.EmployeeManagement.df;

public class Employee {

    public static int employeeNumberGenerator = 1;
    private int employeeNr;
    private String firstName;
    private String lastName;
    private Gender gender;
    private double salary;
    private double bonus;
    private double salaryWithBonus;
    private static double noOfMaleEmployees;
    private static double noOfFemaleEmployees;
    private static double noOfUnknownGenderEmployees;

    public Employee() {
        this.employeeNr = employeeNumberGenerator++;
    }

    public Employee(String firstName, String lastName, Gender gender, double salary) {

        this.employeeNr = employeeNumberGenerator++;
        setName(firstName, lastName);
        this.gender = gender;
        this.salary = salary;
        this.salaryWithBonus = salary;

        if (gender.getText().equalsIgnoreCase("male")) {
            noOfMaleEmployees++;
        } else if (gender.getText().equalsIgnoreCase("female")) {
            noOfFemaleEmployees++;
        }else{
            noOfUnknownGenderEmployees++;
        }

    }

    private void setName(String firstName, String surName) {
        this.firstName = firstName;
        this.lastName = surName;
    }

    public String getName() {
     
        return this.firstName.concat(" ").concat(lastName);
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

    public void genderCounter() {
    }

    public void genderDecrementer() {
    }

    public void addEmployee() {

        System.out.println("Input First name:");
        this.firstName = sc.nextLine();
        System.out.println("Input Last name:");
        this.lastName = sc.nextLine();
        System.out.println("Input gender:");
        Gender.readGender(this);
        System.out.println("Input salary:");
        this.setSalary(readDouble());
        this.bonus();

        if (this.getGender().getText().equalsIgnoreCase("male")) {
            noOfMaleEmployees++;
        } else if (this.getGender().getText().equalsIgnoreCase("female")) {
            noOfFemaleEmployees++;
        }else {
            noOfUnknownGenderEmployees++;
        }

    }

    @Override
    public String toString() {

        return theStringTrimmer(String.valueOf(employeeNr)) + theStringTrimmer(getName()) + theStringTrimmer(gender.getText()) + theStringTrimmer(df.format(salary)) + theStringTrimmer(df.format(salaryWithBonus));

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
