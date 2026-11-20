package com.mastery.dbms.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlQueryRunner {

    private static final String TOP_EARNERS =
            "SELECT name FROM ("
            + " SELECT name, RANK() OVER (PARTITION BY dept ORDER BY salary DESC) AS rnk"
            + " FROM employees"
            + ") ranked WHERE rnk = 1 ORDER BY name";

    public List<String> getTopEarnersPerDept(Connection conn) throws SQLException {
        List<String> names = new ArrayList<>();
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(TOP_EARNERS)) {
            while (rs.next()) {
                names.add(rs.getString("name"));
            }
        }
        return names;
    }
}
