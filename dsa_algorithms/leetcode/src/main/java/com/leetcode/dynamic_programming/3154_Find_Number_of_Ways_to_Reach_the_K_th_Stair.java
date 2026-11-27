package com.leetcode.dynamic_programming;

class Solution3154 {
    private Map<Long, Integer> f = new HashMap<>();
    private int k;

    public int waysToReachStair(int k) {
        this.k = k;
        return dfs(1, 0, 0);
    }

    private int dfs(int i, int j, int jump) {
        if (i > k + 1) {
            return 0;
        }
        long key = ((long) i << 32) | jump << 1 | j;
        if (f.containsKey(key)) {
            return f.get(key);
        }
        int ans = i == k ? 1 : 0;
        if (i > 0 && j == 0) {
            ans += dfs(i - 1, 1, jump);
        }
        ans += dfs(i + (1 << jump), 0, jump + 1);
        f.put(key, ans);
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3154 _tcSol = new Solution3154();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "k = 0");
        try {
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.waysToReachStair(k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "k = 1");
        try {
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.waysToReachStair(k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}