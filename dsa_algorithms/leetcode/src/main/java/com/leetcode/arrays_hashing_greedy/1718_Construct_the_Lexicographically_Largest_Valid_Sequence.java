package com.leetcode.arrays_hashing_greedy;

class Solution1718 {
    private int[] path;
    private int[] cnt;
    private int n;

    public int[] constructDistancedSequence(int n) {
        this.n = n;
        path = new int[n * 2];
        cnt = new int[n * 2];
        Arrays.fill(cnt, 2);
        cnt[1] = 1;
        dfs(1);
        int[] ans = new int[n * 2 - 1];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = path[i + 1];
        }
        return ans;
    }

    private boolean dfs(int u) {
        if (u == n * 2) {
            return true;
        }
        if (path[u] > 0) {
            return dfs(u + 1);
        }
        for (int i = n; i > 1; --i) {
            if (cnt[i] > 0 && u + i < n * 2 && path[u + i] == 0) {
                cnt[i] = 0;
                path[u] = i;
                path[u + i] = i;
                if (dfs(u + 1)) {
                    return true;
                }
                cnt[i] = 2;
                path[u] = 0;
                path[u + i] = 0;
            }
        }
        if (cnt[1] > 0) {
            path[u] = 1;
            cnt[1] = 0;
            if (dfs(u + 1)) {
                return true;
            }
            cnt[1] = 1;
            path[u] = 0;
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1718 _tcSol = new Solution1718();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3");
        try {
            int n = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.constructDistancedSequence(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,1,2,3,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5");
        try {
            int n = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.constructDistancedSequence(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,3,1,4,3,5,2,4,2]");
        System.out.println();
    }
}