package com.mastery.corejava.concurrency;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class VirtualThreadsDemoTest {

    @Test
    void runsOnVirtualThreads() throws Exception {
        var demo = new VirtualThreadsDemo();
        assertEquals(List.of("Processed:A", "Processed:B"),
                demo.runTasksConcurrently(List.of("a", "b")));
    }
}
