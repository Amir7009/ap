package ap.exercises.ex4;

public class Main_EX4_E3_12 { // Employee

    private String name;
    private double salary;

    public Main_EX4_E3_12(String employeeName, double currentSalary){

        name = employeeName;
        salary = currentSalary;

    }

    public String getName(){

        return name;

    }

    public double getSalary(){

        return salary;

    }

    public void raiseSalary(double byPercent){

        salary *= (1+byPercent/100);

    }

}
