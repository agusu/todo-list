package com.agusu.todolist.task;
import com.agusu.todolist.folder.Folder;
import com.agusu.todolist.folder.FolderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TaskConfig {
    @Bean
    CommandLineRunner commandLineRunner (TaskRepository taskRepository, FolderRepository folderRepository){
        return args -> {
            Folder folder1 = new Folder ("Chores");
            Folder folder2 = new Folder ("Work");
            Task task1 = new Task ("Vacuum floor", true, 1L);
            Task task2 = new Task ("Create a To Do List", true, 2L);
            Task task3 = new Task ("Clean bathroom" );
            Task task4 = new Task ("Get a job offer" );
            folder1.getTaskList().add(task1);
            folder1.getTaskList().add(task3);
            folder2.getTaskList().add(task2);
            folder2.getTaskList().add(task4);
            folderRepository.saveAll(List.of(folder1,folder2));
            taskRepository.saveAll(List.of(task1, task2, task3, task4));
        };
    }
}
