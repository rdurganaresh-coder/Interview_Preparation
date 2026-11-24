package com.corejava.basics;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JavaBasicsDemoTest {

    @Test
    void shouldDescribeActiveAccount() {
        var status = new JavaBasicsDemo.ActiveAccount("Bob", 150.50);
        assertEquals("Active: Bob ($150.5)", JavaBasicsDemo.describeStatus(status));
    }
}
