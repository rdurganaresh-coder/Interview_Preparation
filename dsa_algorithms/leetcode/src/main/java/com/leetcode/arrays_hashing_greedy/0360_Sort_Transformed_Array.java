package com.leetcode.arrays_hashing_greedy;

class Solution0360 {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] ans = new int[n];
        int i = 0, j = n - 1;

        IntUnaryOperator f = x -> a * x * x + b * x + c;

        for (int k = 0; k < n; k++) {
            int y1 = f.applyAsInt(nums[i]);
            int y2 = f.applyAsInt(nums[j]);
            if (a > 0) {
                if (y1 > y2) {
                    ans[n - k - 1] = y1;
                    i++;
                } else {
                    ans[n - k - 1] = y2;
                    j--;
                }
            } else {
                if (y1 > y2) {
                    ans[k] = y2;
                    j--;
                } else {
                    ans[k] = y1;
                    i++;
                }
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
        Solution0360 _tcSol = new Solution0360();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [-4,-2,2,4], a = 1, b = 3, c = 5");
        try {
            int[] nums = new int[]{-4, -2, 2, 4};
            int a = 1;
            int b = 3;
            int c = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.sortTransformedArray(nums, a, b, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,9,15,33]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-4,-2,2,4], a = -1, b = 3, c = 5");
        try {
            int[] nums = new int[]{-4, -2, 2, 4};
            int a = -1;
            int b = 3;
            int c = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.sortTransformedArray(nums, a, b, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-23,-5,1,7]");
        System.out.println();
    }
}
