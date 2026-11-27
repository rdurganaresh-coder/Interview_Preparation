package com.leetcode.arrays_hashing_greedy;

class Solution0781 {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : answers) {
            cnt.merge(x, 1, Integer::sum);
        }
        int ans = 0;
        for (var e : cnt.entrySet()) {
            int group = e.getKey() + 1;
            ans += (e.getValue() + group - 1) / group * group;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0781 _tcSol = new Solution0781();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "answers = [1,1,2]");
        try {
            int[] answers = new int[]{1, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.numRabbits(answers)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "answers = [10,10,10]");
        try {
            int[] answers = new int[]{10, 10, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.numRabbits(answers)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();
    }
}
