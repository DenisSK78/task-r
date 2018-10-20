package by.task.raikiry.repository;

import by.task.raikiry.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query(value = "select * from person p join phone ph on p.id = ph.person_id where ph.id = ?1", nativeQuery = true)
    Person personWherePhoneId(Long phoneId);

    @Query(value = "select * from person p join email e on p.id = e.person_id where e.id = ?1", nativeQuery = true)
    Person personWhereEmailId(Long phoneId);

}
