package com.learning.dbms.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HikariPoolDemo {
    public static void main(String[] args) throws Exception {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:h2:mem:pooldb;DB_CLOSE_DELAY=-1");
        config.setMaximumPoolSize(5);

        try (HikariDataSource ds = new HikariDataSource(config);
             Connection conn = ds.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE users(id INT PRIMARY KEY, name VARCHAR(50))");
            stmt.execute("INSERT INTO users VALUES (1, 'Alice')");
            ResultSet rs = stmt.executeQuery("SELECT name FROM users WHERE id = 1");
            if (rs.next()) {
                System.out.println("Fetched from HikariCP pool: " + rs.getString("name"));
            }
        }
    }
}
