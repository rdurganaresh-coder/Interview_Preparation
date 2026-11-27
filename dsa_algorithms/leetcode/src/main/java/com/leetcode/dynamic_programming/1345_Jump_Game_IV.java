package com.leetcode.dynamic_programming;

class Solution1345 {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            g.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        boolean[] vis = new boolean[n];
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        vis[0] = true;
        for (int ans = 0;; ++ans) {
            for (int k = q.size(); k > 0; --k) {
                int i = q.poll();
                if (i == n - 1) {
                    return ans;
                }
                for (int j : g.get(arr[i])) {
                    if (!vis[j]) {
                        vis[j] = true;
                        q.offer(j);
                    }
                }
                g.get(arr[i]).clear();
                for (int j : new int[] {i - 1, i + 1}) {
                    if (0 <= j && j < n && !vis[j]) {
                        vis[j] = true;
                        q.offer(j);
                    }
                }
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1345 _tcSol = new Solution1345();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [100,-23,-23,404,100,23,23,23,3,404]");
        try {
            int[] arr = new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
            System.out.println("  Output  : " + _tcShow(_tcSol.minJumps(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [7]");
        try {
            int[] arr = new int[]{7};
            System.out.println("  Output  : " + _tcShow(_tcSol.minJumps(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [7,6,9,6,9,6,9,7]");
        try {
            int[] arr = new int[]{7, 6, 9, 6, 9, 6, 9, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.minJumps(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
