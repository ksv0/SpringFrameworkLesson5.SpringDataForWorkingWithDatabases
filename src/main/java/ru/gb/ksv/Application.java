package ru.gb.ksv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Базовое задание:
 * Домашнее задание выполнить для одного из пройденных семинаров в проекте с Базой Данных.
 * Вам необходимо разработать механизм регистрации действий пользователя в вашем Spring Boot приложении. Используйте Spring AOP
 * для создания журнала действий, в котором будет сохраняться информация о том, какие методы сервиса вызывались, кем и с какими параметрами.
 * <p>
 * 1. Создайте аннотацию @TrackUserAction.<p>
 * 2. Реализуйте aspect, который будет регистрировать действия пользователя, когда вызывается метод, отмеченный этой аннотацией.<p>
 * 3. Примените аннотацию @TrackUserAction к нескольким методам в слое сервиса.<p>
 * 4. Результаты регистрации в консоль<p>
 * Внимание логировать все методы не нужно. Несколько, чтобы показать использование аспектов.
 */

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
