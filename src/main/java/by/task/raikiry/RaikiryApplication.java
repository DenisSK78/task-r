package by.task.raikiry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("by.task.raikiry")
public class RaikiryApplication {
    public static void main(String[] args) {
        SpringApplication.run(RaikiryApplication.class, args);
    }

}
