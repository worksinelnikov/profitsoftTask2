package com.profitsoft.task23;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MergerTest {
    private Merger merger;
    private Employee employee1 = new Employee("Ivanov", "+380957788999", "Kharkiv");
    private Employee employee2 = new Employee("Petrov", "+380957788999", "Kharkiv");
    private Employee employee3 = new Employee("Sidorov", "+380957788999", "Kharkiv");
    private List<Employee> employees;
    private List<Employee> expected;

    @Before
    public void setUp() throws Exception {
        merger = new Merger();

        employee1.setId(1L);
        employee2.setId(2L);
        employee3.setId(3L);
        employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        List<Employee> temp = new ArrayList<>();
        Employee tmpEmployee1 = new Employee("Volkov", "+380957788999", "Kharkiv");
        Employee tmpEmployee2 = new Employee("Zaytsev", "+380957788999", "Kharkiv");
        Employee tmpEmployee3 = new Employee("Medvedev", "+380957788999", "Kharkiv");
        tmpEmployee1.setId(2L);
        temp.add(tmpEmployee1);
        temp.add(tmpEmployee2);
        temp.add(tmpEmployee3);
    }

    @After
    public void tearDown() throws Exception {
        employee1 = null;
        employee2 = null;
        employee3 = null;
        employees = null;
        merger = null;
    }

    @Test
    public void merge() {
        List<Employee> temp = new ArrayList<>();
        Employee tmpEmployee1 = new Employee("Volkov", "+380957788999", "Kharkiv");
        Employee tmpEmployee2 = new Employee("Zaytsev", "+380957788999", "Kharkiv");
        Employee tmpEmployee3 = new Employee("Medvedev", "+380957788999", "Kharkiv");
        tmpEmployee1.setId(2L);
        temp.add(tmpEmployee1);
        temp.add(tmpEmployee2);
        temp.add(tmpEmployee3);

        expected = new ArrayList<>();
        Employee expEmployee2 = new Employee("Zaytsev", "+380957788999", "Kharkiv");
        Employee expEmployee3 = new Employee("Medvedev", "+380957788999", "Kharkiv");
        expected.add(employee1);
        expected.add(employee2);
        expected.add(employee3);
        expected.add(expEmployee2);
        expected.add(expEmployee3);

        assertEquals(expected, merger.merge(employees, temp));
    }

    @Test
    public void deepMerge() {
        List<Employee> temp = new ArrayList<>();
        Employee tmpEmployee1 = new Employee("Volkov", "+380957788999", "Kharkiv");
        Employee tmpEmployee2 = new Employee("Zaytsev", "+380957788999", "Kharkiv");
        Employee tmpEmployee3 = new Employee("Medvedev", "+380957788999", "Kharkiv");
        temp.add(tmpEmployee1);
        temp.add(tmpEmployee2);
        temp.add(tmpEmployee3);

        employee1.setRegion("Kyiv");
        temp.add(employee1);

        expected = new ArrayList<>();
        Employee expEmployee1 = new Employee("Ivanov", "+380957788999", "Kyiv");
        expEmployee1.setId(1L);
        Employee expEmployee2 = new Employee("Petrov", "+380957788999", "Kharkiv");
        expEmployee2.setId(2L);
        Employee expEmployee3 = new Employee("Sidorov", "+380957788999", "Kharkiv");
        expEmployee3.setId(3L);
        Employee expEmployee4 = new Employee("Volkov", "+380957788999", "Kharkiv");
        Employee expEmployee5 = new Employee("Zaytsev", "+380957788999", "Kharkiv");
        Employee expEmployee6 = new Employee("Medvedev", "+380957788999", "Kharkiv");
        expected.add(expEmployee1);
        expected.add(expEmployee2);
        expected.add(expEmployee3);
        expected.add(expEmployee4);
        expected.add(expEmployee5);
        expected.add(expEmployee6);

        assertEquals(expected, merger.deepMerge(employees,temp));
    }
}