package com.leetcode.arrays_hashing_greedy;

class Solution3326 {
    private static final int MX = (int) 1e6 + 1;
    private static final int[] LPF = new int[MX + 1];
    static {
        for (int i = 2; i <= MX; ++i) {
            for (int j = i; j <= MX; j += i) {
                if (LPF[j] == 0) {
                    LPF[j] = i;
                }
            }
        }
    }
    public int minOperations(int[] nums) {
        int ans = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                nums[i] = LPF[nums[i]];
                if (nums[i] > nums[i + 1]) {
                    return -1;
                }
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
        Solution3326 _tcSol = new Solution3326();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [25,7]");
        try {
            int[] nums = new int[]{25, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [7,7,6]");
        try {
            int[] nums = new int[]{7, 7, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,1,1,1]");
        try {
            int[] nums = new int[]{1, 1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
