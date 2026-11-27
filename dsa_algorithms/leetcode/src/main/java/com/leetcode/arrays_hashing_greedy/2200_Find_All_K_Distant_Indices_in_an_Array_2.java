package com.leetcode.arrays_hashing_greedy;

class Solution2200_2 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                idx.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int l = Collections.binarySearch(idx, i - k);
            int r = Collections.binarySearch(idx, i + k + 1);
            l = l < 0 ? -l - 1 : l;
            r = r < 0 ? -r - 2 : r - 1;
            if (l <= r) {
                ans.add(i);
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
        Solution2200_2 _tcSol = new Solution2200_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,4,9,1,3,9,5], key = 9, k = 1");
        try {
            int[] nums = new int[]{3, 4, 9, 1, 3, 9, 5};
            int key = 9;
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findKDistantIndices(nums, key, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,3,4,5,6]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,2,2,2,2], key = 2, k = 2");
        try {
            int[] nums = new int[]{2, 2, 2, 2, 2};
            int key = 2;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.findKDistantIndices(nums, key, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,2,3,4]");
        System.out.println();
    }
}