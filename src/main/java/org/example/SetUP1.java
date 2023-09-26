package org.example;

import java.util.ArrayList;
import java.util.List;

public class SetUP1 {
    Generator generator = new Generator();

    Employee employee = new Employee(generator.empIdGen(), generator.empGenName(), generator.empGenSurname(), generator.empGrade(), generator.empSalary(), generator.empBonusPCT(), generator.empHasPlanBeenCompleted(), generator.empDepartment());
    List<Employee> employees = new ArrayList<>();

    public List<Employee> setUp() {

        while (employees.size() < 40) {
            Employee employee = new Employee(
                    generator.empIdGen(),
                    generator.empGenName(),
                    generator.empGenSurname(),
                    generator.empGrade(),
                    generator.empSalary(),
                    generator.empBonusPCT(),
                    generator.empHasPlanBeenCompleted(),
                    generator.empDepartment()
            );
            employees.add(employee);
        }
        return employees;
    }
}
