package com.leetcode.arrays_hashing_greedy;

class Solution2964 {
    public int divisibleTripletCount(int[] nums, int d) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int ans = 0, n = nums.length;
        for (int j = 0; j < n; ++j) {
            for (int k = j + 1; k < n; ++k) {
                int x = (d - (nums[j] + nums[k]) % d) % d;
                ans += cnt.getOrDefault(x, 0);
            }
            cnt.merge(nums[j] % d, 1, Integer::sum);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2964 _tcSol = new Solution2964();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,3,4,7,8], d = 5");
        try {
            int[] nums = new int[]{3, 3, 4, 7, 8};
            int d = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.divisibleTripletCount(nums, d)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,3,3,3], d = 3");
        try {
            int[] nums = new int[]{3, 3, 3, 3};
            int d = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.divisibleTripletCount(nums, d)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [3,3,3,3], d = 6");
        try {
            int[] nums = new int[]{3, 3, 3, 3};
            int d = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.divisibleTripletCount(nums, d)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}