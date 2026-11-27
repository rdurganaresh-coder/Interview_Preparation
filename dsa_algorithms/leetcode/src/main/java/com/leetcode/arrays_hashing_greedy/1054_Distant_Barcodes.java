package com.leetcode.arrays_hashing_greedy;

class Solution1054 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        Integer[] t = new Integer[n];
        int mx = 0;
        for (int i = 0; i < n; ++i) {
            t[i] = barcodes[i];
            mx = Math.max(mx, barcodes[i]);
        }
        int[] cnt = new int[mx + 1];
        for (int x : barcodes) {
            ++cnt[x];
        }
        Arrays.sort(t, (a, b) -> cnt[a] == cnt[b] ? a - b : cnt[b] - cnt[a]);
        int[] ans = new int[n];
        for (int k = 0, j = 0; k < 2; ++k) {
            for (int i = k; i < n; i += 2) {
                ans[i] = t[j++];
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
        Solution1054 _tcSol = new Solution1054();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "barcodes = [1,1,1,2,2,2]");
        try {
            int[] barcodes = new int[]{1, 1, 1, 2, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.rearrangeBarcodes(barcodes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,1,2,1,2,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "barcodes = [1,1,1,1,2,2,3,3]");
        try {
            int[] barcodes = new int[]{1, 1, 1, 1, 2, 2, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.rearrangeBarcodes(barcodes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,3,1,3,1,2,1,2]");
        System.out.println();
    }
}