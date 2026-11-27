package com.leetcode.arrays_hashing_greedy;

class Solution2355 {
    public long maximumBooks(int[] books) {
        int n = books.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = books[i] - i;
        }
        int[] left = new int[n];
        Arrays.fill(left, -1);
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                left[i] = stk.peek();
            }
            stk.push(i);
        }
        long ans = 0;
        long[] dp = new long[n];
        dp[0] = books[0];
        for (int i = 0; i < n; ++i) {
            int j = left[i];
            int v = books[i];
            int cnt = Math.min(v, i - j);
            int u = v - cnt + 1;
            long s = (long) (u + v) * cnt / 2;
            dp[i] = s + (j == -1 ? 0 : dp[j]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2355 _tcSol = new Solution2355();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "books = [8,5,2,7,9]");
        try {
            int[] books = new int[]{8, 5, 2, 7, 9};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumBooks(books)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "19");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "books = [7,0,3,4,5]");
        try {
            int[] books = new int[]{7, 0, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumBooks(books)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "books = [8,2,3,7,3,4,0,1,4,3]");
        try {
            int[] books = new int[]{8, 2, 3, 7, 3, 4, 0, 1, 4, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumBooks(books)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();
    }
}