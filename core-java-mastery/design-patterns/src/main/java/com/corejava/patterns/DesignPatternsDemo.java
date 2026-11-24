package com.corejava.patterns;

import java.util.Map;
import java.util.function.DoubleUnaryOperator;

public class DesignPatternsDemo {

    private static final Map<String, DoubleUnaryOperator> STRATEGIES = Map.of(
            "STANDARD", amount -> amount,
            "DISCOUNT_10", amount -> amount * 0.90,
            "VIP_25", amount -> amount * 0.75
    );

    public static double calculatePrice(String tier, double basePrice) {
        return STRATEGIES.getOrDefault(tier, amount -> amount).applyAsDouble(basePrice);
    }

    public static void main(String[] args) {
        System.out.println("VIP price: " + calculatePrice("VIP_25", 200.0));
    }
}
