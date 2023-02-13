package nl.bioinf.lesson1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Employee {
    private List<String> tasks = new LinkedList<>();

    private int id;
    private String name;
    private double salary;
    private Address2 address;

    public Employee(int id, String name, double salary, Address2 address) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    public void addTask(String task) {
        Objects.requireNonNull(task);
        this.tasks.add(task);
    }

    public List<String> getAllTasks() {
        return this.tasks;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "tasks=" + tasks +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
