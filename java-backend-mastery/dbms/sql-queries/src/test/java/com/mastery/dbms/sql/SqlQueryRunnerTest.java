package com.mastery.dbms.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.DriverManager;
import java.util.List;
import org.junit.jupiter.api.Test;

class SqlQueryRunnerTest {

    @Test
    void windowFunctionReturnsTopEarner() throws Exception {
        try (var conn = DriverManager.getConnection("jdbc:h2:mem:sqltest");
             var st = conn.createStatement()) {
            st.execute("CREATE TABLE employees (name VARCHAR(50), dept VARCHAR(50), salary INT)");
            st.execute("INSERT INTO employees VALUES ('Kiran', 'IT', 90000), ('Meera', 'IT', 110000)");
            assertEquals(List.of("Meera"), new SqlQueryRunner().getTopEarnersPerDept(conn));
        }
    }
}
