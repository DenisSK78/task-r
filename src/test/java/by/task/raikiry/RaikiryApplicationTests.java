package by.task.raikiry;

import by.task.raikiry.entity.Person;
import by.task.raikiry.entity.Phone;
import by.task.raikiry.repository.PersonRepository;
import by.task.raikiry.service.EmailService;
import by.task.raikiry.service.PersonService;
import by.task.raikiry.service.PhoneService;
import by.task.raikiry.service.impl.util.CustomServiceException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RaikiryApplicationTests {

    private Logger logger = LoggerFactory.getLogger(RaikiryApplicationTests.class);

    @Autowired
    PhoneService phoneService;

    @Autowired
    PersonService personService;

    @Autowired
    EmailService emailService;

    @Autowired
    PersonRepository personRepository;

    @Test
    public void getAllPersons() {
        List<Person> people = personService.getAll();
        people.forEach(p->logger.info(p.toString()));
        Assert.assertTrue(people.size() >= 5);
    }

    @Test
    public void saveNewPerson(){
        Person person = new Person("Test", "Test address", "Test comment", null, null);
        personService.save(person);
    }

    @Test
    public void updatePerson(){
        List<Person> people = personService.getAll();
        Person person = people
                .stream()
                .filter(p->p.getName().equals("Test"))
                .collect(Collectors.toList()).get(0);
        person.setComment("New commit");
        try {
            personService.update(person);
        } catch (CustomServiceException e) {
            logger.error("Exception update person: ");
            e.printStackTrace();
        }
    }

    @Test
    public void AddAndDeleteByPhoneId(){
        Phone phone = new Phone("777", personService.getById(1L));
        phoneService.save(phone);
        List<Phone> phones = phoneService.getAll();
        phones
                .stream()
                .filter(ph->ph.getPhoneNumber().equals("777"))
                .forEach(ph->phoneService.delete(ph.getId()));
    }

    @Test
    public void getPersonById(){
        Person person = personService.getById(1L);
        System.out.println(person);
    }

    @Test
    public void getPersonByPhoneId(){
        Long phoneId = phoneService.getAll()
                .stream()
                .findFirst()
                .get()
                .getId();
        Person person =  personService
                .delPhoneByIdAndGetPersonByPhoneId(phoneId);
        System.out.println(person);
    }

    @Test
    public void getPersonByEmailId(){
        Long emailId = emailService.getAll()
                .stream()
                .findFirst()
                .get()
                .getId();
        Person person =  personService
                .delEmailByIdAndGetPersonByEmailId(emailId);
        System.out.println(person);
    }
}
