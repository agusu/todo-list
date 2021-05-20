package com.agusu.todolist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAllByOrderByIdAsc();
    }

    public Task addTask(TaskDto task) {

        Optional<Task> taskOptional = taskRepository.findByName(task.getName());
        if (taskOptional.isPresent()) {throw new IllegalStateException("Task already exists.");}
        Task newTask = new Task(task.getName());
        return taskRepository.save(newTask);
    }

    public void deleteTask(Long taskId) {
        boolean exists = taskRepository.existsById(taskId);
        if (!exists) {throw new IllegalStateException("TaskId does not exist");}
        taskRepository.deleteById(taskId);
    }

    public void updateTask(Long taskId, String name) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalStateException("Task id" + taskId + " does not exist"));
        Optional<Task> taskOptional = taskRepository.findByName(name);
        if (taskOptional.isPresent()) {throw new IllegalStateException("Such task already exists");}
        if (name != null && name.length() > 0 && !Objects.equals(task.getName(), name)) {
            task.setName(name);
            taskRepository.save(task);
        }
    }
    public void toggleTaskComplete(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalStateException("Task id" + taskId + " does not exist"));
        task.setComplete(!task.isComplete());
        taskRepository.save(task);
    }
}
