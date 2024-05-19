package ru.gb.ksv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.ksv.model.Task;
import ru.gb.ksv.model.TaskStatus;

import java.util.List;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByStatus(TaskStatus status);
}
