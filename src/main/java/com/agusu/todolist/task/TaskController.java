package com.agusu.todolist.task;

import com.agusu.todolist.folder.Folder;
import com.agusu.todolist.folder.FolderDao;
import com.agusu.todolist.folder.FolderRepository;
import com.agusu.todolist.folder.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController (TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping(path="{folderId}/")
    public List<Task> getTasks(@PathVariable("folderId") long folderId){
        return taskService.getTasksFromFolder(folderId);
    }

    @PostMapping(path="{folderId}/")
    public Task addTask(@RequestBody TaskDto task, @PathVariable("folderId") long folderId){
        return taskService.addTask(task, folderId);
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
