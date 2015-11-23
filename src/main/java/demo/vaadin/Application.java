package demo.vaadin;

import demo.vaadin.db.Person;
import demo.vaadin.db.PersonRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ApplicationRunner fillDb(PersonRepository repository) {
        return (beforeRun) -> {
            repository.save(new Person("Oleg Pahhomov", "Java SE 7 Programmer II", "1Z0-804", "83"));
            repository.save(new Person("Joonas Mathias", "Java SE 7 Programmer II", "1Z0-804", "67"));
            repository.save(new Person("Oleg Pahhomov", "Java SE 8 Programmer I", "1Z0-808", "92"));
            repository.save(new Person("Pablo Veritas", "Java SE 7 Programmer I", "1Z0-803", "81"));
            repository.save(new Person("Joonas Mathias", "Java SE 7 Programmer I", "1Z0-803", "96"));
            repository.save(new Person("Joonas Mathias", "Java SE 7 Programmer I", "1Z0-803", "96"));
            repository.save(new Person("Joonas Mathias", "Java SE 7 Programmer I", "1Z0-803", "96"));
            repository.save(new Person("Joonas Mathias", "Java SE 7 Programmer I", "1Z0-803", "96"));
            repository.save(new Person("Joonas Mathias", "Java SE 7 Programmer I", "1Z0-803", "96"));
            repository.save(new Person("Joonas Mathias", "Java SE 7 Programmer I", "1Z0-803", "96"));
            repository.save(new Person("Joonas Mathias", "Java SE 7 Programmer I", "1Z0-803", "96"));
            repository.save(new Person("Joonas Mathias", "Java SE 7 Programmer I", "1Z0-803", "96"));
            repository.save(new Person("Joonas Mathias", "Java SE 7 Programmer I", "1Z0-803", "96"));
            repository.save(new Person("Joonas Mathias", "Java SE 7 Programmer I", "1Z0-803", "96"));
            repository.save(new Person("Joonas Mathias", "Java SE 7 Programmer I", "1Z0-803", "96"));
            repository.save(new Person("Joonas Mathias", "Java SE 7 Programmer I", "1Z0-803", "96"));
            repository.save(new Person("Joonas Mathias", "Java SE 7 Programmer I", "1Z0-803", "96"));
            repository.save(new Person("Joonas Mathias", "Java SE 7 Programmer I", "1Z0-803", "96"));
            repository.save(new Person("Joonas Mathias", "Java SE 7 Programmer I", "1Z0-803", "96"));
            repository.save(new Person("Joonas Mathias", "Java SE 7 Programmer I", "1Z0-803", "96"));
            repository.save(new Person("Joonas Mathias", "Java SE 7 Programmer I", "1Z0-803", "96"));
            repository.save(new Person("Joonas Mathias", "Java SE 7 Programmer I", "1Z0-803", "96"));
            repository.save(new Person("Joonas Mathias", "Java SE 7 Programmer I", "1Z0-803", "96"));
            repository.save(new Person("Joonas Mathias", "Java SE 7 Programmer I", "1Z0-803", "96"));
            repository.save(new Person("Joonas Mathias", "Java SE 7 Programmer I", "1Z0-803", "96"));
            repository.save(new Person("Joonas Mathias", "Java SE 7 Programmer I", "1Z0-803", "96"));
        };
    }
}
