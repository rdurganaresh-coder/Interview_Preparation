package com.ms.payment;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @GetMapping
    public List<Map<String, Object>> getPayments() {
        return List.of(
            Map.of("paymentId", "PAY-501", "orderId", "ORD-101", "status", "CAPTURED")
        );
    }
}
