/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 1.2.2023 г.
 * Time: 5:44
 */
package P19ExerciseObjectsAndClasses;

import java.util.*;

public class P08CompanyRoster {
    public static class Employee {
        String name;
        double salary;
        String position;
        String department;
        String email = "n/a";
        int age = -1;
        int contains;

        public Employee(String name, double salary, String position, String department, String email, int contains) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = email;
            this.contains = contains;
        }

        public Employee(String name, double salary, String position, String department, int contains) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.contains = contains;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }


        public void setEmail(String email) {
            this.email = email;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Employee(String name, double salary, String position, String department, String email, int age, int contains) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = email;
            this.age = age;
            this.contains = contains;
        }

        public void printEmployee() {
            System.out.printf("%s %.2f %s %s%n", name, salary, email, age);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Employee> employeeList = new ArrayList<>();
        Set<String> departments = new LinkedHashSet<>();


        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            if (input.length == 4) {
                String name = input[0];
                double salary = Double.parseDouble(input[1]);
                String position = input[2];
                String department = input[3];
                Employee employee = new Employee(name, salary, position, department, input.length);
                departments.add(department);
                employeeList.add(employee);
            } else if (input.length == 5) {
                String name = input[0];
                double salary = Double.parseDouble(input[1]);
                String position = input[2];
                String department = input[3];
                Employee employee = new Employee(name, salary, position, department, input.length);
                if (input[4].contains("@")) {
                    employee.setEmail(input[4]);
                } else {
                    employee.setAge(Integer.parseInt(input[4]));
                }
                //String email = input[4];
                //Employee employee = new Employee(name, salary, position, department, email, input.length);
                departments.add(department);
                employeeList.add(employee);
            } else if (input.length == 6) {
                String name = input[0];
                double salary = Double.parseDouble(input[1]);
                String position = input[2];
                String department = input[3];
                //String email = input[4];
                //int age = Integer.parseInt(input[5]);
                Employee employee = new Employee(name, salary, position, department, input.length);
                if (input[4].contains("@")) {
                    employee.setEmail(input[4]);
                    employee.setAge(Integer.parseInt(input[5]));
                } else {
                    employee.setAge(Integer.parseInt(input[4]));
                    employee.setEmail(input[5]);
                }
                departments.add(department);
                employeeList.add(employee);
            }
        }
        double bestDepartment = 0;
        String bestDepartmentName = "";
        for (String  department : departments) {
            double totalForDepartment = 0;
            int counter = 0;
            for (Employee employee : employeeList) {
                if (employee.department.equals(department)) {
                    totalForDepartment += employee.salary;
                    counter++;
                }
            }
            double average = totalForDepartment / counter;

            if (average > bestDepartment) {
                bestDepartment = average;
                bestDepartmentName = department;
            }
        }

        employeeList.sort(Comparator.comparing(Employee::getSalary));
        Collections.reverse(employeeList);

        System.out.printf("Highest Average Salary: %s%n", bestDepartmentName);
        for (Employee employee : employeeList) {
            if (employee.department.equals(bestDepartmentName)) {
                //тук трябва да принтирам но първо трябва някак си да имплементирам брояч, колко променливи има в класа, за да направя толкова принт функции.
                employee.printEmployee();
            }
        }
    }
}
