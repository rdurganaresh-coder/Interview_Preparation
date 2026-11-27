package com.leetcode.bit_manipulation_math;

class Solution0422 {
    public boolean validWordSquare(List<String> words) {
        int m = words.size();
        for (int i = 0; i < m; ++i) {
            int n = words.get(i).length();
            for (int j = 0; j < n; ++j) {
                if (j >= m || i >= words.get(j).length()) {
                    return false;
                }
                if (words.get(i).charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution0422 _tcSol = new Solution0422();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"abcd\",\"bnrt\",\"crmy\",\"dtye\"]");
        try {
            List<String> words = _tcL("abcd", "bnrt", "crmy", "dtye");
            System.out.println("  Output  : " + _tcShow(_tcSol.validWordSquare(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"abcd\",\"bnrt\",\"crm\",\"dt\"]");
        try {
            List<String> words = _tcL("abcd", "bnrt", "crm", "dt");
            System.out.println("  Output  : " + _tcShow(_tcSol.validWordSquare(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "words = [\"ball\",\"area\",\"read\",\"lady\"]");
        try {
            List<String> words = _tcL("ball", "area", "read", "lady");
            System.out.println("  Output  : " + _tcShow(_tcSol.validWordSquare(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}