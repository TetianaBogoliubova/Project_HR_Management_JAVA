package org.example;

import java.util.*;

import static org.example.Grade.*;
// - показать всех отсортировав по имени
// - показать всех отсортировав по зарплате
// - показать имя, фамилию, департамент и грейд
// - показать среднюю зарплату по департаментам
// - показать имя, фамилию и грейд только у тех кто выполнил план. hasPlanBeenCompleted = тру
// - повысить % бонуса у всех сотрудников того департамента, в котором больше всего сотрудников hasPlanBeenCompleted = тру,
//    если таких несколько то повысить у всех.
// - понизить % бонуса у департамента у которого меньше всего сотрудников выполнило план, если таких несколько то у всех
// - у департамента продаж взять всех кто выполнили план и если у сотруднка который выполнил план грейд А то повысить зп и бонус,
//    если грейд ниже то повысить на 1 ступень и только зп.

public class ServiceCollection {

    private final Comparator<Employee> comparatorEmployee = new ComparatorNameOfEmployee();
    private final Comparator<Employee> comparatorSalary = new ComparatorSalaryOfEmployee();

    //показать всех, отсортировав по имени
    public List sortByName(List employees) {
        employees.sort(comparatorEmployee);
        return employees;
    }

    //показать всех, отсортировав по зарплате
    public List sortBySalary(List employees) {
        employees.sort(comparatorSalary);
        return employees;
    }

    //показать имя, фамилию, департамент и грейд
    public List<String> getNameSurnameDepartmentGrade(List<Employee> employees) {
        List<String> newList = new ArrayList<>();

        for (Employee i : employees) {
            String mainInformation = "Name: " + i.getName() + ", surname: " + i.getSurname() + ", department: " + i.getDepartment() + ", grade: " + i.getGrade();
            newList.add(mainInformation);
        }
        return newList;
    }

    //показать среднюю зарплату по департаментам
    public int getAverageSalaryOufDepartment(List<Employee> employees, Department department) {
        int aver = 0;
        int sumAver = 0;
        int j = 0;
        for (Employee i : employees) {
            if (i.getDepartment().equals(department)) {
                j++;
                aver = aver + i.getSalary();
                sumAver = aver / j;
            }
        }
        return sumAver;
    }

    //показать имя, фамилию и грейд только у тех, кто выполнил план. hasPlanBeenCompleted = true
    public List<String> getNameSurnameGradeWithPlanTrue(List<Employee> employees) {
        List<String> newList = new ArrayList<>();
        for (Employee i : employees) {
            if (i.hasPlanBeenCompleted) {
                String infoAboutHasPlanBeenCompleted = "Name: " + i.getName() + " Surname: " + i.getSurname() + ", Grade: " + i.getGrade();
                newList.add(infoAboutHasPlanBeenCompleted);
            }
        }
        return newList;
    }

    //- повысить % бонуса у всех сотрудников того департамента, в котором больше всего сотрудников
    // hasPlanBeenCompleted = true, если таких несколько, то повысить у всех.
    public List<String> increaseBonus(List<Employee> employees) {
        List<String> newList = new ArrayList<>();
        Map<Department, Integer> employeeMap = new HashMap<>();
        int bonus = 0;
        Department maxDep = null;
        int maxEmp = 0;
        for (Employee i : employees) {
            if (i.hasPlanBeenCompleted) {
                employeeMap.put(i.getDepartment(), employeeMap.getOrDefault(i.getDepartment(), 0) + 1);
            }
        }
        Map.Entry<Department, Integer> maxEntry = null;
        for (Map.Entry<Department, Integer> i : employeeMap.entrySet()) {
            if (maxEntry == null || i.getValue() > maxEntry.getValue()) {
                maxEntry = i;
                maxDep = maxEntry.getKey();
                maxEmp = maxEntry.getValue();
            }
        }
        for (Employee i : employees) {
            if (i.getDepartment().equals(maxDep)) {
                String infoAboutBonus = "Bonus for " + i.getName() + " " + i.getSurname() + ": " + (i.getBonusPCT() + (i.getBonusPCT() * 0.1));
                newList.add(infoAboutBonus);
            }
        }
        return newList;
    }

    // Понизить % бонуса у департамента, у которого меньше всего сотрудников выполнило план, если таких несколько,
    // то у всех
    public List<String> downgradeBonus(List<Employee> employees) {
        List<String> newList = new ArrayList<>();
        Map<Department, Integer> employeeMap = new HashMap<>();
        Department minDep = null;
        int maxEmp = 0;
        int bonus = 0;
        for (Employee i : employees) {
            if (!i.hasPlanBeenCompleted) {
                employeeMap.put(i.getDepartment(), employeeMap.getOrDefault(i.getDepartment(), 0) + 1);
            }
        }
        Map.Entry<Department, Integer> maxEntry = null;
        for (Map.Entry<Department, Integer> i : employeeMap.entrySet()) {
            if (maxEntry == null || i.getValue() > maxEntry.getValue()) {
                maxEntry = i;
                minDep = maxEntry.getKey();
                maxEmp = maxEntry.getValue();
            }
        }
        for (Employee i : employees) {
            if (i.getDepartment().equals(minDep)) {
                String infoAboutBonus = "Bonus for " + i.getName() + " " + i.getSurname() + ": " + (i.getBonusPCT() - (i.getBonusPCT() * 0.1));
                newList.add(infoAboutBonus);
            }
        }
        return newList;
    }
    //У департамента продаж взять всех, кто выполнили план и, если у сотрудника, который выполнил план
    // грейд А, то повысить зп и бонус, если грейд ниже, то повысить на 1 ступень и только зп.

    public List<String> increaseBonusAndSalaryForDepSales(List<Employee> employees) {

        List<String> newList = new ArrayList<>();

        for (Employee i : employees) {
            if (i.getDepartment().equals(Department.SALES) && i.hasPlanBeenCompleted
                    && i.getGrade().equals(A)) {
                int newSalary1 = (int) ((int) i.getSalary() + i.getSalary() * 0.1);
                int newBonus1 = (int) ((int) i.getBonusPCT() + (i.getBonusPCT() * 0.1));
                String info1 = "Increase of bonus and salary for " + i.getName() + " " + i.getSurname() + ", " + i.getGrade() + ": " + newSalary1 + ", " + newBonus1;
                newList.add(info1);
            }
            if (i.getDepartment().equals(Department.SALES) && i.hasPlanBeenCompleted
                    && i.getGrade().equals(B)) {
                int newSalary2 = (int) ((int) i.getSalary() + i.getSalary() * 0.1);
                Grade newGrade1 = B;
                String info2 = "Increase of grade and salary for " + i.getName() + " " + i.getSurname() + ": " + newSalary2 + ", " + newGrade1;
                newList.add(info2);
            }
            if (i.getDepartment().equals(Department.SALES) && i.hasPlanBeenCompleted
                    && i.getGrade().equals(C)) {
                int newSalary2 = (int) ((int) i.getSalary() + i.getSalary() * 0.1);
                Grade newGrade2 = B;
                String info3 = "Increase of grade and salary for " + i.getName() + " " + i.getSurname() + ": " + newSalary2 + ", " + newGrade2;
                newList.add(info3);
            }
            if (i.getDepartment().equals(Department.SALES) && i.hasPlanBeenCompleted
                    && i.getGrade().equals(D)) {
                int newSalary2 = (int) ((int) i.getSalary() + i.getSalary() * 0.1);
                Grade newGrade3 = C;
                String info4 = "Increase of grade and salary for " + i.getName() + " " + i.getSurname() + ": " + newSalary2 + ", " + newGrade3;
                newList.add(info4);
            }
        }
        return newList;
    }
}




