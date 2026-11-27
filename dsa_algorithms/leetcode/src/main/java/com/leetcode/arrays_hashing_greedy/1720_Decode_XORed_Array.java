package com.leetcode.arrays_hashing_greedy;

class Solution1720 {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int[] ans = new int[n + 1];
        ans[0] = first;
        for (int i = 0; i < n; ++i) {
            ans[i + 1] = ans[i] ^ encoded[i];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1720 _tcSol = new Solution1720();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "encoded = [1,2,3], first = 1");
        try {
            int[] encoded = new int[]{1, 2, 3};
            int first = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.decode(encoded, first)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,0,2,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "encoded = [6,2,7,3], first = 4");
        try {
            int[] encoded = new int[]{6, 2, 7, 3};
            int first = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.decode(encoded, first)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,2,0,7,4]");
        System.out.println();
    }
}