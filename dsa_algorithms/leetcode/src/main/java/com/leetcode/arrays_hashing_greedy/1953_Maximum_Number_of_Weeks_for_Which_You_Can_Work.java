package com.leetcode.arrays_hashing_greedy;

class Solution1953 {
    public long numberOfWeeks(int[] milestones) {
        int mx = 0;
        long s = 0;
        for (int e : milestones) {
            s += e;
            mx = Math.max(mx, e);
        }
        long rest = s - mx;
        return mx > rest + 1 ? rest * 2 + 1 : s;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1953 _tcSol = new Solution1953();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "milestones = [1,2,3]");
        try {
            int[] milestones = new int[]{1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfWeeks(milestones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "milestones = [5,2,1]");
        try {
            int[] milestones = new int[]{5, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfWeeks(milestones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}