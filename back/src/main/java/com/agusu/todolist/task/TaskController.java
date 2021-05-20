package com.agusu.todolist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/task")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController (TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @PostMapping
    public Task addTask(@RequestBody TaskDto task){
        return taskService.addTask(task);
    }

    @DeleteMapping(path="{taskId}")
    public void deleteTask(@PathVariable("taskId") Long taskId) {
        taskService.deleteTask(taskId);
    }

    @PutMapping
    public void updateTask(@RequestBody TaskDto taskdto) {
        taskService.updateTask(taskdto.getId(), taskdto.getName());
    }

    @PatchMapping(path="{taskId}")
    public void toggleTaskComplete(@PathVariable("taskId") Long taskId) {
        taskService.toggleTaskComplete(taskId);
    }

}
