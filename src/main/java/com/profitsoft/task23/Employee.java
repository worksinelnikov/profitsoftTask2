package com.profitsoft.task23;

import java.util.Objects;

public class Employee {
    private Long id;
    private String name;
    private String phone;
    private String region;
    private double salaryPerMonth;
    private double workedHours;
    public final int PERCENT = 100;

    public Employee() {
    }

    public Employee(String name, String phone, String region, double salaryPerMonth, double workedHours) {
        this.id = -1L;
        this.name = name;
        this.phone = phone;
        this.region = region;
        this.salaryPerMonth = salaryPerMonth;
        this.workedHours = workedHours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public void setSalaryPerMonth(double salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
    }

    public double getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(double workedHours) {
        this.workedHours = workedHours;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getHoursPercent(int hoursPerMonth) {
        return workedHours * PERCENT / hoursPerMonth;
    }

    /**
     * calculate Salary method, must be overridden in child classes
     *
     * @param hoursPerMonth - parameter for Booker
     * @return double value Math.round in 2
     */
    //protected abstract double getMonthSalary(int hoursPerMonth);
    protected double getMonthSalary(int hoursPerMonth) {
        double salary = getSalaryPerMonth() * getHoursPercent(hoursPerMonth) / PERCENT;
        return Math.round(salary * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return String.format("%5s. Name: %10s (phone %s, %s)\tSalary per month: $%.2f\tWorked hours: %.2f", id, name, phone, region, salaryPerMonth, workedHours);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return this.id.equals(employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone, region, salaryPerMonth, workedHours, PERCENT);
    }
}
