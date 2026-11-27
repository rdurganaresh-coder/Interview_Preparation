package com.leetcode.arrays_hashing_greedy;

class Solution2910 {
    public int minGroupsForValidAssignment(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.merge(x, 1, Integer::sum);
        }
        int k = nums.length;
        for (int v : cnt.values()) {
            k = Math.min(k, v);
        }
        for (;; --k) {
            int ans = 0;
            for (int v : cnt.values()) {
                if (v / k < v % k) {
                    ans = 0;
                    break;
                }
                ans += (v + k) / (k + 1);
            }
            if (ans > 0) {
                return ans;
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2910 _tcSol = new Solution2910();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "balls = [3,2,3,2,3]");
        try {
            int[] nums = new int[]{3, 2, 3, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minGroupsForValidAssignment(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "balls = [10,10,10,3,1,1]");
        try {
            int[] nums = new int[]{10, 10, 10, 3, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minGroupsForValidAssignment(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}