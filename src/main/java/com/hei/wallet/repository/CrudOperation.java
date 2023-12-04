package com.hei.wallet.repository;

import java.util.List;

public interface CrudOperation<T> {

    List<T> findAll();

    List<T> findById(int id);

    List<T> saveAll(List<T> toSave);

    T save(T toSave);

    T update(int id, T toUpdate);

    T deleteById(int id);

}