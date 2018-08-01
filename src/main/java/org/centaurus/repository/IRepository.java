package org.centaurus.repository;

import javax.persistence.SecondaryTable;
import java.util.Collection;
import java.util.List;

public interface IRepository<T , U> {

    T save(T obj);
    T findById(U id);
    Collection<T> getAll();
    void delete(U id);
    T update(T t);
}
