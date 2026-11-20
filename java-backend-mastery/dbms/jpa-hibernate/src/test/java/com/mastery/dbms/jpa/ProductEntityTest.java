package com.mastery.dbms.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class ProductEntityTest {

    @Test
    void storesFields() {
        var p = new ProductEntity("Laptop", new BigDecimal("75000.00"));
        assertEquals("Laptop", p.getName());
        assertEquals(new BigDecimal("75000.00"), p.getPrice());
    }
}
