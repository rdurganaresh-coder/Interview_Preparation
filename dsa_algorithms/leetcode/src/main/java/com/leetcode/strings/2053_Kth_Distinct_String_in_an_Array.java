package com.leetcode.strings;

class Solution2053 {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String s : arr) {
            cnt.merge(s, 1, Integer::sum);
        }
        for (String s : arr) {
            if (cnt.get(s) == 1 && --k == 0) {
                return s;
            }
        }
        return "";
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2053 _tcSol = new Solution2053();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [\"d\",\"b\",\"c\",\"b\",\"c\",\"a\"], k = 2");
        try {
            String[] arr = new String[]{"d", "b", "c", "b", "c", "a"};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthDistinct(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"a\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [\"aaa\",\"aa\",\"a\"], k = 1");
        try {
            String[] arr = new String[]{"aaa", "aa", "a"};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthDistinct(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aaa\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [\"a\",\"b\",\"a\"], k = 3");
        try {
            String[] arr = new String[]{"a", "b", "a"};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthDistinct(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();
    }
}
