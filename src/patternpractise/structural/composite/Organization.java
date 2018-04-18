package patternpractise.structural.composite;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Organization {

    private List<Employee> employees;

    public Organization() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public Double getNetSalaries() {
        return this.employees
                .stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    public Double getAverageSalary1() {
        return this.employees
                .stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
    }

    public Double getAverageSalary2() {
        return this.employees
                .stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary))
                .getAverage();
    }

    public Double getHighestSalary() {
        return this.employees
                .stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary))
                .getMax();
    }

    public Employee getFirstEmployee() {
        return this.employees
                .stream()
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
    }

    public void printOutAllEmployees() {
        this.employees
                .stream()
                .forEach(System.out::println);
    }

    public void printOutAllEmployeesAndSalaries() {
        this.employees
                .stream()
                .map(emp -> String.format("%s %s", emp.getName(), emp.getSalary()))
                .forEach(System.out::println);
    }

    public String printOutAllEmployeesAndSalaries2() {
        return this.employees
                .stream()
                .collect(Collector.of(
                        () -> new StringJoiner(" "),
                        (strBuild, emp) -> strBuild.add(emp.getName()).add(String.valueOf(emp.getSalary())),
                        (sb1, sb2) -> sb1.merge(sb2),
                        StringJoiner::toString
                ));
    }

    public List<Employee> filterByName(String name) {
        return this.employees
                .stream()
                .filter( emp -> emp.getName().equals(name))
                .collect(Collectors.toList());
    }

    public Map<String, Employee> convertMap() {
        return this.employees
                .stream()
                .collect(Collectors.toMap(
                        emp -> emp.getName(),
                        emp -> emp
                ));
    }

    public List<Employee> sortBySalary() {
        return this.employees
                .stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());
    }

    public static void main(String[] vargs) {
        Organization organization = new Organization();
        organization.addEmployee(new Designer("Jess", 15.00));
        organization.addEmployee(new Developer("Andrew", 10.00));

        System.out.println(organization.getNetSalaries());
        System.out.println(organization.getAverageSalary1());
        System.out.println(organization.getHighestSalary());
        System.out.println(organization.getFirstEmployee());

        System.out.println(organization.filterByName("John"));
        System.out.println(organization.filterByName("Andrew"));

        System.out.println("Map: " + organization.convertMap());

        organization.printOutAllEmployees();

        organization.printOutAllEmployeesAndSalaries();

        System.out.println(organization.printOutAllEmployeesAndSalaries2());
    }
}
