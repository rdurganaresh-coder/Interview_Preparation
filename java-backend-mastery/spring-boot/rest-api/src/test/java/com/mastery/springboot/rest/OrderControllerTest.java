package com.mastery.springboot.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class OrderControllerTest {

    @Test
    void returnsOrders() {
        var response = new OrderController().getOrders();
        assertEquals(200, response.getStatusCode().value());
        assertEquals(1, response.getBody().size());
    }
}
