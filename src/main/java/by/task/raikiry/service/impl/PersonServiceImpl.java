package by.task.raikiry.service.impl;

import by.task.raikiry.entity.Person;
import by.task.raikiry.repository.PersonRepository;
import by.task.raikiry.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public void update(Person person) {
        personRepository.save(person);
    }

    @Override
    public void delete(Person person) {
        personRepository.delete(person);
    }

    @Override
    public Person getById(Long id) {
        return personRepository.findOne(id);
    }

    @Override
    public List<Person> getAll() {
        return (List<Person>) personRepository.findAll();
    }
}
