package com.leetcode.bit_manipulation_math;

class Solution1999 {
    public int findInteger(int k, int digit1, int digit2) {
        if (digit1 == 0 && digit2 == 0) {
            return -1;
        }
        if (digit1 > digit2) {
            return findInteger(k, digit2, digit1);
        }
        Deque<Long> q = new ArrayDeque<>();
        q.offer(0L);
        while (true) {
            long x = q.poll();
            if (x > Integer.MAX_VALUE) {
                return -1;
            }
            if (x > k && x % k == 0) {
                return (int) x;
            }
            q.offer(x * 10 + digit1);
            if (digit1 != digit2) {
                q.offer(x * 10 + digit2);
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1999 _tcSol = new Solution1999();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "k = 2, digit1 = 0, digit2 = 2");
        try {
            int k = 2;
            int digit1 = 0;
            int digit2 = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.findInteger(k, digit1, digit2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "k = 3, digit1 = 4, digit2 = 2");
        try {
            int k = 3;
            int digit1 = 4;
            int digit2 = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.findInteger(k, digit1, digit2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "24");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "k = 2, digit1 = 0, digit2 = 0");
        try {
            int k = 2;
            int digit1 = 0;
            int digit2 = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.findInteger(k, digit1, digit2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}