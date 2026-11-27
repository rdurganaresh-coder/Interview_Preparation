package com.leetcode.arrays_hashing_greedy;

class Solution1732 {
    public int largestAltitude(int[] gain) {
        int ans = 0, h = 0;
        for (int v : gain) {
            h += v;
            ans = Math.max(ans, h);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1732 _tcSol = new Solution1732();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "gain = [-5,1,5,0,-7]");
        try {
            int[] gain = new int[]{-5, 1, 5, 0, -7};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestAltitude(gain)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "gain = [-4,-3,-2,-1,4,3,2]");
        try {
            int[] gain = new int[]{-4, -3, -2, -1, 4, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestAltitude(gain)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}