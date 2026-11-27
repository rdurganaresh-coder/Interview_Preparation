package com.leetcode.arrays_hashing_greedy;

class Solution2483 {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int ans = 0, cost = 0;
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'Y') {
                cost++;
            }
        }
        int mn = cost;
        for (int j = 1; j <= n; j++) {
            cost += customers.charAt(j - 1) == 'N' ? 1 : -1;
            if (cost < mn) {
                ans = j;
                mn = cost;
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
        Solution2483 _tcSol = new Solution2483();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "customers = \"YYNY\"");
        try {
            String customers = "YYNY";
            System.out.println("  Output  : " + _tcShow(_tcSol.bestClosingTime(customers)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "customers = \"NNNNN\"");
        try {
            String customers = "NNNNN";
            System.out.println("  Output  : " + _tcShow(_tcSol.bestClosingTime(customers)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "customers = \"YYYY\"");
        try {
            String customers = "YYYY";
            System.out.println("  Output  : " + _tcShow(_tcSol.bestClosingTime(customers)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}
