package com.agusu.todolist.folder;

import com.agusu.todolist.task.Task;
import com.agusu.todolist.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class FolderController {
    private final FolderService folderService;


    @Autowired
    public FolderController (FolderService folderService) {
        this.folderService = folderService;
    }

    @GetMapping(path="/api/{folderName}/tasks")
    public List<Task> getTasks(@PathVariable String folderName){
        return folderService.getTasksFromFolderName(folderName);
    }
}
