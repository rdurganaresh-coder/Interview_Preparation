package com.leetcode.arrays_hashing_greedy;

class Solution3354 {
    public int countValidSelections(int[] nums) {
        int s = Arrays.stream(nums).sum();
        int ans = 0, l = 0;
        for (int x : nums) {
            if (x != 0) {
                l += x;
            } else if (l * 2 == s) {
                ans += 2;
            } else if (Math.abs(l * 2 - s) <= 1) {
                ++ans;
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
        Solution3354 _tcSol = new Solution3354();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,0,2,0,3]");
        try {
            int[] nums = new int[]{1, 0, 2, 0, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.countValidSelections(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,3,4,0,4,1,0]");
        try {
            int[] nums = new int[]{2, 3, 4, 0, 4, 1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.countValidSelections(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
