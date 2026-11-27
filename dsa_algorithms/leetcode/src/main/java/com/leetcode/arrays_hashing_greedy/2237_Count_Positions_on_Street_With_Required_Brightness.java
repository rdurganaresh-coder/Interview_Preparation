package com.leetcode.arrays_hashing_greedy;

class Solution2237 {
    public int meetRequirement(int n, int[][] lights, int[] requirement) {
        int[] d = new int[n + 1];
        for (int[] e : lights) {
            int i = Math.max(0, e[0] - e[1]);
            int j = Math.min(n - 1, e[0] + e[1]);
            ++d[i];
            --d[j + 1];
        }
        int s = 0;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            s += d[i];
            if (s >= requirement[i]) {
                ++ans;
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
        Solution2237 _tcSol = new Solution2237();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, lights = [[0,1],[2,1],[3,2]], requirement = [0,2,1,4,1]");
        try {
            int n = 5;
            int[][] lights = new int[][]{new int[]{0, 1}, new int[]{2, 1}, new int[]{3, 2}};
            int[] requirement = new int[]{0, 2, 1, 4, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.meetRequirement(n, lights, requirement)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 1, lights = [[0,1]], requirement = [2]");
        try {
            int n = 1;
            int[][] lights = new int[][]{new int[]{0, 1}};
            int[] requirement = new int[]{2};
            System.out.println("  Output  : " + _tcShow(_tcSol.meetRequirement(n, lights, requirement)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
