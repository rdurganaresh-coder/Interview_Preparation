package com.leetcode.sliding_window_two_pointers;

class Solution0011 {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int t = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, t);
            if (height[l] < height[r]) {
                ++l;
            } else {
                --r;
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
        Solution0011 _tcSol = new Solution0011();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "height = [1,8,6,2,5,4,8,3,7]");
        try {
            int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxArea(height)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "49");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "height = [1,1]");
        try {
            int[] height = new int[]{1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxArea(height)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
