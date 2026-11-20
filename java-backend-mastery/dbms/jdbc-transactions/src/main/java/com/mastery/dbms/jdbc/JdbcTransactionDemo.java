package com.mastery.dbms.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTransactionDemo {

    public void transfer(Connection conn, int fromId, int toId, double amount) throws SQLException {
        boolean previousAutoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try (PreparedStatement debit = conn.prepareStatement(
                     "UPDATE accounts SET balance = balance - ? WHERE id = ? AND balance >= ?");
             PreparedStatement credit = conn.prepareStatement(
                     "UPDATE accounts SET balance = balance + ? WHERE id = ?")) {

            debit.setDouble(1, amount);
            debit.setInt(2, fromId);
            debit.setDouble(3, amount);
            if (debit.executeUpdate() != 1) {
                throw new SQLException("Insufficient funds");
            }

            credit.setDouble(1, amount);
            credit.setInt(2, toId);
            if (credit.executeUpdate() != 1) {
                throw new SQLException("Target account missing");
            }
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            conn.setAutoCommit(previousAutoCommit);
        }
    }
}
