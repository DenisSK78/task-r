package by.task.raikiry.service;

import by.task.raikiry.entity.Person;

public interface PersonService extends BaseService<Person>{

    Person delEmailByIdAndGetPersonByEmailId(Long id);
    Person delPhoneByIdAndGetPersonByPhoneId(Long id);

}
