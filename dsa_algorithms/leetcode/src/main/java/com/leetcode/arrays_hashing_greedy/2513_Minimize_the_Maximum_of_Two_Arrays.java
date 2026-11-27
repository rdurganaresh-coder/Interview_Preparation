package com.leetcode.arrays_hashing_greedy;

class Solution2513 {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long divisor = lcm(divisor1, divisor2);
        long left = 1, right = 10000000000L;
        while (left < right) {
            long mid = (left + right) >> 1;
            long cnt1 = mid / divisor1 * (divisor1 - 1) + mid % divisor1;
            long cnt2 = mid / divisor2 * (divisor2 - 1) + mid % divisor2;
            long cnt = mid / divisor * (divisor - 1) + mid % divisor;
            if (cnt1 >= uniqueCnt1 && cnt2 >= uniqueCnt2 && cnt >= uniqueCnt1 + uniqueCnt2) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }

    private long lcm(int a, int b) {
        return (long) a * b / gcd(a, b);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2513 _tcSol = new Solution2513();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "divisor1 = 2, divisor2 = 7, uniqueCnt1 = 1, uniqueCnt2 = 3");
        try {
            int divisor1 = 2;
            int divisor2 = 7;
            int uniqueCnt1 = 1;
            int uniqueCnt2 = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizeSet(divisor1, divisor2, uniqueCnt1, uniqueCnt2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "divisor1 = 3, divisor2 = 5, uniqueCnt1 = 2, uniqueCnt2 = 1");
        try {
            int divisor1 = 3;
            int divisor2 = 5;
            int uniqueCnt1 = 2;
            int uniqueCnt2 = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizeSet(divisor1, divisor2, uniqueCnt1, uniqueCnt2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "divisor1 = 2, divisor2 = 4, uniqueCnt1 = 8, uniqueCnt2 = 2");
        try {
            int divisor1 = 2;
            int divisor2 = 4;
            int uniqueCnt1 = 8;
            int uniqueCnt2 = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizeSet(divisor1, divisor2, uniqueCnt1, uniqueCnt2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();
    }
}