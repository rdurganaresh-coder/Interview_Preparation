package com.leetcode.arrays_hashing_greedy;

class Solution2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] presum = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            presum[i + 1] = presum[i] + (s.charAt(i) == '*' ? 1 : 0);
        }
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0, l = -1; i < n; ++i) {
            if (s.charAt(i) == '|') {
                l = i;
            }
            left[i] = l;
        }
        for (int i = n - 1, r = -1; i >= 0; --i) {
            if (s.charAt(i) == '|') {
                r = i;
            }
            right[i] = r;
        }
        int[] ans = new int[queries.length];
        for (int k = 0; k < queries.length; ++k) {
            int i = right[queries[k][0]];
            int j = left[queries[k][1]];
            if (i >= 0 && j >= 0 && i < j) {
                ans[k] = presum[j] - presum[i + 1];
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
        Solution2055 _tcSol = new Solution2055();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"**|**|***|\", queries = [[2,5],[5,9]]");
        try {
            String s = "**|**|***|";
            int[][] queries = new int[][]{new int[]{2, 5}, new int[]{5, 9}};
            System.out.println("  Output  : " + _tcShow(_tcSol.platesBetweenCandles(s, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"***|**|*****|**||**|*\", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]");
        try {
            String s = "***|**|*****|**||**|*";
            int[][] queries = new int[][]{new int[]{1, 17}, new int[]{4, 5}, new int[]{14, 17}, new int[]{5, 11}, new int[]{15, 16}};
            System.out.println("  Output  : " + _tcShow(_tcSol.platesBetweenCandles(s, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[9,0,0,0,0]");
        System.out.println();
    }
}