package com.corejava.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsDemo {

    public record Transaction(String category, double amount) {}

    public static Map<String, Double> sumByCategory(List<Transaction> transactions) {
        return transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::category,
                        Collectors.summingDouble(Transaction::amount)
                ));
    }

    public static void main(String[] args) {
        var txns = List.of(
                new Transaction("FOOD", 25.0),
                new Transaction("BOOKS", 40.0),
                new Transaction("FOOD", 15.0)
        );
        System.out.println(sumByCategory(txns));
    }
}
