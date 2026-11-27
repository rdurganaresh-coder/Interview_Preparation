package com.leetcode.sliding_window_two_pointers;

class Solution0967 {
    private List<Integer> ans = new ArrayList<>();
    private int boundary;
    private int k;

    public int[] numsSameConsecDiff(int n, int k) {
        this.k = k;
        boundary = (int) Math.pow(10, n - 1);
        for (int i = 1; i < 10; ++i) {
            dfs(i);
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    private void dfs(int x) {
        if (x >= boundary) {
            ans.add(x);
            return;
        }
        int last = x % 10;
        if (last + k < 10) {
            dfs(x * 10 + last + k);
        }
        if (k != 0 && last - k >= 0) {
            dfs(x * 10 + last - k);
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0967 _tcSol = new Solution0967();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, k = 7");
        try {
            int n = 3;
            int k = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.numsSameConsecDiff(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[181,292,707,818,929]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2, k = 1");
        try {
            int n = 2;
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.numsSameConsecDiff(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]");
        System.out.println();
    }
}
