package com.leetcode.arrays_hashing_greedy;

class Solution2810 {
    public String finalString(String s) {
        StringBuilder t = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == 'i') {
                t.reverse();
            } else {
                t.append(c);
            }
        }
        return t.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2810 _tcSol = new Solution2810();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"string\"");
        try {
            String s = "string";
            System.out.println("  Output  : " + _tcShow(_tcSol.finalString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"rtsng\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"poiinter\"");
        try {
            String s = "poiinter";
            System.out.println("  Output  : " + _tcShow(_tcSol.finalString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"ponter\"");
        System.out.println();
    }
}