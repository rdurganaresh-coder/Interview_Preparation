package com.leetcode.arrays_hashing_greedy;

class Solution0830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        int n = s.length();
        int i = 0;
        List<List<Integer>> ans = new ArrayList<>();
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                ++j;
            }
            if (j - i >= 3) {
                ans.add(List.of(i, j - 1));
            }
            i = j;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0830 _tcSol = new Solution0830();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abbxxxxzzy\"");
        try {
            String s = "abbxxxxzzy";
            System.out.println("  Output  : " + _tcShow(_tcSol.largeGroupPositions(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[3,6]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abc\"");
        try {
            String s = "abc";
            System.out.println("  Output  : " + _tcShow(_tcSol.largeGroupPositions(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"abcdddeeeeaabbbcd\"");
        try {
            String s = "abcdddeeeeaabbbcd";
            System.out.println("  Output  : " + _tcShow(_tcSol.largeGroupPositions(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[3,5],[6,9],[12,14]]");
        System.out.println();
    }
}
