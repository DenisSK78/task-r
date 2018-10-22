package by.task.raikiry.service;

import by.task.raikiry.service.impl.util.CustomServiceException;

import java.util.List;

interface BaseService <E>{
    E update(E entity) throws CustomServiceException;
    E save(E entity);
    void delete(Long id);
    E getById(Long id);
    List<E> getAll();
}
