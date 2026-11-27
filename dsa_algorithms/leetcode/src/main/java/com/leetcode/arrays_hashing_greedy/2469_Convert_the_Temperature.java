package com.leetcode.arrays_hashing_greedy;

class Solution2469 {
    public double[] convertTemperature(double celsius) {
        return new double[] {celsius + 273.15, celsius * 1.8 + 32};
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2469 _tcSol = new Solution2469();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "celsius = 36.50");
        try {
            double celsius = 36.5;
            System.out.println("  Output  : " + _tcShow(_tcSol.convertTemperature(celsius)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[309.65000,97.70000]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "celsius = 122.11");
        try {
            double celsius = 122.11;
            System.out.println("  Output  : " + _tcShow(_tcSol.convertTemperature(celsius)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[395.26000,251.79800]");
        System.out.println();
    }
}