package com.leetcode.arrays_hashing_greedy;

class Solution2350 {
    public int shortestSequence(int[] rolls, int k) {
        Set<Integer> s = new HashSet<>();
        int ans = 1;
        for (int v : rolls) {
            s.add(v);
            if (s.size() == k) {
                s.clear();
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
        Solution2350 _tcSol = new Solution2350();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "rolls = [4,2,1,2,3,3,2,4,1], k = 4");
        try {
            int[] rolls = new int[]{4, 2, 1, 2, 3, 3, 2, 4, 1};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestSequence(rolls, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "rolls = [1,1,2,2], k = 2");
        try {
            int[] rolls = new int[]{1, 1, 2, 2};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestSequence(rolls, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "rolls = [1,1,3,2,2,2,3,3], k = 4");
        try {
            int[] rolls = new int[]{1, 1, 3, 2, 2, 2, 3, 3};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestSequence(rolls, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}