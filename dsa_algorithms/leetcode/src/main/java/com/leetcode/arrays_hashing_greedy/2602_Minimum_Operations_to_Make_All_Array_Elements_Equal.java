package com.leetcode.arrays_hashing_greedy;

class Solution2602 {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] s = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + nums[i];
        }
        List<Long> ans = new ArrayList<>();
        for (int x : queries) {
            int i = search(nums, x + 1);
            long t = s[n] - s[i] - 1L * (n - i) * x;
            i = search(nums, x);
            t += 1L * x * i - s[i];
            ans.add(t);
        }
        return ans;
    }

    private int search(int[] nums, int x) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2602 _tcSol = new Solution2602();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,1,6,8], queries = [1,5]");
        try {
            int[] nums = new int[]{3, 1, 6, 8};
            int[] queries = new int[]{1, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[14,10]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,9,6,3], queries = [10]");
        try {
            int[] nums = new int[]{2, 9, 6, 3};
            int[] queries = new int[]{10};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[20]");
        System.out.println();
    }
}