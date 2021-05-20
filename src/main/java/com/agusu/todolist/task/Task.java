package com.agusu.todolist.task;


import javax.persistence.*;

@Entity
@Table
public class Task {

    @Id
    @SequenceGenerator(
        name = "task_sequence",
        sequenceName = "task_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )
    private Long id;
    private String name;
    private Boolean isComplete;

    public Task(Long id, String name, Boolean isComplete) {
        this.id = id;
        this.name = name;
        this.isComplete = isComplete;
    }

    public Task(String name) {
        this.name = name;
        this.isComplete = false;
    }

    public Task(String name, Boolean isComplete) {
        this.name = name;
        this.isComplete = isComplete;
    }

    public Task() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

    public void toggleComplete() {
        isComplete = !this.getComplete();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getComplete() {
        return isComplete;
    }

    public Boolean isComplete() {
        return isComplete;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isComplete=" + isComplete +
                '}';
    }
}
