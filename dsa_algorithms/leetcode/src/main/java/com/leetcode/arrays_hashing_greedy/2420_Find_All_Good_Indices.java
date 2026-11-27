package com.leetcode.arrays_hashing_greedy;

class Solution2420 {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] decr = new int[n];
        int[] incr = new int[n];
        Arrays.fill(decr, 1);
        Arrays.fill(incr, 1);
        for (int i = 2; i < n - 1; ++i) {
            if (nums[i - 1] <= nums[i - 2]) {
                decr[i] = decr[i - 1] + 1;
            }
        }
        for (int i = n - 3; i >= 0; --i) {
            if (nums[i + 1] <= nums[i + 2]) {
                incr[i] = incr[i + 1] + 1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = k; i < n - k; ++i) {
            if (decr[i] >= k && incr[i] >= k) {
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
        Solution2420 _tcSol = new Solution2420();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,1,1,1,3,4,1], k = 2");
        try {
            int[] nums = new int[]{2, 1, 1, 1, 3, 4, 1};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.goodIndices(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,1,1,2], k = 2");
        try {
            int[] nums = new int[]{2, 1, 1, 2};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.goodIndices(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}