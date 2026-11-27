package com.leetcode.arrays_hashing_greedy;

class Solution2511 {
    public int captureForts(int[] forts) {
        int n = forts.length;
        int ans = 0, i = 0;
        while (i < n) {
            int j = i + 1;
            if (forts[i] != 0) {
                while (j < n && forts[j] == 0) {
                    ++j;
                }
                if (j < n && forts[i] + forts[j] == 0) {
                    ans = Math.max(ans, j - i - 1);
                }
            }
            i = j;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2511 _tcSol = new Solution2511();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "forts = [1,0,0,-1,0,0,0,0,1]");
        try {
            int[] forts = new int[]{1, 0, 0, -1, 0, 0, 0, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.captureForts(forts)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "forts = [0,0,1,-1]");
        try {
            int[] forts = new int[]{0, 0, 1, -1};
            System.out.println("  Output  : " + _tcShow(_tcSol.captureForts(forts)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}