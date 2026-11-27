package com.leetcode.arrays_hashing_greedy;

class Solution2465 {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> s = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n >> 1; ++i) {
            s.add(nums[i] + nums[n - i - 1]);
        }
        return s.size();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2465 _tcSol = new Solution2465();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,1,4,0,3,5]");
        try {
            int[] nums = new int[]{4, 1, 4, 0, 3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.distinctAverages(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,100]");
        try {
            int[] nums = new int[]{1, 100};
            System.out.println("  Output  : " + _tcShow(_tcSol.distinctAverages(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}