package com.leetcode.arrays_hashing_greedy;

class Solution1313 {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; ++j) {
                ans.add(nums[i + 1]);
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1313 _tcSol = new Solution1313();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4]");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.decompressRLElist(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,4,4,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,2,3]");
        try {
            int[] nums = new int[]{1, 1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.decompressRLElist(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,3,3]");
        System.out.println();
    }
}
