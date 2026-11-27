package com.leetcode.arrays_hashing_greedy;

class Solution2446 {
    public boolean haveConflict(String[] event1, String[] event2) {
        return !(event1[0].compareTo(event2[1]) > 0 || event1[1].compareTo(event2[0]) < 0);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2446 _tcSol = new Solution2446();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "event1 = [\"01:15\",\"02:00\"], event2 = [\"02:00\",\"03:00\"]");
        try {
            String[] event1 = new String[]{"01:15", "02:00"};
            String[] event2 = new String[]{"02:00", "03:00"};
            System.out.println("  Output  : " + _tcShow(_tcSol.haveConflict(event1, event2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "event1 = [\"01:00\",\"02:00\"], event2 = [\"01:20\",\"03:00\"]");
        try {
            String[] event1 = new String[]{"01:00", "02:00"};
            String[] event2 = new String[]{"01:20", "03:00"};
            System.out.println("  Output  : " + _tcShow(_tcSol.haveConflict(event1, event2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "event1 = [\"10:00\",\"11:00\"], event2 = [\"14:00\",\"15:00\"]");
        try {
            String[] event1 = new String[]{"10:00", "11:00"};
            String[] event2 = new String[]{"14:00", "15:00"};
            System.out.println("  Output  : " + _tcShow(_tcSol.haveConflict(event1, event2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}