package com.leetcode.arrays_hashing_greedy;

class Solution2148 {
    public int countElements(int[] nums) {
        int mi = Arrays.stream(nums).min().getAsInt();
        int mx = Arrays.stream(nums).max().getAsInt();
        int ans = 0;
        for (int x : nums) {
            if (mi < x && x < mx) {
                ans++;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2148 _tcSol = new Solution2148();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [11,7,2,15]");
        try {
            int[] nums = new int[]{11, 7, 2, 15};
            System.out.println("  Output  : " + _tcShow(_tcSol.countElements(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-3,3,3,90]");
        try {
            int[] nums = new int[]{-3, 3, 3, 90};
            System.out.println("  Output  : " + _tcShow(_tcSol.countElements(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
