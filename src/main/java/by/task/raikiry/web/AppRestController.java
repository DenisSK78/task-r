package by.task.raikiry.web;

import by.task.raikiry.entity.Email;
import by.task.raikiry.entity.Person;
import by.task.raikiry.entity.Phone;
import by.task.raikiry.service.EmailService;
import by.task.raikiry.service.PersonService;
import by.task.raikiry.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppRestController {

    private PersonService personService;
    private final PhoneService phoneService;
    private final EmailService emailService;

    @Autowired
    public AppRestController(PersonService personService,
                             PhoneService phoneService,
                             EmailService emailService) {
        this.personService = personService;
        this.phoneService = phoneService;
        this.emailService = emailService;
    }

    @GetMapping("/person/{personId}")
    public Person getPersonById(@PathVariable("personId") Long personId) {
        return personService.getById(personId);
    }

    @GetMapping("/")
    public List<Person> getAllPerson() {
        return personService.getAll();
    }

    @PutMapping("/person/update")
    public Person updatePersonById(@RequestBody Person person){
        return personService.update(person);
    }

    @DeleteMapping("/phone/delete/{phoneId}")
    public Person deletePhoneById(@PathVariable("phoneId") Long phoneId){


        Phone phone = phoneService.getById(phoneId);
        Long personId = phone.getPerson().getId();
        phoneService.delete(phone.getId());

        System.out.println("--------------------------" + phoneId);

        Person person = personService.getById(personId);

        return person;
    }


    @DeleteMapping("/email/delete/{emailId}")
    public Email deleteEmailById(@RequestBody Email email){
        System.out.println("----------" + email);
        return email;
    }
}

