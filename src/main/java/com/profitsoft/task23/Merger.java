package com.profitsoft.task23;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Merger {
    public void main() {

        //List<Employee> updatedList = deepMerge(employees, temp);
        //updatedList.forEach(System.out::println);
    }

    public List<Employee> merge(List<Employee> to, List<Employee> from) {
        try {
            List<Employee> tempListEmployees = from.stream().filter(c -> c.getId() == 0L).collect(Collectors.toList());
            to.addAll(tempListEmployees);
            return to;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Employee> deepMerge(List<Employee> to, List<Employee> from) {
        List<Employee> temp = to.stream().filter(c -> {
            Employee employee = getEmployee(c, from);
            if (employee != null) {
                update(c, employee);
                //return true;
            }
            return true;
        }).collect(Collectors.toList());
        return merge(temp, from);
    }

    private Employee getEmployee(Employee employee, List<Employee> employees) {
        if (employees != null) {
            return employees.stream().filter(c -> c.equals(employee)).findFirst().orElse(null);
        }
        return null;
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
