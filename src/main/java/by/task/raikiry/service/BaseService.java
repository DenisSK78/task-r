package by.task.raikiry.service;

import java.util.List;

interface BaseService <E>{
    Boolean update(E entity);
    void save(E entity);
    void delete(E entity);
    E getById(Long id);
    List<E> getAll();
}
