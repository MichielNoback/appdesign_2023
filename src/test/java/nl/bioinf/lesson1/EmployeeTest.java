package nl.bioinf.lesson1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void addTask() {
        Employee employee = new Employee(123, "John Doe", 20000, null);
        employee.addTask("Get coffee");
        employee.addTask("Get sandwich");

        List<String> allTasks = employee.getAllTasks();
        allTasks.stream().forEach(System.out::println);
        //allTasks.clear();
        employee.addTask("Clean toilet");
        System.out.println("again");
        allTasks.stream().forEach(System.out::println);
    }
}