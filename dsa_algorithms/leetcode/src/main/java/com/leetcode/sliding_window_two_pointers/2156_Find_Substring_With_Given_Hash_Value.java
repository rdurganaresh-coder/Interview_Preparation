package com.leetcode.sliding_window_two_pointers;

class Solution2156 {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        long h = 0, p = 1;
        int n = s.length();
        for (int i = n - 1; i >= n - k; --i) {
            int val = s.charAt(i) - 'a' + 1;
            h = ((h * power % modulo) + val) % modulo;
            if (i != n - k) {
                p = p * power % modulo;
            }
        }
        int j = n - k;
        for (int i = n - k - 1; i >= 0; --i) {
            int pre = s.charAt(i + k) - 'a' + 1;
            int cur = s.charAt(i) - 'a' + 1;
            h = ((h - pre * p % modulo + modulo) * power % modulo + cur) % modulo;
            if (h == hashValue) {
                j = i;
            }
        }
        return s.substring(j, j + k);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2156 _tcSol = new Solution2156();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"leetcode\", power = 7, modulo = 20, k = 2, hashValue = 0");
        try {
            String s = "leetcode";
            int power = 7;
            int modulo = 20;
            int k = 2;
            int hashValue = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.subStrHash(s, power, modulo, k, hashValue)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"ee\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"fbxzaad\", power = 31, modulo = 100, k = 3, hashValue = 32");
        try {
            String s = "fbxzaad";
            int power = 31;
            int modulo = 100;
            int k = 3;
            int hashValue = 32;
            System.out.println("  Output  : " + _tcShow(_tcSol.subStrHash(s, power, modulo, k, hashValue)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"fbx\"");
        System.out.println();
    }
}