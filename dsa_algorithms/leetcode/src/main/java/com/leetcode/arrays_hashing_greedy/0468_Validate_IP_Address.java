package com.leetcode.arrays_hashing_greedy;

class Solution0468 {
    public String validIPAddress(String queryIP) {
        if (isIPv4(queryIP)) {
            return "IPv4";
        }
        if (isIPv6(queryIP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isIPv4(String s) {
        if (s.endsWith(".")) {
            return false;
        }
        String[] ss = s.split("\\.");
        if (ss.length != 4) {
            return false;
        }
        for (String t : ss) {
            if (t.length() == 0 || t.length() > 1 && t.charAt(0) == '0') {
                return false;
            }
            int x = convert(t);
            if (x < 0 || x > 255) {
                return false;
            }
        }
        return true;
    }

    private boolean isIPv6(String s) {
        if (s.endsWith(":")) {
            return false;
        }
        String[] ss = s.split(":");
        if (ss.length != 8) {
            return false;
        }
        for (String t : ss) {
            if (t.length() < 1 || t.length() > 4) {
                return false;
            }
            for (char c : t.toCharArray()) {
                if (!Character.isDigit(c)
                    && !"0123456789abcdefABCDEF".contains(String.valueOf(c))) {
                    return false;
                }
            }
        }
        return true;
    }

    private int convert(String s) {
        int x = 0;
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return -1;
            }
            x = x * 10 + (c - '0');
            if (x > 255) {
                return x;
            }
        }
        return x;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0468 _tcSol = new Solution0468();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "queryIP = \"172.16.254.1\"");
        try {
            String queryIP = "172.16.254.1";
            System.out.println("  Output  : " + _tcShow(_tcSol.validIPAddress(queryIP)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"IPv4\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "queryIP = \"2001:0db8:85a3:0:0:8A2E:0370:7334\"");
        try {
            String queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334";
            System.out.println("  Output  : " + _tcShow(_tcSol.validIPAddress(queryIP)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"IPv6\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "queryIP = \"256.256.256.256\"");
        try {
            String queryIP = "256.256.256.256";
            System.out.println("  Output  : " + _tcShow(_tcSol.validIPAddress(queryIP)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Neither\"");
        System.out.println();
    }
}