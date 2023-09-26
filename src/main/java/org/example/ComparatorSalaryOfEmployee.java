package org.example;

import java.util.Comparator;

public class ComparatorSalaryOfEmployee implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getSalary(), o2.getSalary());
    }
}
