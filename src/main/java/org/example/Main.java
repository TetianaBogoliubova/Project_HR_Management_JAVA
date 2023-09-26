package org.example;

public class Main {
    public static void main(String[] args) {

        ServiceCollection sc = new ServiceCollection();
        SetUP1 setUP1 = new SetUP1();
        Generator generator = new Generator();

        System.out.println("Генерация номера id: " + generator.empIdGen());
        System.out.println("Заполнить список из 40 сотрудников: " + setUP1.setUp());
        System.out.println("Все сотрудники, отсортированные по имени: " + sc.sortByName(setUP1.setUp()));
        System.out.println("Все сотрудники, отсортированные по зарплате: " + sc.sortBySalary(setUP1.employees));
        System.out.println("Показать имя, фамилию, департамент и грейд: " + sc.getNameSurnameDepartmentGrade(setUP1.employees));
        System.out.println("Средняя зарплата в департаметне: " + Department.SALES + " - " + sc.getAverageSalaryOufDepartment(setUP1.employees, Department.SALES));
        System.out.println("План выполнили: " + sc.getNameSurnameGradeWithPlanTrue(setUP1.employees));
        System.out.println("Повышение бонуса для сотрудников в департаменте, где больше выполненных планов: " + sc.increaseBonus(setUP1.employees));
        System.out.println("Понижение бонуса для сотрудников в департаменте, где меньше выполненных планов: " + sc.downgradeBonus(setUP1.employees));
        System.out.println("Повышение зарплат, бонусов и оценок сотрудникам, кто выполняет план: " + sc.increaseBonusAndSalaryForDepSales(setUP1.employees));

    }
}