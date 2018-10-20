package by.task.raikiry.service;

import java.util.List;

interface BaseService <E>{
    E update(E entity);
    void save(E entity);
    void delete(Long id);
    E getById(Long id);
    List<E> getAll();
}
