package com.agusu.todolist.task;

import com.agusu.todolist.folder.Folder;
import com.agusu.todolist.folder.FolderRepository;
import com.agusu.todolist.folder.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    private final FolderRepository folderRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, FolderRepository folderRepository){
        this.taskRepository = taskRepository;
        this.folderRepository = folderRepository;
    }

    public List<Task> getTasksFromFolder(Long folderId) {
        return taskRepository.findAllByFolderIdOrderById(folderId);
    }

    public List<Task> getTasks() {
        return taskRepository.findAllByOrderByIdAsc();
    }

    public Task addTask(TaskDto task, long folderId) {
        Optional<Task> taskOptional = taskRepository.findByName(task.getName());
        if (taskOptional.isPresent()) {throw new IllegalStateException("Task already exists.");}
        Folder folder = folderRepository.findById(folderId)
                .orElseThrow(() -> new IllegalStateException("Folder Id" + folderId + " does not exist"));
        Task newTask = new Task(task.getName());
        newTask.setFolder(folder);
        return taskRepository.save(newTask);
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
