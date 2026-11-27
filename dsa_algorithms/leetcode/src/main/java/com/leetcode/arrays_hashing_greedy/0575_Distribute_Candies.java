package com.leetcode.arrays_hashing_greedy;

class Solution0575 {
    public int distributeCandies(int[] candyType) {
        Set<Integer> s = new HashSet<>();
        for (int c : candyType) {
            s.add(c);
        }
        return Math.min(candyType.length >> 1, s.size());
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0575 _tcSol = new Solution0575();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "candyType = [1,1,2,2,3,3]");
        try {
            int[] candyType = new int[]{1, 1, 2, 2, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.distributeCandies(candyType)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "candyType = [1,1,2,3]");
        try {
            int[] candyType = new int[]{1, 1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.distributeCandies(candyType)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "candyType = [6,6,6,6]");
        try {
            int[] candyType = new int[]{6, 6, 6, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.distributeCandies(candyType)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}