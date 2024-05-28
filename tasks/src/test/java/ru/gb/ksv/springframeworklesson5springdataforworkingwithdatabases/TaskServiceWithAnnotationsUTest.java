package ru.gb.ksv.springframeworklesson5springdataforworkingwithdatabases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.gb.ksv.exception.TaskNotFoundException;
import ru.gb.ksv.model.Task;
import ru.gb.ksv.model.TaskStatus;
import ru.gb.ksv.repository.ITaskRepository;
import ru.gb.ksv.service.TaskService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceWithAnnotationsUTest {

    @Mock
    private ITaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    private Task task1;
    private Task task2;


    @BeforeEach
    public void setUp() {
        task1 = new Task(
                1L,
                "Task 1",
                TaskStatus.NOT_STARTED,
                LocalDateTime.now());
        task2 = new Task(
                2L,
                "Task 2",
                TaskStatus.IN_PROGRESS,
                LocalDateTime.now());
    }

    @Test
    public void addTask_shouldSaveTask() {
        when(taskRepository.save(any(Task.class))).thenReturn(task1);

        Task savedTask = taskService.addTask(task1);

        verify(taskRepository, times(1)).save(eq(task1));
        assertEquals(task1, savedTask);
    }

    @Test
    public void findAll_shouldReturnAllTasks() {
        List<Task> tasks = Arrays.asList(task1, task2);
        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> allTasks = taskService.findAll();

        verify(taskRepository, times(1)).findAll();
        assertEquals(tasks, allTasks);
    }

    @Test
    public void findAllByStatus_shouldReturnTasksByStatus() {
        List<Task> tasks = Arrays.asList(task1);
        when(taskRepository.findAllByStatus(eq(TaskStatus.NOT_STARTED))).thenReturn(tasks);

        List<Task> openTasks = taskService.findAllByStatus(TaskStatus.NOT_STARTED);

        verify(taskRepository, times(1)).findAllByStatus(eq(TaskStatus.NOT_STARTED));
        assertEquals(tasks, openTasks);
    }

    @Test
    public void updateTaskStatus_shouldUpdateTaskAndReturnUpdatedTask() {
        when(taskRepository.findById(eq(1L))).thenReturn(Optional.of(task1));
        when(taskRepository.save(any(Task.class))).thenReturn(task1);

        Task updatedTask = taskService.updateTaskStatus(
                1L,
                new Task(
                        1L,
                        "Updated Task",
                        TaskStatus.CLOSED,
                        LocalDateTime.now()));

        verify(taskRepository, times(1)).findById(eq(1L));
        verify(taskRepository, times(1)).save(any(Task.class));
        assertEquals(task1.getId(), updatedTask.getId());
        assertEquals("Updated Task", updatedTask.getDescription());
        assertEquals(TaskStatus.CLOSED, updatedTask.getStatus());
    }

    @Test
    public void updateTaskStatus_shouldThrowTaskNotFoundException_whenTaskNotFound() {
        when(taskRepository.findById(eq(1L))).thenReturn(Optional.empty());

        assertThrows(TaskNotFoundException.class,
                () -> taskService.updateTaskStatus(
                        1L, new Task(
                                1L,
                                "Updated Task",
                                TaskStatus.CLOSED,
                                LocalDateTime.now())));

        verify(taskRepository, times(1)).findById(eq(1L));
        verify(taskRepository, never()).save(any(Task.class));
    }

    @Test
    public void deleteTask_shouldDeleteTaskById() {
        taskService.deleteTask(1L);

        verify(taskRepository, times(1)).deleteById(eq(1L));
    }
}