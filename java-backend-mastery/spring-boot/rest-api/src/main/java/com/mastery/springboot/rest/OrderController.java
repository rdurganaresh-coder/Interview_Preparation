package com.mastery.springboot.rest;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    public record OrderDto(String id, String item, double amount) {}

    @GetMapping
    public ResponseEntity<List<OrderDto>> getOrders() {
        return ResponseEntity.ok(List.of(new OrderDto("ORD-101", "Mechanical Keyboard", 4500.0)));
    }
}
