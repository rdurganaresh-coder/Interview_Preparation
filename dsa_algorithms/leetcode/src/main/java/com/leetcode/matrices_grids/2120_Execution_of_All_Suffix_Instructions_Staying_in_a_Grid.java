package com.leetcode.matrices_grids;

class Solution2120 {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int m = s.length();
        int[] ans = new int[m];
        Map<Character, int[]> mp = new HashMap<>(4);
        mp.put('L', new int[] {0, -1});
        mp.put('R', new int[] {0, 1});
        mp.put('U', new int[] {-1, 0});
        mp.put('D', new int[] {1, 0});
        for (int i = 0; i < m; ++i) {
            int x = startPos[0], y = startPos[1];
            int t = 0;
            for (int j = i; j < m; ++j) {
                char c = s.charAt(j);
                int a = mp.get(c)[0], b = mp.get(c)[1];
                if (0 <= x + a && x + a < n && 0 <= y + b && y + b < n) {
                    x += a;
                    y += b;
                    ++t;
                } else {
                    break;
                }
            }
            ans[i] = t;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2120 _tcSol = new Solution2120();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, startPos = [0,1], s = \"RRDDLU\"");
        try {
            int n = 3;
            int[] startPos = new int[]{0, 1};
            String s = "RRDDLU";
            System.out.println("  Output  : " + _tcShow(_tcSol.executeInstructions(n, startPos, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,5,4,3,1,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2, startPos = [1,1], s = \"LURD\"");
        try {
            int n = 2;
            int[] startPos = new int[]{1, 1};
            String s = "LURD";
            System.out.println("  Output  : " + _tcShow(_tcSol.executeInstructions(n, startPos, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,1,0,0]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 1, startPos = [0,0], s = \"LRUD\"");
        try {
            int n = 1;
            int[] startPos = new int[]{0, 0};
            String s = "LRUD";
            System.out.println("  Output  : " + _tcShow(_tcSol.executeInstructions(n, startPos, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,0,0,0]");
        System.out.println();
    }
}