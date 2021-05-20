package com.agusu.todolist;

import com.agusu.todolist.task.Task;
import com.agusu.todolist.task.TaskDto;
import com.agusu.todolist.task.TaskRepository;
import com.agusu.todolist.task.TaskService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
class TodolistApplicationTests {
	@InjectMocks
	private TaskService taskService;
	@Mock
	private TaskRepository taskRepository;
	@Captor private ArgumentCaptor<Task> taskArgumentCaptor;
	@Captor private ArgumentCaptor<Long> taskIdArgumentCaptor;
	@Captor private ArgumentCaptor<String> taskNameArgumentCaptor;
	@Test
	void testCreateNewTaskAndComplete() {
		Task task = new Task(1L, "create a task", false);
		Assert.assertTrue(task.getName().equals("create a task"));
		Assert.assertTrue(task.getId().equals(1L));
		Assert.assertTrue(task.isComplete().equals(false));
		task.toggleComplete();
		Assert.assertTrue(task.isComplete().equals(true));
	}

	@Test
	void testSaveTask(){
		TaskDto task = new TaskDto(1L, "create a task", false);
		when(taskRepository.findByName(task.getName())).thenReturn(Optional.empty());
		when(taskRepository.save(any())).thenReturn(new Task(1L, "create a task", false));
		Task addedTask = taskService.addTask(task);
		verify(taskRepository, times(1)).save(taskArgumentCaptor.capture());
		Assert.assertTrue(taskArgumentCaptor.getValue().getName().equals(task.getName()));
		Assert.assertTrue(addedTask.getId().equals(task.getId()));
		Assert.assertTrue(taskArgumentCaptor.getValue().isComplete().equals(task.isComplete()));
	}

	@Test
	void testDeleteTask(){
		TaskDto task = new TaskDto(1L, "create a task", false);
		when(taskRepository.findByName(task.getName())).thenReturn(Optional.empty());
		taskService.addTask(task);
		when(taskRepository.existsById(task.getId())).thenReturn(true);
		taskService.deleteTask(task.getId());
		verify(taskRepository, times(1)).deleteById(taskIdArgumentCaptor.capture());
		Assert.assertTrue(taskIdArgumentCaptor.getValue().equals(task.getId()));
	}

	@Test
	void testUpdateTask() {
		Task task = new Task(1L, "create a task",false);
		when(taskRepository.findById(task.getId())).thenReturn(Optional.of(task));
		when(taskRepository.findByName(task.getName())).thenReturn(Optional.empty());
		taskService.updateTask(1L, "update task");
		verify(taskRepository, times(1)).save(taskArgumentCaptor.capture());
		Task updatedTask = taskArgumentCaptor.getValue();
		Assert.assertTrue(updatedTask.getName().equals(task.getName()));
	}

	@Test
	void testToggleTask() {
		Task task = new Task(1L, "finish a task", false);
		when(taskRepository.findById(task.getId())).thenReturn(Optional.of(task));
		taskService.toggleTaskComplete(1L);
		verify(taskRepository, times(1)).save(taskArgumentCaptor.capture());
		Task updatedTask = taskArgumentCaptor.getValue();
		Assert.assertTrue(updatedTask.isComplete().equals(true));

	}
}

