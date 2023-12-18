package com.hei.wallet.DAO;

import com.hei.wallet.database.DbConnection;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@Repository
public class CurrencyDAO {

    private final Connection connection;

    public CurrencyDAO() {
        this.connection = DbConnection.getConnection();
    }

    public List<Currency> getAllCurrencies() {
        List<Currency> currencies = new ArrayList<>();
        try {
            String sql = "SELECT * FROM currency";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                currencies.add(new Currency(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("code")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return currencies;
    }

    public com.hei.wallet.models.Currency findById(Long id) {
        return null;
    }

    public Currency saveAll(List<com.hei.wallet.models.Currency> currencies) {
        return null;
    }

    public com.hei.wallet.models.Currency save(com.hei.wallet.models.Currency currency) {
        return null;
    }

    public boolean update(com.hei.wallet.models.Currency currency) {
        return false;
    }

    public List<com.hei.wallet.models.Currency> findAll() {
        return null;
    }
}

