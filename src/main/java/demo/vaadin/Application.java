package demo.vaadin;

import demo.vaadin.db.Person;
import demo.vaadin.db.PersonRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ApplicationRunner fillDb(PersonRepository repository) {
        return (args) -> {
            repository.save(new Person("Oleg", "Java 8", "z0123", 92));
            repository.save(new Person("Oleg", "Java 7", "z0123", 83));
        };
    }
}
