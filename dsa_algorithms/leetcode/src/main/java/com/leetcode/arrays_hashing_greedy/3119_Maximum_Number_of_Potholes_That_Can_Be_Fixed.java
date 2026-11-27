package com.leetcode.arrays_hashing_greedy;

class Solution3119 {
    public int maxPotholes(String road, int budget) {
        road += ".";
        int n = road.length();
        int[] cnt = new int[n];
        int k = 0;
        for (char c : road.toCharArray()) {
            if (c == 'x') {
                ++k;
            } else if (k > 0) {
                ++cnt[k];
                k = 0;
            }
        }
        int ans = 0;
        for (k = n - 1; k > 0 && budget > 0; --k) {
            int t = Math.min(budget / (k + 1), cnt[k]);
            ans += t * k;
            budget -= t * (k + 1);
            cnt[k - 1] += cnt[k] - t;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3119 _tcSol = new Solution3119();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "road = \"..\", budget = 5");
        try {
            String road = "..";
            int budget = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxPotholes(road, budget)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "road = \"..xxxxx\", budget = 4");
        try {
            String road = "..xxxxx";
            int budget = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxPotholes(road, budget)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "road = \"x.x.xxx...x\", budget = 14");
        try {
            String road = "x.x.xxx...x";
            int budget = 14;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxPotholes(road, budget)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}