package org.example;


import lombok.Getter;
import lombok.Setter;

public class Employee {
    private String id;
    private String name;
    private String surname;
    private Grade grade;
    private int salary;
    private int bonusPCT;
    boolean hasPlanBeenCompleted;
    private Department department;

    public Employee() {
    }

    public Employee(String id, String name, String surname, Grade grade, int salary, int bonusPCT, boolean hasPlanBeenCompleted, Department department) {

        this.id = id;
        this.name = name;
        this.surname = surname;
        this.grade = grade;
        this.salary = salary;
        this.bonusPCT = bonusPCT;
        this.hasPlanBeenCompleted = hasPlanBeenCompleted;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonusPCT() {
        return bonusPCT;
    }

    public void setBonusPCT(int bonusPCT) {
        this.bonusPCT = bonusPCT;
    }

    public boolean isHasPlanBeenCompleted() {
        return hasPlanBeenCompleted;
    }

    public void setHasPlanBeenCompleted(boolean hasPlanBeenCompleted) {
        this.hasPlanBeenCompleted = hasPlanBeenCompleted;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", grade=" + grade +
                ", salary=" + salary +
                ", bonusPCT=" + bonusPCT +
                ", hasPlanBeenCompleted=" + hasPlanBeenCompleted +
                ", department=" + department +
                '}';
    }
}
