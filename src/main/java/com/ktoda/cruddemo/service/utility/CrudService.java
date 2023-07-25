package com.ktoda.cruddemo.service.utility;

public interface CrudService<T> {
    T save(T entity);

    Iterable<T> findAll();

    T findById(Integer id);

    void deleteById(Integer id);
}
