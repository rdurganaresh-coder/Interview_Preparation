package com.leetcode.arrays_hashing_greedy;

class Solution1860 {
    public int[] memLeak(int memory1, int memory2) {
        int i = 1;
        for (; i <= Math.max(memory1, memory2); ++i) {
            if (memory1 >= memory2) {
                memory1 -= i;
            } else {
                memory2 -= i;
            }
        }
        return new int[] {i, memory1, memory2};
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1860 _tcSol = new Solution1860();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "memory1 = 2, memory2 = 2");
        try {
            int memory1 = 2;
            int memory2 = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.memLeak(memory1, memory2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,1,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "memory1 = 8, memory2 = 11");
        try {
            int memory1 = 8;
            int memory2 = 11;
            System.out.println("  Output  : " + _tcShow(_tcSol.memLeak(memory1, memory2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[6,0,4]");
        System.out.println();
    }
}