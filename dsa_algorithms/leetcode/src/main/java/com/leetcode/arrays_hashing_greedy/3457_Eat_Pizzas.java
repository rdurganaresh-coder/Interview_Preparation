package com.leetcode.arrays_hashing_greedy;

class Solution3457 {
    public long maxWeight(int[] pizzas) {
        int n = pizzas.length;
        int days = n / 4;
        Arrays.sort(pizzas);
        int odd = (days + 1) / 2;
        int even = days / 2;
        long ans = 0;
        for (int i = n - odd; i < n; ++i) {
            ans += pizzas[i];
        }
        for (int i = n - odd - 2; even > 0; --even) {
            ans += pizzas[i];
            i -= 2;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3457 _tcSol = new Solution3457();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "pizzas = [1,2,3,4,5,6,7,8]");
        try {
            int[] pizzas = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxWeight(pizzas)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "14");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "pizzas = [2,1,1,1,1,1,1,1]");
        try {
            int[] pizzas = new int[]{2, 1, 1, 1, 1, 1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxWeight(pizzas)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
