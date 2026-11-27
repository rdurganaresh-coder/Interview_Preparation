package com.leetcode.arrays_hashing_greedy;

class Solution2212 {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int st = 0, mx = 0;
        int m = aliceArrows.length;
        for (int mask = 1; mask < 1 << m; ++mask) {
            int cnt = 0, s = 0;
            for (int i = 0; i < m; ++i) {
                if ((mask >> i & 1) == 1) {
                    s += i;
                    cnt += aliceArrows[i] + 1;
                }
            }
            if (cnt <= numArrows && s > mx) {
                mx = s;
                st = mask;
            }
        }
        int[] ans = new int[m];
        for (int i = 0; i < m; ++i) {
            if ((st >> i & 1) == 1) {
                ans[i] = aliceArrows[i] + 1;
                numArrows -= ans[i];
            }
        }
        ans[0] += numArrows;
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2212 _tcSol = new Solution2212();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "numArrows = 9, aliceArrows = [1,1,0,1,0,0,2,1,0,1,2,0]");
        try {
            int numArrows = 9;
            int[] aliceArrows = new int[]{1, 1, 0, 1, 0, 0, 2, 1, 0, 1, 2, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumBobPoints(numArrows, aliceArrows)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,0,0,0,1,1,0,0,1,2,3,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "numArrows = 3, aliceArrows = [0,0,1,0,0,0,0,0,0,0,0,2]");
        try {
            int numArrows = 3;
            int[] aliceArrows = new int[]{0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumBobPoints(numArrows, aliceArrows)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,0,0,0,0,0,0,0,1,1,1,0]");
        System.out.println();
    }
}
