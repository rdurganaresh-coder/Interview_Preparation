package com.mastery.batch.chunk;

import org.springframework.batch.item.ItemProcessor;

public class StatementItemProcessor implements ItemProcessor<String, String> {

    @Override
    public String process(String item) {
        if (item == null || item.isBlank()) {
            return null; // returning null filters the item out of the chunk
        }
        return item.trim().toUpperCase();
    }
}
