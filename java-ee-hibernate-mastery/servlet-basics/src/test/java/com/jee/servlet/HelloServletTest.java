package com.jee.servlet;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HelloServletTest {
    @Test
    void servletInstantiatesCleanly() {
        HelloServlet servlet = new HelloServlet();
        assertNotNull(servlet);
    }
}
