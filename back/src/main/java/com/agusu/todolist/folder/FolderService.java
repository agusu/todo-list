package com.agusu.todolist.folder;

import com.agusu.todolist.task.Task;
import com.agusu.todolist.task.TaskRepository;
import com.agusu.todolist.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FolderService {
    private final TaskService taskService;
    private final FolderRepository folderRepository;

    @Autowired
    public FolderService(TaskService taskService, FolderRepository folderRepository){
        this.taskService = taskService;
        this.folderRepository = folderRepository;
    }


    public List<Task> getTasksFromFolderName(String folderName) {
        Folder folder = folderRepository.findFolderByName(folderName);

        return taskService.getTasksFromFolder(folder.getId());
    }
}
