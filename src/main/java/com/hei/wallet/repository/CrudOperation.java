package com.hei.wallet.repository;

import java.util.List;

public interface CrudOperation<T> {

    List<T> findAll();

    List<T> findById(int id);

    List<T> saveAll(List<T> toSave);

    T save(T toSave);

    String deleteById(int id);

}