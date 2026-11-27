package com.leetcode.arrays_hashing_greedy;

class Solution0914 {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : deck) {
            cnt.merge(x, 1, Integer::sum);
        }
        int g = cnt.get(deck[0]);
        for (int x : cnt.values()) {
            g = gcd(g, x);
        }
        return g >= 2;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0914 _tcSol = new Solution0914();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "deck = [1,2,3,4,4,3,2,1]");
        try {
            int[] deck = new int[]{1, 2, 3, 4, 4, 3, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.hasGroupsSizeX(deck)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "deck = [1,1,1,2,2,2,3,3]");
        try {
            int[] deck = new int[]{1, 1, 1, 2, 2, 2, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.hasGroupsSizeX(deck)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}