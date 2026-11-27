package com.leetcode.arrays_hashing_greedy;

class Solution2491 {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        int t = skill[0] + skill[n - 1];
        long ans = 0;
        for (int i = 0, j = n - 1; i < j; ++i, --j) {
            if (skill[i] + skill[j] != t) {
                return -1;
            }
            ans += (long) skill[i] * skill[j];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2491 _tcSol = new Solution2491();
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