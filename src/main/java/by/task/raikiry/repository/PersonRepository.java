package by.task.raikiry.repository;

import by.task.raikiry.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
