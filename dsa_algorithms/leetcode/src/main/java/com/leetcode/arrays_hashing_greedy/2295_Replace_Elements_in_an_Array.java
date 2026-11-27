package com.leetcode.arrays_hashing_greedy;

class Solution2295 {
    public int[] arrayChange(int[] nums, int[][] operations) {
        int n = nums.length;
        Map<Integer, Integer> d = new HashMap<>(n);
        for (int i = 0; i < n; ++i) {
            d.put(nums[i], i);
        }
        for (var op : operations) {
            int x = op[0], y = op[1];
            nums[d.get(x)] = y;
            d.put(y, d.get(x));
        }
        return nums;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2295 _tcSol = new Solution2295();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,4,6], operations = [[1,3],[4,7],[6,1]]");
        try {
            int[] nums = new int[]{1, 2, 4, 6};
            int[][] operations = new int[][]{new int[]{1, 3}, new int[]{4, 7}, new int[]{6, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.arrayChange(nums, operations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,2,7,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2], operations = [[1,3],[2,1],[3,2]]");
        try {
            int[] nums = new int[]{1, 2};
            int[][] operations = new int[][]{new int[]{1, 3}, new int[]{2, 1}, new int[]{3, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.arrayChange(nums, operations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,1]");
        System.out.println();
    }
}