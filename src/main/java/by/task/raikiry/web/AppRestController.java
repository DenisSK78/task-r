package by.task.raikiry.web;

import by.task.raikiry.entity.Person;
import by.task.raikiry.service.PersonService;
import by.task.raikiry.service.impl.util.CustomServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppRestController {

    private Logger logger = LoggerFactory.getLogger(AppRestController.class);

    private PersonService personService;

    @Autowired
    public AppRestController(PersonService personService) {
        this.personService = personService;
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
        try {
            return personService.update(person);
        } catch (CustomServiceException e) {
            logger.error("Exception update person: ");
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("/phone/delete/{id}")
    public Person deletePhoneById(@PathVariable("id") Long id){
        return personService.delPhoneByIdAndGetPersonByPhoneId(id);
    }

    @DeleteMapping("/email/delete/{id}")
    public Person deleteEmailById(@PathVariable("id") Long id){
        return personService.delEmailByIdAndGetPersonByEmailId(id);
    }

    @PostMapping("/person/save")
    public Person savePerson(@RequestBody Person person){
        return personService.save(person);
    }

    @DeleteMapping("/person/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        personService.delete(id);
    }
}

