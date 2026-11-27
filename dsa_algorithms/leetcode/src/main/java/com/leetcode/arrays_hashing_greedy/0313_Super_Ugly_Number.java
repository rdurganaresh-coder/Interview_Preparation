package com.leetcode.arrays_hashing_greedy;

class Solution0313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.offer(1);
        int x = 0;
        while (n-- > 0) {
            x = q.poll();
            while (!q.isEmpty() && q.peek() == x) {
                q.poll();
            }
            for (int k : primes) {
                if (k <= Integer.MAX_VALUE / x) {
                    q.offer(k * x);
                }
                if (x % k == 0) {
                    break;
                }
            }
        }
        return x;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0313 _tcSol = new Solution0313();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 12, primes = [2,7,13,19]");
        try {
            int n = 12;
            int[] primes = new int[]{2, 7, 13, 19};
            System.out.println("  Output  : " + _tcShow(_tcSol.nthSuperUglyNumber(n, primes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "32");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 1, primes = [2,3,5]");
        try {
            int n = 1;
            int[] primes = new int[]{2, 3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.nthSuperUglyNumber(n, primes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}