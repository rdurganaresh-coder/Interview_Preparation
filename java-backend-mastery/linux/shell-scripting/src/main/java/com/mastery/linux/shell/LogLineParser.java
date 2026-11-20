package com.mastery.linux.shell;

import java.util.List;

public class LogLineParser {

    public List<String> filterErrors(List<String> logLines) {
        return logLines.stream()
                .filter(line -> line.contains("ERROR") || line.contains("FATAL"))
                .toList();
    }
}
