package com.leetcode.arrays_hashing_greedy;

class Solution2244 {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int t : tasks) {
            cnt.merge(t, 1, Integer::sum);
        }
        int ans = 0;
        for (int v : cnt.values()) {
            if (v == 1) {
                return -1;
            }
            ans += v / 3 + (v % 3 == 0 ? 0 : 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2244 _tcSol = new Solution2244();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "tasks = [2,2,3,3,2,4,4,4,4,4]");
        try {
            int[] tasks = new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumRounds(tasks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "tasks = [2,3,3]");
        try {
            int[] tasks = new int[]{2, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumRounds(tasks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}