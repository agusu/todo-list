package com.agusu.todolist.task;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TaskConfig {
    @Bean
    CommandLineRunner commandLineRunner (TaskRepository taskRepository){
        return args -> {
            Task task1 = new Task ("Create a task", true);
            Task task2 = new Task ("Call mom");
            Task task3 = new Task ("Vacuum floor", true);
            Task task4 = new Task ("Take out trash");

            taskRepository.saveAll(List.of(task1, task2, task3, task4));
        };
    }
}
