package org.example;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

public class Generator {

    Faker faker = new Faker();
    Random random = new Random();

    public String empIdGen() {
        int idNumber = random.nextInt(100000000);
        return "EMP%" + idNumber;
    }

    public String empGenName() {
        String name = faker.name().firstName();
        return name;
    }

    public String empGenSurname() {
        String surName = faker.name().lastName();
        return surName;
    }

    public Grade empGrade() {
        Employee employee = new Employee();
        Grade[] grades = Grade.values();
        int indexGrade = random.nextInt(grades.length);
        employee.setGrade(grades[indexGrade]);
        return employee.getGrade();
    }

    public int empSalary() {
        int salary = random.nextInt(5000, 50000);
        return salary;
    }

    public int empBonusPCT() {
        int bonus = random.nextInt(1, 10);
        return bonus;
    }

    public boolean empHasPlanBeenCompleted() {
        boolean hasPlanBeenCompleted = random.nextBoolean();
        return hasPlanBeenCompleted;
    }

    public Department empDepartment() {
        Employee employee = new Employee();
        Department[] departments = Department.values();
        int indexDep = random.nextInt(departments.length);
        employee.setDepartment(departments[indexDep]);
        return employee.getDepartment();
    }
}
