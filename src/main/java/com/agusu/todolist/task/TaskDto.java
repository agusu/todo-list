package com.agusu.todolist.task;

public class TaskDto {
    private Long id;
    private String name;
    private Boolean isComplete;

    public TaskDto(Long id, String name, Boolean isComplete) {
        this.id = id;
        this.name = name;
        this.isComplete = isComplete;
    }

    public TaskDto(String name) {
        this.name = name;
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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean isComplete() {
        return isComplete;
    }
}
