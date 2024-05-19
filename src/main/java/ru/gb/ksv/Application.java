package ru.gb.ksv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Базовое задание:<p>
 * Условие:<p>
 * Вам предстоит создать приложение для управления списком задач с использованием Spring Boot и Spring Data JPA.
 * Требуется реализовать следующие функции:<p>
 * Добавление задачи.<p>
 * Подсказка метод в контроллере: @PostMapping public Task addTask(@RequestBody Task task)<p>
 * Просмотр всех задач.
 * Подсказка метод в контроллере: @GetMapping public List getAllTasks()<p>
 * Просмотр задач по статусу (например, "завершена", "в процессе", "не начата").<p>
 * Подсказка метод в контроллере: @GetMapping("/status/{status}") public List getTasksByStatus(@PathVariable TaskStatus status)<p>
 * Изменение статуса задачи.<p>
 * Подсказка метод в контроллере: @PutMapping("/{id}") public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task)<p>
 * Удаление задачи.<p>
 * Подсказка метод в контроллере:<p>
 * @DeleteMapping("/{id}") public void deleteTask(@PathVariable Long id)<p>
 * Репозитроий подсказка public interface TaskRepository extends JpaRepository<Task, Long><p>
 * Структура задачи(класс Task):<p>
 * ID (автоинкрементное)(тип Long)<p>
 * Описание (не может быть пустым)(тип String)<p>
 * Статус (одно из значений: "не начата", "в процессе", "завершена")(Тип TaskStatus )<p>
 * Дата создания (автоматически устанавливается при создании задачи)(Тип LocalDateTime)<p>
 * Подсказка понадобится энумератор:
 * enum TaskStatus { NOT_STARTED, IN_PROGRESS, COMPLETED; }<p>
 *
 *
 * Задание со звездочкой:<p>
 * SpringFrameworkLesson5.SpringDataForWorkingWithDatabases.example_2.src.main.java.ru.gb.ksv.Example2Application.java
 */

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
