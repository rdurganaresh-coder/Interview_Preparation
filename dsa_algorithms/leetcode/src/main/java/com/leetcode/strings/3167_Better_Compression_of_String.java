package com.leetcode.strings;

class Solution3167 {
    public String betterCompression(String compressed) {
        Map<Character, Integer> cnt = new TreeMap<>();
        int i = 0;
        int n = compressed.length();
        while (i < n) {
            char c = compressed.charAt(i);
            int j = i + 1;
            int x = 0;
            while (j < n && Character.isDigit(compressed.charAt(j))) {
                x = x * 10 + (compressed.charAt(j) - '0');
                j++;
            }
            cnt.merge(c, x, Integer::sum);
            i = j;
        }
        StringBuilder ans = new StringBuilder();
        for (var e : cnt.entrySet()) {
            ans.append(e.getKey()).append(e.getValue());
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3167 _tcSol = new Solution3167();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "compressed = \"a3c9b2c1\"");
        try {
            String compressed = "a3c9b2c1";
            System.out.println("  Output  : " + _tcShow(_tcSol.betterCompression(compressed)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"a3b2c10\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "compressed = \"c2b3a1\"");
        try {
            String compressed = "c2b3a1";
            System.out.println("  Output  : " + _tcShow(_tcSol.betterCompression(compressed)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"a1b3c2\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "compressed = \"a2b4c1\"");
        try {
            String compressed = "a2b4c1";
            System.out.println("  Output  : " + _tcShow(_tcSol.betterCompression(compressed)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"a2b4c1\"");
        System.out.println();
    }
}