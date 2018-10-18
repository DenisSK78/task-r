package by.task.raikiry.service.impl;

import by.task.raikiry.entity.Phone;
import by.task.raikiry.repository.PhoneRepository;
import by.task.raikiry.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {

    private PhoneRepository phoneRepository;

    @Autowired
    public PhoneServiceImpl(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    public void save(Phone phone) {
        phoneRepository.save(phone);
    }

    @Override
    public Boolean update(Phone phone) {
        phoneRepository.save(phone);
        return null;
    }

    @Override
    public void delete(Phone phone) {
        phoneRepository.delete(phone);
    }

    @Override
    public Phone getById(Long id) {
        return phoneRepository.findOne(id);
    }

    @Override
    public List<Phone> getAll() {
        return (List<Phone>) phoneRepository.findAll();
    }
}
