package com.leetcode.arrays_hashing_greedy;

class Solution1058 {
    public String minimizeError(String[] prices, int target) {
        int mi = 0;
        List<Double> arr = new ArrayList<>();
        for (String p : prices) {
            double price = Double.valueOf(p);
            mi += (int) price;
            double d = price - (int) price;
            if (d > 0) {
                arr.add(d);
            }
        }
        if (target < mi || target > mi + arr.size()) {
            return "-1";
        }
        int d = target - mi;
        arr.sort(Collections.reverseOrder());
        double ans = d;
        for (int i = 0; i < d; ++i) {
            ans -= arr.get(i);
        }
        for (int i = d; i < arr.size(); ++i) {
            ans += arr.get(i);
        }
        DecimalFormat df = new DecimalFormat("#0.000");
        return df.format(ans);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1058 _tcSol = new Solution1058();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "prices = [\"0.700\",\"2.800\",\"4.900\"], target = 8");
        try {
            String[] prices = new String[]{"0.700", "2.800", "4.900"};
            int target = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizeError(prices, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"1.000\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "prices = [\"1.500\",\"2.500\",\"3.500\"], target = 10");
        try {
            String[] prices = new String[]{"1.500", "2.500", "3.500"};
            int target = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizeError(prices, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"-1\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "prices = [\"1.500\",\"2.500\",\"3.500\"], target = 9");
        try {
            String[] prices = new String[]{"1.500", "2.500", "3.500"};
            int target = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizeError(prices, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"1.500\"");
        System.out.println();
    }
}