package com.leetcode.arrays_hashing_greedy;

class Solution2354 {
    public long countExcellentPairs(int[] nums, int k) {
        Set<Integer> s = new HashSet<>();
        for (int v : nums) {
            s.add(v);
        }
        long ans = 0;
        int[] cnt = new int[32];
        for (int v : s) {
            int t = Integer.bitCount(v);
            ++cnt[t];
        }
        for (int v : s) {
            int t = Integer.bitCount(v);
            for (int i = 0; i < 32; ++i) {
                if (t + i >= k) {
                    ans += cnt[i];
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

    public static void main(String[] args) {
        Solution2354 _tcSol = new Solution2354();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,1], k = 3");
        try {
            int[] nums = new int[]{1, 2, 3, 1};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.countExcellentPairs(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,1,1], k = 10");
        try {
            int[] nums = new int[]{5, 1, 1};
            int k = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.countExcellentPairs(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}