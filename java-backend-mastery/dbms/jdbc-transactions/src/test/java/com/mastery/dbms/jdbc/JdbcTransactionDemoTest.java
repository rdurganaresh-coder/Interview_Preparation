package com.mastery.dbms.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;

class JdbcTransactionDemoTest {

    @Test
    void rollsBackOnInsufficientFunds() throws Exception {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:txtest");
             var st = conn.createStatement()) {
            st.execute("CREATE TABLE accounts (id INT PRIMARY KEY, balance DOUBLE)");
            st.execute("INSERT INTO accounts VALUES (1, 100.0), (2, 50.0)");

            assertThrows(SQLException.class,
                    () -> new JdbcTransactionDemo().transfer(conn, 1, 2, 200.0));

            try (var rs = st.executeQuery("SELECT balance FROM accounts WHERE id = 1")) {
                rs.next();
                assertEquals(100.0, rs.getDouble(1));
            }
        }
    }
}
