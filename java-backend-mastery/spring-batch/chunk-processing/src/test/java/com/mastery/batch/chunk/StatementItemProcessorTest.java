package com.mastery.batch.chunk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class StatementItemProcessorTest {

    @Test
    void normalisesAndFilters() {
        var processor = new StatementItemProcessor();
        assertEquals("TXN-900", processor.process("  txn-900 "));
        assertNull(processor.process("   "));
    }
}
