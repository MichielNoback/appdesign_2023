package nl.bioinf.lesson1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    private Employee defaultEmployee;

    @BeforeEach
    void setup() {
        Address address = new Address("Underthebridge", 1, "1111AA");
        defaultEmployee = new Employee(12324, "John Doe", 20000, address);
    }

    @Test
    void addTask_normal() {
        String theTask = "Copy";
        defaultEmployee.addTask(theTask);
        List<String> expectedTasks = new ArrayList<>();
        expectedTasks.add(theTask);
        List<String> allTasks = defaultEmployee.getAllTasks();
        assertAll(
                () -> assertEquals(theTask, allTasks.get(0)),
                () -> assertEquals(1, allTasks.size())
        );
//        assertEquals(theTask, allTasks.get(0));
//        assertEquals(1, allTasks.size());
    }

    @Test
    void addTask_null() {

    }

    @Test
    void addTask_emptyString() {

    }


    @Test
    @Tag("demo")
    void addTask_demoCode() {
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

    @Test
     void testSecret() {
        defaultEmployee.secretMethod();
    }
}