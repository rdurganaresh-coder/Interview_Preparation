package com.leetcode.arrays_hashing_greedy;

class Solution2612 {
    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        int[] ans = new int[n];
        TreeSet<Integer>[] ts = new TreeSet[] {new TreeSet<>(), new TreeSet<>()};
        for (int i = 0; i < n; ++i) {
            ts[i % 2].add(i);
            ans[i] = i == p ? 0 : -1;
        }
        ts[p % 2].remove(p);
        for (int i : banned) {
            ts[i % 2].remove(i);
        }
        ts[0].add(n);
        ts[1].add(n);
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(p);
        while (!q.isEmpty()) {
            int i = q.poll();
            int mi = Math.max(i - k + 1, k - i - 1);
            int mx = Math.min(i + k - 1, n * 2 - k - i - 1);
            var s = ts[mi % 2];
            for (int j = s.ceiling(mi); j <= mx; j = s.ceiling(mi)) {
                q.offer(j);
                ans[j] = ans[i] + 1;
                s.remove(j);
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2612 _tcSol = new Solution2612();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, p = 0, banned = [1,2], k = 4");
        try {
            int n = 4;
            int p = 0;
            int[] banned = new int[]{1, 2};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minReverseOperations(n, p, banned, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,-1,-1,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, p = 0, banned = [2,4], k = 3");
        try {
            int n = 5;
            int p = 0;
            int[] banned = new int[]{2, 4};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minReverseOperations(n, p, banned, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,-1,-1,-1,-1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 4, p = 2, banned = [0,1,3], k = 1");
        try {
            int n = 4;
            int p = 2;
            int[] banned = new int[]{0, 1, 3};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minReverseOperations(n, p, banned, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,-1,0,-1]");
        System.out.println();
    }
}