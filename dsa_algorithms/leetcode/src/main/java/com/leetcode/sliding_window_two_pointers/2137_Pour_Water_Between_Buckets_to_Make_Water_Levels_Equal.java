package com.leetcode.sliding_window_two_pointers;

class Solution2137 {
    public double equalizeWater(int[] buckets, int loss) {
        double l = 0, r = Arrays.stream(buckets).max().getAsInt();
        while (r - l > 1e-5) {
            double mid = (l + r) / 2;
            if (check(buckets, loss, mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private boolean check(int[] buckets, int loss, double v) {
        double a = 0;
        double b = 0;
        for (int x : buckets) {
            if (x > v) {
                a += x - v;
            } else {
                b += (v - x) * 100 / (100 - loss);
            }
        }
        return a >= b;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2137 _tcSol = new Solution2137();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "buckets = [1,2,7], loss = 80");
        try {
            int[] buckets = new int[]{1, 2, 7};
            int loss = 80;
            System.out.println("  Output  : " + _tcShow(_tcSol.equalizeWater(buckets, loss)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2.00000");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "buckets = [2,4,6], loss = 50");
        try {
            int[] buckets = new int[]{2, 4, 6};
            int loss = 50;
            System.out.println("  Output  : " + _tcShow(_tcSol.equalizeWater(buckets, loss)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3.50000");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "buckets = [3,3,3,3], loss = 40");
        try {
            int[] buckets = new int[]{3, 3, 3, 3};
            int loss = 40;
            System.out.println("  Output  : " + _tcShow(_tcSol.equalizeWater(buckets, loss)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3.00000");
        System.out.println();
    }
}