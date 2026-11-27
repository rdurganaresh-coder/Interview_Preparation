package com.leetcode.arrays_hashing_greedy;

class Solution0645_2 {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>(n);
        for (int x : nums) {
            cnt.merge(x, 1, Integer::sum);
        }
        int[] ans = new int[2];
        for (int x = 1; x <= n; ++x) {
            int t = cnt.getOrDefault(x, 0);
            if (t == 2) {
                ans[0] = x;
            } else if (t == 0) {
                ans[1] = x;
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
        Solution0645_2 _tcSol = new Solution0645_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,2,4]");
        try {
            int[] nums = new int[]{1, 2, 2, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.findErrorNums(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1]");
        try {
            int[] nums = new int[]{1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findErrorNums(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2]");
        System.out.println();
    }
}