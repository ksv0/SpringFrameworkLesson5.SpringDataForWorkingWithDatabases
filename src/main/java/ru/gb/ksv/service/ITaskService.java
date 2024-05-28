package ru.gb.ksv.service;

import org.springframework.stereotype.Service;
import ru.gb.ksv.model.Task;
import ru.gb.ksv.model.TaskStatus;

import java.util.List;

@Service
public interface ITaskService {

    Task addTask(Task task);

    List<Task> findAll();

    List<Task> findAllByStatus(TaskStatus status);


    Task updateTaskStatus(Long id, Task task);

    void deleteTask(Long id);


}
