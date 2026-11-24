package com.ms.order;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @GetMapping
    public List<Map<String, Object>> getOrders() {
        return List.of(
            Map.of("orderId", "ORD-101", "item", "Mechanical Keyboard", "amount", 120.00),
            Map.of("orderId", "ORD-102", "item", "27-inch 4K Monitor", "amount", 340.00)
        );
    }
}
