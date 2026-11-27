package com.leetcode.arrays_hashing_greedy;

class Solution2195 {
    public long minimalKSum(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[1] = 2 * 1000000000;
        System.arraycopy(nums, 0, arr, 2, n);
        Arrays.sort(arr);
        long ans = 0;
        for (int i = 0; i < n + 1 && k > 0; ++i) {
            int m = Math.max(0, Math.min(k, arr[i + 1] - arr[i] - 1));
            ans += (arr[i] + 1L + arr[i] + m) * m / 2;
            k -= m;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2195 _tcSol = new Solution2195();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,4,25,10,25], k = 2");
        try {
            int[] nums = new int[]{1, 4, 25, 10, 25};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimalKSum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,6], k = 6");
        try {
            int[] nums = new int[]{5, 6};
            int k = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimalKSum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "25");
        System.out.println();
    }
}