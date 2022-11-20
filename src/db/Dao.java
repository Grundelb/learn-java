package db;

import oop.lesson3.hw.Cat;

import java.util.Date;
import java.util.List;

public interface Dao<T> {
    T get(int id);

    List<T> get(String name);

    T get(Date date1, Date date2);

    List<T> getAll();

    boolean add(T object);

    boolean update(T object);

    boolean delete(T object);

}
