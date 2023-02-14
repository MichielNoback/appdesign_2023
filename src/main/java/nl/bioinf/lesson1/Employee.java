package nl.bioinf.lesson1;

import java.util.*;

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
        //dynamische unmodifiable view
//        return Collections.unmodifiableList(this.tasks);
        //statische modifiable view
        return new ArrayList<>(this.tasks);
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
