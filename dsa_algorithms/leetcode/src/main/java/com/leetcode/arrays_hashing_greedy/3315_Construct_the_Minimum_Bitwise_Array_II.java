package com.leetcode.arrays_hashing_greedy;

class Solution3315 {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            int x = nums.get(i);
            if (x == 2) {
                ans[i] = -1;
            } else {
                for (int j = 1; j < 32; ++j) {
                    if ((x >> j & 1) == 0) {
                        ans[i] = x ^ 1 << (j - 1);
                        break;
                    }
                }
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution3315 _tcSol = new Solution3315();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,3,5,7]");
        try {
            List<Integer> nums = _tcL(2, 3, 5, 7);
            System.out.println("  Output  : " + _tcShow(_tcSol.minBitwiseArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,1,4,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [11,13,31]");
        try {
            List<Integer> nums = _tcL(11, 13, 31);
            System.out.println("  Output  : " + _tcShow(_tcSol.minBitwiseArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[9,12,15]");
        System.out.println();
    }
}
