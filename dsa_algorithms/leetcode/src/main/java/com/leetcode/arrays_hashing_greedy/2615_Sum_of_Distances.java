package com.leetcode.arrays_hashing_greedy;

class Solution2615 {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        Map<Integer, List<Integer>> d = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            d.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for (var idx : d.values()) {
            int m = idx.size();
            long left = 0;
            long right = -1L * m * idx.get(0);
            for (int i : idx) {
                right += i;
            }
            for (int i = 0; i < m; ++i) {
                ans[idx.get(i)] = left + right;
                if (i + 1 < m) {
                    left += (idx.get(i + 1) - idx.get(i)) * (i + 1L);
                    right -= (idx.get(i + 1) - idx.get(i)) * (m - i - 1L);
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
        Solution2615 _tcSol = new Solution2615();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,1,1,2]");
        try {
            int[] nums = new int[]{1, 3, 1, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.distance(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,0,3,4,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,5,3]");
        try {
            int[] nums = new int[]{0, 5, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.distance(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,0,0]");
        System.out.println();
    }
}