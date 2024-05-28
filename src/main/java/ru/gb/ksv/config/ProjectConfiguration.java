package ru.gb.ksv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.gb.ksv.aspect.TrackUserAspect;

@Configuration
@ComponentScan(basePackages = "ru.gb.ksv")
@EnableAspectJAutoProxy
public class ProjectConfiguration {

    @Bean
    public TrackUserAspect aspect()
    {
        return new TrackUserAspect();
    }
}
