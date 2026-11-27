package com.leetcode.arrays_hashing_greedy;

class Solution3073 {
    public int maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            right[i] = Math.max(nums[i], right[i + 1]);
        }
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(nums[0]);
        int ans = 0;
        for (int j = 1; j < n - 1; ++j) {
            if (right[j + 1] > nums[j]) {
                Integer it = ts.lower(nums[j]);
                if (it != null) {
                    ans = Math.max(ans, it - nums[j] + right[j + 1]);
                }
            }
            ts.add(nums[j]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3073 _tcSol = new Solution3073();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [5,6,9]");
        try {
            int[] nums = new int[]{5, 6, 9};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumTripletValue(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,5,3,6]");
        try {
            int[] nums = new int[]{1, 5, 3, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumTripletValue(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}