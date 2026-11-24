package com.corejava.streams;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class StreamsDemoTest {

    @Test
    void shouldGroupAndSumAmountsByCategory() {
        var txns = List.of(
                new StreamsDemo.Transaction("CLOUD", 100.0),
                new StreamsDemo.Transaction("CLOUD", 50.0),
                new StreamsDemo.Transaction("DB", 75.0)
        );
        var result = StreamsDemo.sumByCategory(txns);
        assertEquals(150.0, result.get("CLOUD"));
        assertEquals(75.0, result.get("DB"));
    }
}
