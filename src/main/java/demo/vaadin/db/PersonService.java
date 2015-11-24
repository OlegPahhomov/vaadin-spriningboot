package demo.vaadin.db;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonService {
    @Autowired
    PersonRepository personRepo;

    public List<Person> findAll(String filter) {
        if (StringUtils.isEmpty(filter)) personRepo.findPeopleByOrderByScoreDesc();
        return personRepo.findAllByNameLike(filter.toLowerCase());
    }

    public void delete(Person person) {
        personRepo.delete(person);
    }

    public void save(Person person) {
        personRepo.save(person);
    }
}
