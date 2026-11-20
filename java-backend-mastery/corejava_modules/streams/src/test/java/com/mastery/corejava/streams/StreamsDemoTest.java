package com.mastery.corejava.streams;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class StreamsDemoTest {

    @Test
    void groupsAndAverages() {
        var data = List.of(
                new StreamsDemo.Employee("Asha", "Engineering", 120000),
                new StreamsDemo.Employee("Ravi", "Engineering", 140000));
        double avg = new StreamsDemo().averageSalaryByDept(data).get("Engineering");
        assertEquals(130000.0, avg);
    }
}
