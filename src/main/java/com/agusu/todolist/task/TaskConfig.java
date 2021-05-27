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
            folderRepository.saveAll(List.of(folder1,folder2));
            Task task1 = new Task ("Vacuum floor", true);
            Task task2 = new Task ("Create a To Do List", true);
            Task task3 = new Task ("Clean bathroom" );
            Task task4 = new Task ("Get a job offer" );
            task1.setFolder(folder1);
            task2.setFolder(folder2);


            taskRepository.saveAll(List.of(task1, task2, task3, task4));
        };
    }
}
