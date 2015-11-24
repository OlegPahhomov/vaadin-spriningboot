package demo.vaadin.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findPeopleByOrderByScoreDesc();

    @Query("SELECT p FROM Person p WHERE lower(p.fullName) LIKE %:searchTerm% order by p.score desc ")
    List<Person> findAllByNameLike(@Param("searchTerm") String searchTerm);

}
