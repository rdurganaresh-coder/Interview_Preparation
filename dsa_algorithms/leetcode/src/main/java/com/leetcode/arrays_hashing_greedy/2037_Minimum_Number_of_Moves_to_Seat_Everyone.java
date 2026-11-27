package com.leetcode.arrays_hashing_greedy;

class Solution2037 {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int ans = 0;
        for (int i = 0; i < seats.length; ++i) {
            ans += Math.abs(seats[i] - students[i]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2037 _tcSol = new Solution2037();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "seats = [3,1,5], students = [2,7,4]");
        try {
            int[] seats = new int[]{3, 1, 5};
            int[] students = new int[]{2, 7, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.minMovesToSeat(seats, students)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "seats = [4,1,5,9], students = [1,3,2,6]");
        try {
            int[] seats = new int[]{4, 1, 5, 9};
            int[] students = new int[]{1, 3, 2, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.minMovesToSeat(seats, students)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "seats = [2,2,6,6], students = [1,3,2,6]");
        try {
            int[] seats = new int[]{2, 2, 6, 6};
            int[] students = new int[]{1, 3, 2, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.minMovesToSeat(seats, students)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}