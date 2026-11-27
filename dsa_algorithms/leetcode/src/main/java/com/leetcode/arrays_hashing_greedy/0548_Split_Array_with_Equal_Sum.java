package com.leetcode.arrays_hashing_greedy;

class Solution0548 {
    public boolean splitArray(int[] nums) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + nums[i];
        }
        for (int j = 3; j < n - 3; ++j) {
            Set<Integer> seen = new HashSet<>();
            for (int i = 1; i < j - 1; ++i) {
                if (s[i] == s[j] - s[i + 1]) {
                    seen.add(s[i]);
                }
            }
            for (int k = j + 2; k < n - 1; ++k) {
                if (s[n] - s[k + 1] == s[k] - s[j + 1] && seen.contains(s[n] - s[k + 1])) {
                    return true;
                }
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0548 _tcSol = new Solution0548();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,1,2,1,2,1]");
        try {
            int[] nums = new int[]{1, 2, 1, 2, 1, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.splitArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,1,2,1,2,1,2]");
        try {
            int[] nums = new int[]{1, 2, 1, 2, 1, 2, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.splitArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}