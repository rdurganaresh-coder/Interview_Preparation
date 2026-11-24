package com.corejava.jvmio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JvmMemoryIoDemoTest {

    @Test
    void shouldReportPositiveHeapMemory() {
        assertTrue(JvmMemoryIoDemo.maxHeapMb() > 0);
    }
}
