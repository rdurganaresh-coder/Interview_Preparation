package com.leetcode.arrays_hashing_greedy;

class Solution0324_2 {
    public void wiggleSort(int[] nums) {
        int[] bucket = new int[5001];
        for (int v : nums) {
            ++bucket[v];
        }
        int n = nums.length;
        int j = 5000;
        for (int i = 1; i < n; i += 2) {
            while (bucket[j] == 0) {
                --j;
            }
            nums[i] = j;
            --bucket[j];
        }
        for (int i = 0; i < n; i += 2) {
            while (bucket[j] == 0) {
                --j;
            }
            nums[i] = j;
            --bucket[j];
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0324_2 _tcSol = new Solution0324_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,5,1,1,6,4]");
        try {
            int[] nums = new int[]{1, 5, 1, 1, 6, 4};
            _tcSol.wiggleSort(nums);
            System.out.println("  Output  : " + _tcShow(nums));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,6,1,5,1,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,3,2,2,3,1]");
        try {
            int[] nums = new int[]{1, 3, 2, 2, 3, 1};
            _tcSol.wiggleSort(nums);
            System.out.println("  Output  : " + _tcShow(nums));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3,1,3,1,2]");
        System.out.println();
    }
}