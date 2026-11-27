package com.leetcode.arrays_hashing_greedy;

class Solution2281 {
    public int totalStrength(int[] strength) {
        int n = strength.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            while (!stk.isEmpty() && strength[stk.peek()] >= strength[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                left[i] = stk.peek();
            }
            stk.push(i);
        }
        stk.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!stk.isEmpty() && strength[stk.peek()] > strength[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                right[i] = stk.peek();
            }
            stk.push(i);
        }
        int mod = (int) 1e9 + 7;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = (s[i] + strength[i]) % mod;
        }
        int[] ss = new int[n + 2];
        for (int i = 0; i < n + 1; ++i) {
            ss[i + 1] = (ss[i] + s[i]) % mod;
        }
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            int v = strength[i];
            int l = left[i] + 1, r = right[i] - 1;
            long a = (long) (i - l + 1) * (ss[r + 2] - ss[i + 1]);
            long b = (long) (r - i + 1) * (ss[i + 1] - ss[l]);
            ans = (ans + v * ((a - b) % mod)) % mod;
        }
        return (int) (ans + mod) % mod;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2281 _tcSol = new Solution2281();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "strength = [1,3,1,2]");
        try {
            int[] strength = new int[]{1, 3, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.totalStrength(strength)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "44");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "strength = [5,4,6]");
        try {
            int[] strength = new int[]{5, 4, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.totalStrength(strength)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "213");
        System.out.println();
    }
}