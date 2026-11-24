package com.corejava.jvmio;

import java.nio.file.Path;

public class JvmMemoryIoDemo {

    public static String normalizePath(String base, String child) {
        return Path.of(base, child).normalize().toString();
    }

    public static long maxHeapMb() {
        return Runtime.getRuntime().maxMemory() / (1024 * 1024);
    }

    public static void main(String[] args) {
        System.out.println("Max Heap (MB): " + maxHeapMb());
        System.out.println("Normalized Path: " + normalizePath("docs", "01-jvm-memory-areas.md"));
    }
}
