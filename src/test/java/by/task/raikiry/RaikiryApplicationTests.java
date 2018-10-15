package by.task.raikiry;

import by.task.raikiry.entity.Person;
import by.task.raikiry.service.EmailService;
import by.task.raikiry.service.PersonService;
import by.task.raikiry.service.PhoneService;
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

    @Test
    public void getAllPersons() {
        List<Person> people = personService.getAll();
        people.forEach(p->logger.info(p.toString()));
        Assert.assertTrue(people.size() >= 5);
    }

//    @Test
//    public void saveNewPerson(){
//        Person person = new Person("Test", "Test address", "Test comment", EMPTY_SET, EMPTY_SET);
//        personService.save(person);
//    }

    @Test
    public void updatePerson(){
        List<Person> people = personService.getAll();
        Person person = people
                .stream()
                .filter(p->p.getName().equals("Test"))
                .collect(Collectors.toList()).get(0);
        person.setComment("New commit");
        personService.update(person);
    }

}
