package com.mastery.linux.shell;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class LogLineParserTest {

    @Test
    void keepsOnlyErrorLines() {
        var logs = List.of("INFO Started", "ERROR DB timeout", "WARN High CPU");
        assertEquals(List.of("ERROR DB timeout"), new LogLineParser().filterErrors(logs));
    }
}
