package com.leetcode.arrays_hashing_greedy;

class Solution1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        List<Integer> target = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            target.add(index[i], nums[i]);
        }
        // return target.stream().mapToInt(i -> i).toArray();
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = target.get(i);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1389 _tcSol = new Solution1389();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [0,1,2,3,4], index = [0,1,2,2,1]");
        try {
            int[] nums = new int[]{0, 1, 2, 3, 4};
            int[] index = new int[]{0, 1, 2, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.createTargetArray(nums, index)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,4,1,3,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4,0], index = [0,1,2,3,0]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 0};
            int[] index = new int[]{0, 1, 2, 3, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.createTargetArray(nums, index)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,2,3,4]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1], index = [0]");
        try {
            int[] nums = new int[]{1};
            int[] index = new int[]{0};
            System.out.println("  Output  : " + _tcShow(_tcSol.createTargetArray(nums, index)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1]");
        System.out.println();
    }
}