package com.leetcode.arrays_hashing_greedy;

class Solution1199 {
    public int minBuildTime(int[] blocks, int split) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int x : blocks) {
            q.offer(x);
        }
        while (q.size() > 1) {
            q.poll();
            q.offer(q.poll() + split);
        }
        return q.poll();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1199 _tcSol = new Solution1199();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "blocks = [1], split = 1");
        try {
            int[] blocks = new int[]{1};
            int split = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minBuildTime(blocks, split)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "blocks = [1,2], split = 5");
        try {
            int[] blocks = new int[]{1, 2};
            int split = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.minBuildTime(blocks, split)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "blocks = [1,2,3], split = 1");
        try {
            int[] blocks = new int[]{1, 2, 3};
            int split = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minBuildTime(blocks, split)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}