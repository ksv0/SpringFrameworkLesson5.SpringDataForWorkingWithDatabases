package ru.gb.ksv;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.gb.ksv.service.IStorageService;

/**
 * Задание со звездочкой:<p>
 * Cоздать серверное приложение, которое может получать файлы, загружаемые по протоколу HTTP из нескольких частей.<p>
 * Для основы проекта взять пример: https://spring.io/guides/gs/uploading-files<p>
 */
@SpringBootApplication
@ConfigurationPropertiesScan
@EnableWebMvc
public class Example2Application {

    public static void main(String[] args) {
        SpringApplication.run(Example2Application.class, args);
    }
    @Bean
    CommandLineRunner init(IStorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
