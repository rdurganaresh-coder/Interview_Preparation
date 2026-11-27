package com.leetcode.dynamic_programming;

class Solution1218 {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> f = new HashMap<>();
        int ans = 0;
        for (int x : arr) {
            f.put(x, f.getOrDefault(x - difference, 0) + 1);
            ans = Math.max(ans, f.get(x));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1218 _tcSol = new Solution1218();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [1,2,3,4], difference = 1");
        try {
            int[] arr = new int[]{1, 2, 3, 4};
            int difference = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.longestSubsequence(arr, difference)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,3,5,7], difference = 1");
        try {
            int[] arr = new int[]{1, 3, 5, 7};
            int difference = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.longestSubsequence(arr, difference)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [1,5,7,8,5,3,4,2,1], difference = -2");
        try {
            int[] arr = new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1};
            int difference = -2;
            System.out.println("  Output  : " + _tcShow(_tcSol.longestSubsequence(arr, difference)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}