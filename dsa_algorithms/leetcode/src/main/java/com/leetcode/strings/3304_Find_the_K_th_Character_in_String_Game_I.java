package com.leetcode.strings;

class Solution3304 {
    public char kthCharacter(int k) {
        List<Integer> word = new ArrayList<>();
        word.add(0);
        while (word.size() < k) {
            for (int i = 0, m = word.size(); i < m; ++i) {
                word.add((word.get(i) + 1) % 26);
            }
        }
        return (char) ('a' + word.get(k - 1));
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3304 _tcSol = new Solution3304();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "k = 5");
        try {
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthCharacter(k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"b\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "k = 10");
        try {
            int k = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthCharacter(k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"c\"");
        System.out.println();
    }
}
