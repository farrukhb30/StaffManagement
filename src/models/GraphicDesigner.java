package models;

import static models.EmployeeManagement.employees;
import static models.EmployeeManagement.sc;
import utilities.Gender;
import static utilities.Utilities.*;

public class GraphicDesigner extends Employee implements Manageable {

    private String techStack;
    private static double noOfGraphicDesigners;
    private static double noOfMaleGraphicDesigners;
    private static double noOfFemaleGraphicDesigners;

    {
        noOfGraphicDesigners += 1;
    }

    public GraphicDesigner() {

    }

    public GraphicDesigner(String techStack, String name, Gender gender, double salary) {
        super(name, gender, salary);
        this.techStack = techStack;
        this.genderCounter();

    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public static double getNoOfGraphicDesigners() {
        return noOfGraphicDesigners;
    }

    public static void setNoOfGraphicDesigners(int aNoOfGraphicDesigners) {
        noOfGraphicDesigners = aNoOfGraphicDesigners;
    }

    public static double getNoOfMaleGraphicDesigners() {
        return noOfMaleGraphicDesigners;
    }

    public static void setNoOfMaleGraphicDesigners(int aNoOfMaleGraphicDesigners) {
        noOfMaleGraphicDesigners = aNoOfMaleGraphicDesigners;
    }

    public static double getNoOfFemaleGraphicDesigners() {
        return noOfFemaleGraphicDesigners;
    }

    public static void setNoOfFemaleGraphicDesigners(int aNoOfFemaleGraphicDesigners) {
        noOfFemaleGraphicDesigners = aNoOfFemaleGraphicDesigners;
    }

    @Override
    public void addEmployee() {

        super.addEmployee();

        System.out.println("Input Tech Stack:");
        this.setTechStack(sc.nextLine());
        this.genderCounter();
        employees.add(this);
    }

    @Override
    public void genderCounter() {

        if (this.getGender().getText().equalsIgnoreCase("male")) {
            noOfMaleGraphicDesigners += 1;
        } else if (this.getGender().getText().equalsIgnoreCase("female")) {
            noOfFemaleGraphicDesigners += 1;
        }
    }

    @Override
    public void genderDecrementer() {

        noOfGraphicDesigners--;
        if (this.getGender().getText().equalsIgnoreCase("male")) {
            noOfMaleGraphicDesigners -= 1;
        } else if (this.getGender().getText().equalsIgnoreCase("female")) {
            noOfFemaleGraphicDesigners -= 1;
        }
    }

    @Override
    public void updateEmployee() {
        System.out.println("4. Tech Stack?");
        System.out.println("0. Exit");

        switch (readInt()) {
            case 1:
                System.out.print("New name: ");
                this.setName(sc.nextLine());
                break;
            case 2:
                System.out.println("New gender: ");
                Gender.readGender(this);
                break;
            case 3:
                System.out.print("New salary: ");
                this.setSalary(readDouble());
                this.bonus();
                break;
            case 4:
                System.out.println("New tech stack: ");
                this.setTechStack(sc.nextLine());
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Wrong input. Please try again.");
        }
    }

    @Override
    public void bonus() {

        this.setSalaryWithBonus(this.getSalary() * (1.025));

        this.setBonus(this.getSalary() * (0.025));
    }

    @Override
    public String toString() {
        return super.toString() + "TechStack:" + theStringTrimmer(techStack);
    }

}
