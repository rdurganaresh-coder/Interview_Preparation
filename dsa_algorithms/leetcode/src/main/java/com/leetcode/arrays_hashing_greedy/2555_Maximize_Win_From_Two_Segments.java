package com.leetcode.arrays_hashing_greedy;

class Solution2555 {
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;
        int[] f = new int[n + 1];
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            int x = prizePositions[i - 1];
            int j = search(prizePositions, x - k);
            ans = Math.max(ans, f[j] + i - j);
            f[i] = Math.max(f[i - 1], i - j);
        }
        return ans;
    }

    private int search(int[] nums, int x) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2555 _tcSol = new Solution2555();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "prizePositions = [1,1,2,2,3,3,5], k = 2");
        try {
            int[] prizePositions = new int[]{1, 1, 2, 2, 3, 3, 5};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximizeWin(prizePositions, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "prizePositions = [1,2,3,4], k = 0");
        try {
            int[] prizePositions = new int[]{1, 2, 3, 4};
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximizeWin(prizePositions, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}