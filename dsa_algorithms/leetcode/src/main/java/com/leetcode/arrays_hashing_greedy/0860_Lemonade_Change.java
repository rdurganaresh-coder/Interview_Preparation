package com.leetcode.arrays_hashing_greedy;

class Solution0860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int v : bills) {
            switch (v) {
                case 5 -> ++five;
                case 10 -> {
                    ++ten;
                    --five;
                }
                case 20 -> {
                    if (ten > 0) {
                        --ten;
                        --five;
                    } else {
                        five -= 3;
                    }
                }
            }
            if (five < 0) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0860 _tcSol = new Solution0860();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "bills = [5,5,5,10,20]");
        try {
            int[] bills = new int[]{5, 5, 5, 10, 20};
            System.out.println("  Output  : " + _tcShow(_tcSol.lemonadeChange(bills)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "bills = [5,5,10,10,20]");
        try {
            int[] bills = new int[]{5, 5, 10, 10, 20};
            System.out.println("  Output  : " + _tcShow(_tcSol.lemonadeChange(bills)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}