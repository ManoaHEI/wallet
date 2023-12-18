package com.hei.wallet.services;

import java.sql.SQLException;
import java.util.List;

public interface CrudOperation<T> {
        List<T> findAll() throws SQLException;
        T findById(int id);
        List<T> saveAll(List<T> toSave);
        T save(T toSave);
        boolean update(T toUpdate);
}

