package com.profitsoft.task23;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Ivanov", "+380957788999", "Kharkiv", 3000.0, 200.0);
        Employee employee2 = new Employee("Petrov", "+380957788999", "Kharkiv", 2000.0, 100.0);
        Employee employee3 = new Employee("Sidorov", "+380957788999", "Kharkiv", 1000.0, 100.0);
        employee1.setId(1L);
        employee2.setId(2L);
        employee3.setId(3L);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        List<Employee> temp = new ArrayList<>();
        Employee tmpEmployee1 = new Employee("Volkov", "+380957788999", "Kharkiv", 3000.0, 200.0);
        Employee tmpEmployee2 = new Employee("Zaytsev", "+380957788999", "Kharkiv", 2000.0, 100.0);
        Employee tmpEmployee3 = new Employee("Medvedev", "+380957788999", "Kharkiv", 1000.0, 100.0);
        tmpEmployee1.setId(1L);
        temp.add(tmpEmployee1);
        temp.add(tmpEmployee2);
        temp.add(tmpEmployee3);

        List<Employee> updatedList = deepMerge(employees, temp);
        updatedList.forEach(System.out::println);
    }

    private static List<Employee> merge(List<Employee> to, List<Employee> from) {
        try {
            List<Employee> tempListemployees = from.stream().filter(c -> c.getId() < 0).collect(Collectors.toList());
            Long lastId = to.stream().mapToLong(c -> c.getId()).max().orElseThrow(NoSuchElementException::new);
            for (Employee employee : tempListemployees) {
                employee.setId(++lastId);
            }
            to.addAll(tempListemployees);
            return to;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Employee> deepMerge(List<Employee> to, List<Employee> from) {
        List<Employee> tempListemployees = from.stream().filter(c -> c.getId() > -1).collect(Collectors.toList());
        for(Employee employee : to){
            for(Employee employee1 : tempListemployees){
                update(employee, employee1);
            }
        }
        tempListemployees = merge(to, from);
        return tempListemployees;
    }

    private static boolean update(Employee to, Employee from) {
        if (to.equals(from)) {
            if (!from.getName().isEmpty() && from.getName() != null) {
                to.setName(from.getName());
            }
            if (!from.getPhone().isEmpty() && from.getPhone() != null) {
                to.setPhone(from.getPhone());
            }
            if (!from.getRegion().isEmpty() && from.getRegion() != null) {
                to.setRegion(from.getRegion());
            }
            to.setSalaryPerMonth(from.getSalaryPerMonth());
            to.setWorkedHours(from.getWorkedHours());
            return true;
        } else return false;
    }
}
