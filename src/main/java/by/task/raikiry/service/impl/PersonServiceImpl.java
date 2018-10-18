package by.task.raikiry.service.impl;

import by.task.raikiry.entity.Person;
import by.task.raikiry.repository.EmailRepository;
import by.task.raikiry.repository.PersonRepository;
import by.task.raikiry.repository.PhoneRepository;
import by.task.raikiry.service.PersonService;
import by.task.raikiry.service.impl.util.FromUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    private PersonRepository personRepository;
    private PhoneRepository phoneRepository;
    private EmailRepository emailRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository,
                             PhoneRepository phoneRepository,
                             EmailRepository emailRepository) {
        this.personRepository = personRepository;
        this.phoneRepository = phoneRepository;
        this.emailRepository = emailRepository;
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    @Transactional
    public Boolean update(Person upPerson) {
        Person dbPerson = personRepository.findOne(upPerson.getId());
            if (!dbPerson.equals(upPerson)) {
                FromUpdate.updateFieldPerson(dbPerson, upPerson);
            }
            if (!dbPerson.getPhones().equals(upPerson.getPhones())) {
                FromUpdate.updateSetPhones(dbPerson.getPhones(), upPerson.getPhones());
            }
            if (!dbPerson.getEmails().equals(upPerson.getEmails())) {
                FromUpdate.updateSetEmails(dbPerson.getEmails(), upPerson.getEmails());
            }
            personRepository.save(dbPerson);
            return true;
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
