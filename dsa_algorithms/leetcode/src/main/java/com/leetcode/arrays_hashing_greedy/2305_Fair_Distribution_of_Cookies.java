package com.leetcode.arrays_hashing_greedy;

class Solution2305 {
    private int[] cookies;
    private int[] cnt;
    private int k;
    private int n;
    private int ans = 1 << 30;

    public int distributeCookies(int[] cookies, int k) {
        n = cookies.length;
        cnt = new int[k];
        Arrays.sort(cookies);
        this.cookies = cookies;
        this.k = k;
        dfs(n - 1);
        return ans;
    }

    private void dfs(int i) {
        if (i < 0) {
            // ans = Arrays.stream(cnt).max().getAsInt();
            ans = 0;
            for (int v : cnt) {
                ans = Math.max(ans, v);
            }
            return;
        }
        for (int j = 0; j < k; ++j) {
            if (cnt[j] + cookies[i] >= ans || (j > 0 && cnt[j] == cnt[j - 1])) {
                continue;
            }
            cnt[j] += cookies[i];
            dfs(i - 1);
            cnt[j] -= cookies[i];
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2305 _tcSol = new Solution2305();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "cookies = [8,15,10,20,8], k = 2");
        try {
            int[] cookies = new int[]{8, 15, 10, 20, 8};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.distributeCookies(cookies, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "31");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "cookies = [6,1,3,2,2,4,1,2], k = 3");
        try {
            int[] cookies = new int[]{6, 1, 3, 2, 2, 4, 1, 2};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.distributeCookies(cookies, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}