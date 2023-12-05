package com.hei.wallet.services;

import com.hei.wallet.database.DbConnection;
import com.hei.wallet.models.Currency;
import com.hei.wallet.repository.CurrencyRepository;
import com.hei.wallet.repository.CrudOperation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CurrencyService implements CrudOperation<Currency>, CurrencyRepository {

    private Currency mapCurrency(ResultSet resultSet) throws SQLException {
        return new Currency(
                resultSet.getInt("id_currency"),
                resultSet.getString("name"),
                resultSet.getFloat("value")
        );
    }

    @Override
    public List<Currency> findAll() {
        List<Currency> currencies = new ArrayList<>();

        try {
            Connection connection = DbConnection.getConnection();
            String sql = "SELECT * FROM currency;";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                currencies.add(mapCurrency(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("ERROR");
        }

        return currencies;
    }

    @Override
    public List<Currency> findById(int id) {
        List<Currency> currencies = new ArrayList<>();

        try {
            Connection connection = DbConnection.getConnection();
            String sql = "SELECT * FROM currency WHERE id_currency = " + id + ";";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                currencies.add(mapCurrency(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("ERROR");
        }

        return currencies;
    }

    @Override
    public List<Currency> saveAll(List<Currency> toSave) {
        return null;
    }
    @Override
    public Currency save(Currency toSave) {
        return null;
    }
    @Override
    public Currency update(int id, Currency toUpdate) {
        return null;
    }
    @Override
    public String deleteById(int id) {
        return null;
    }

    @Override
    public Currency findCurrencyByName(String name) {
        return null;
    }
    @Override
    public Currency deleteCurrencyByName(String name) {
        return null;
    }
}
