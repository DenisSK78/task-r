package by.task.raikiry.service;

import java.util.List;

interface BaseService <E>{
    void save(E entity);
    void update(E entity);
    void delete(E entity);
    E getById(Long id);
    List<E> getAll();
}
