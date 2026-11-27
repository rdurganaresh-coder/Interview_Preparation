package com.leetcode.arrays_hashing_greedy;

class Solution0137 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : nums) {
                cnt += num >> i & 1;
            }
            cnt %= 3;
            ans |= cnt << i;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0137 _tcSol = new Solution0137();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,2,3,2]");
        try {
            int[] nums = new int[]{2, 2, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.singleNumber(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,1,0,1,0,1,99]");
        try {
            int[] nums = new int[]{0, 1, 0, 1, 0, 1, 99};
            System.out.println("  Output  : " + _tcShow(_tcSol.singleNumber(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "99");
        System.out.println();
    }
}