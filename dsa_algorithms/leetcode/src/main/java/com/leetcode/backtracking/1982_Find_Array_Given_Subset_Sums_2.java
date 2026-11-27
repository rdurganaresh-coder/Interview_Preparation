package com.leetcode.backtracking;

class Solution1982_2 {
    public int[] recoverArray(int n, int[] sums) {
        Arrays.sort(sums);
        int[] sums1 = new int[1 << n];
        int[] sums2 = new int[1 << n];
        Map<Integer, Integer> cnt = new HashMap<>();
        int[] ans = new int[n];
        for (int i = n; i > 0; --i) {
            int k = 1 << i;
            int d = sums[k - 1] - sums[k - 2];
            cnt.clear();
            for (int j = 0; j < k; ++j) {
                cnt.merge(sums[j], 1, Integer::sum);
            }
            int sign = 1;
            for (int j = 0, p = 0; j < k; ++j) {
                if (cnt.getOrDefault(sums[j], 0) == 0) {
                    continue;
                }
                cnt.merge(sums[j], -1, Integer::sum);
                cnt.merge(sums[j] + d, -1, Integer::sum);
                sums1[p] = sums[j];
                sums2[p++] = sums[j] + d;
                if (sums[j] + d == 0) {
                    sign = -1;
                }
            }
            ans[i - 1] = sign * d;
            System.arraycopy(sign == 1 ? sums1 : sums2, 0, sums, 0, k / 2);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1982_2 _tcSol = new Solution1982_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, sums = [-3,-2,-1,0,0,1,2,3]");
        try {
            int n = 3;
            int[] sums = new int[]{-3, -2, -1, 0, 0, 1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.recoverArray(n, sums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,-3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2, sums = [0,0,0,0]");
        try {
            int n = 2;
            int[] sums = new int[]{0, 0, 0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.recoverArray(n, sums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,0]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 4, sums = [0,0,5,5,4,-1,4,9,9,-1,4,3,4,8,3,8]");
        try {
            int n = 4;
            int[] sums = new int[]{0, 0, 5, 5, 4, -1, 4, 9, 9, -1, 4, 3, 4, 8, 3, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.recoverArray(n, sums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,-1,4,5]");
        System.out.println();
    }
}