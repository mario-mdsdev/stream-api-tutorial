package com.mdsdev.streamapi;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class StreamApiTutorialApplication {

    static List<Employee> employees = new ArrayList<>();

    static {
        employees.add(
                new Employee("Shabbir", "Dawoodi", 5000.0, List.of("Project 1", "Project 2"))
        );
        employees.add(
                new Employee("Nikhil", "Gupta", 6000.0, List.of("Project 1", "Project 3"))
        );
        employees.add(
                new Employee("Shivam", "Kumar", 5500.0, List.of("Project 3", "Project 4"))
        );
    }

    public static void main(String[] args) {
//        SpringApplication.run(StreamApiTutorialApplication.class, args);

        // --> For Each is a terminal operation, once called, you can't do any operation after that
        employees.stream().forEach(employee -> System.out.println(employee));

        // --> Map to add some basic intermediate operation
        //     It takes an object and then gives you another
        //     For example, increase the salary in 10%
        final List<Employee> increasedSalary =
                employees.stream()
                        .map(employee ->
                                new Employee(
                                        employee.getFirstName(),
                                        employee.getLastName(),
                                        employee.getSalary() * 1.10,
                                        employee.getProjects()
                                ))
                        .collect(Collectors.toList());
        System.out.println(increasedSalary);

        // --> Filter is basically an operation of if else loop to filter the data
        //     Predicate is an execution based on true or false value
        //     For example, to increase salary only if it is greater than 5000
        final List<Employee> filterEmployee =
                employees.stream()
                .filter(employee -> employee.getSalary() > 5000.0)
                .map(employee ->
                        new Employee(
                                employee.getFirstName(),
                                employee.getLastName(),
                                employee.getSalary() * 1.10,
                                employee.getProjects()
                        ))
                .collect(Collectors.toList());
        System.out.println(filterEmployee);

        //+-----------------------------------------------------------------------+
        //|--> Any operation that returns the stream is an intermediate operation |
        //+-----------------------------------------------------------------------+

        // --> Get the first employee whose salary has increased
        final Employee firstEmployee =
                employees.stream()
                        .filter(employee -> employee.getSalary() > 5000.0)
                        .map(employee ->
                                new Employee(
                                        employee.getFirstName(),
                                        employee.getLastName(),
                                        employee.getSalary() * 1.10,
                                        employee.getProjects()
                                ))
                        .findFirst()
                        .orElse(null);
        System.out.println(firstEmployee);
    }

}
