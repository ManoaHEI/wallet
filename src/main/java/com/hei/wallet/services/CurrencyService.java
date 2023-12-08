package com.hei.wallet.services;

import com.hei.wallet.database.DbConnection;
import com.hei.wallet.models.entities.Currency;
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
                resultSet.getBigDecimal("value")
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
    public String deleteById(int id) {

        String sql = "IF EXISTS (SELECT * FROM currency WHERE id_currency = " + id + ") DELETE FROM currency WHERE id_currency = " + id + ";";

        try {
            Connection connection = DbConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Currency with id: " + id + " has been deleted successfully.";
    }

    @Override
    public Currency findCurrencyByName(String name) {
        Currency currency = null;

        try {
            Connection connection = DbConnection.getConnection();
            String sql = "SELECT * FROM currency WHERE name = '" + name + "';";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                currency = mapCurrency(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return currency;
    }

    @Override
    public Currency deleteCurrencyByName(String name) {
        Currency currency = findCurrencyByName(name);

        if (currency != null) {
            String sql = "DELETE FROM currency WHERE name = '" + name + "';";

            try {
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement();
                statement.executeUpdate(sql);

                System.out.println("Currency with name: " + name + " has been deleted successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return currency;
    }
}
