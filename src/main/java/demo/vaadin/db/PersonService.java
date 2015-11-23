package demo.vaadin.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.vaadin.viritin.SortableLazyList;


@Service
public class PersonService {
    private static final int PAGESIZE = 15;

    @Autowired
    PersonRepository personRepo;

    public SortableLazyList<Person> findAll() {
        return new SortableLazyList<>(
                getSortablePagingProvider(),
                () -> (int) personRepo.count(),
                PAGESIZE
        );
    }

    private SortableLazyList.SortablePagingProvider getSortablePagingProvider() {
        return (firstRow, asc, sortProperty) -> personRepo.findAllBy(
                new PageRequest(
                        firstRow / PAGESIZE,
                        PAGESIZE,
                        asc ? Sort.Direction.ASC : Sort.Direction.DESC,
                        sortProperty == null ? "id" : sortProperty));
    }

    public void delete(Person person) {
        personRepo.delete(person);
    }

    public void save(Person person) {
        personRepo.save(person);
    }

}
