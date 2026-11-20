package com.mastery.linux.process;

public class SystemdUnitGenerator {

    public String generateServiceUnit(String serviceName, String jarPath) {
        return String.join(System.lineSeparator(),
                "[Unit]",
                "Description=" + serviceName,
                "After=network.target",
                "",
                "[Service]",
                "ExecStart=/usr/bin/java -jar " + jarPath,
                "Restart=always");
    }
}
