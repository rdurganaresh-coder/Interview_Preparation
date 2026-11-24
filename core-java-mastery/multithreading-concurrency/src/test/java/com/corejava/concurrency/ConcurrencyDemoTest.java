package com.corejava.concurrency;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConcurrencyDemoTest {

    @Test
    void shouldIncrementAtomicallyAcrossAsyncTasks() {
        assertEquals(250, ConcurrencyDemo.runAtomicIncrements(250));
    }
}
