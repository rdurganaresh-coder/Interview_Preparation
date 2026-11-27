package com.leetcode.arrays_hashing_greedy;

class Solution2591 {
    public int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }
        if (money > 8 * children) {
            return children - 1;
        }
        if (money == 8 * children - 4) {
            return children - 2;
        }
        // money-8x >= children-x, x <= (money-children)/7
        return (money - children) / 7;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2591 _tcSol = new Solution2591();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "money = 20, children = 3");
        try {
            int money = 20;
            int children = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.distMoney(money, children)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "money = 16, children = 2");
        try {
            int money = 16;
            int children = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.distMoney(money, children)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}