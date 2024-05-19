package ru.gb.ksv.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.ksv.exception.TaskNotFoundException;
import ru.gb.ksv.model.Task;
import ru.gb.ksv.model.TaskStatus;
import ru.gb.ksv.repository.ITaskRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService implements ITaskService {
    private final ITaskRepository taskRepository;

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> findAllByStatus(TaskStatus status) {
        return taskRepository.findAllByStatus(status);
    }

    @Override
    public Task updateTaskStatus(Long id, Task task) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));

        existingTask.setDescription(task.getDescription());
        existingTask.setStatus(task.getStatus());
        existingTask.setCreatedAt(task.getCreatedAt());

        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
