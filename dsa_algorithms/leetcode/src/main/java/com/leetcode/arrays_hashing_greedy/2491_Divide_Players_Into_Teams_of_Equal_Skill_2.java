package com.leetcode.arrays_hashing_greedy;

class Solution2491_2 {
    public long dividePlayers(int[] skill) {
        int s = Arrays.stream(skill).sum();
        int m = skill.length >> 1;
        if (s % m != 0) {
            return -1;
        }
        int t = s / m;
        int[] d = new int[1010];
        long ans = 0;
        for (int v : skill) {
            if (d[t - v] > 0) {
                ans += (long) v * (t - v);
                --d[t - v];
                --m;
            } else {
                ++d[v];
            }
        }
        return m == 0 ? ans : -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2491_2 _tcSol = new Solution2491_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "skill = [3,2,5,1,3,4]");
        try {
            int[] skill = new int[]{3, 2, 5, 1, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.dividePlayers(skill)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "22");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "skill = [3,4]");
        try {
            int[] skill = new int[]{3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.dividePlayers(skill)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "skill = [1,1,2,3]");
        try {
            int[] skill = new int[]{1, 1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.dividePlayers(skill)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}