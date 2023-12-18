package com.hei.wallet.DAO;

import com.hei.wallet.database.DbConnection;
import com.hei.wallet.models.TransactionCategory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionCategoryDAO {

    private final Connection connection;

    public TransactionCategoryDAO() {
        this.connection = DbConnection.getConnection();
    }

    public List<TransactionCategory> getAllCategories() throws SQLException {
        List<TransactionCategory> categories = new ArrayList<>();
        String sql = "SELECT * FROM transaction_category";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                TransactionCategory category = new TransactionCategory();
                category.setId(resultSet.getLong("id"));
                category.setName(resultSet.getString("name"));
                categories.add(category);
            }
        }

        return categories;
    }

}

