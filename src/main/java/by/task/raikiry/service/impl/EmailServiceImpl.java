package by.task.raikiry.service.impl;

import by.task.raikiry.entity.Email;
import by.task.raikiry.repository.EmailRepository;
import by.task.raikiry.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    private final EmailRepository emailRepository;

    @Autowired
    public EmailServiceImpl(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public Email save(Email email) {
        emailRepository.save(email);
        return email;
    }

    @Override
    public Email update(Email email) {
        emailRepository.save(email);
        return null;
    }

    @Override
    public void delete(Long id) {
        emailRepository.delete(id);
    }

    @Override
    public Email getById(Long id) {
        return emailRepository.findOne(id);
    }

    @Override
    public List<Email> getAll() {
        return (List<Email>) emailRepository.findAll();
    }
}
