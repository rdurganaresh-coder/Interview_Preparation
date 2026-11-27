package com.leetcode.arrays_hashing_greedy;

class Solution2172 {
    public int maximumANDSum(int[] nums, int numSlots) {
        int n = nums.length;
        int m = numSlots << 1;
        int[] f = new int[1 << m];
        int ans = 0;
        for (int i = 0; i < 1 << m; ++i) {
            int cnt = Integer.bitCount(i);
            if (cnt > n) {
                continue;
            }
            for (int j = 0; j < m; ++j) {
                if ((i >> j & 1) == 1) {
                    f[i] = Math.max(f[i], f[i ^ (1 << j)] + (nums[cnt - 1] & (j / 2 + 1)));
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2172 _tcSol = new Solution2172();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5,6], numSlots = 3");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5, 6};
            int numSlots = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumANDSum(nums, numSlots)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,3,10,4,7,1], numSlots = 9");
        try {
            int[] nums = new int[]{1, 3, 10, 4, 7, 1};
            int numSlots = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumANDSum(nums, numSlots)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "24");
        System.out.println();
    }
}