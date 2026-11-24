package com.jee.jsp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TopicTest {
    @Test
    void recordStoresFields() {
        Topic t = new Topic(1, "JSP MVC", "Web");
        assertEquals("JSP MVC", t.title());
    }
}
