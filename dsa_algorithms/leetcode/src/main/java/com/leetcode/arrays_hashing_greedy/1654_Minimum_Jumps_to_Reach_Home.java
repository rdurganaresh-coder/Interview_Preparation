package com.leetcode.arrays_hashing_greedy;

class Solution1654 {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> s = new HashSet<>();
        for (int v : forbidden) {
            s.add(v);
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 1});
        final int n = 6000;
        boolean[][] vis = new boolean[n][2];
        vis[0][1] = true;
        for (int ans = 0; !q.isEmpty(); ++ans) {
            for (int t = q.size(); t > 0; --t) {
                var p = q.poll();
                int i = p[0], k = p[1];
                if (i == x) {
                    return ans;
                }
                List<int[]> nxt = new ArrayList<>();
                nxt.add(new int[] {i + a, 1});
                if ((k & 1) == 1) {
                    nxt.add(new int[] {i - b, 0});
                }
                for (var e : nxt) {
                    int j = e[0];
                    k = e[1];
                    if (j >= 0 && j < n && !s.contains(j) && !vis[j][k]) {
                        q.offer(new int[] {j, k});
                        vis[j][k] = true;
                    }
                }
            }
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1654 _tcSol = new Solution1654();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "forbidden = [14,4,18,1,15], a = 3, b = 15, x = 9");
        try {
            int[] forbidden = new int[]{14, 4, 18, 1, 15};
            int a = 3;
            int b = 15;
            int x = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumJumps(forbidden, a, b, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "forbidden = [8,3,16,6,12,20], a = 15, b = 13, x = 11");
        try {
            int[] forbidden = new int[]{8, 3, 16, 6, 12, 20};
            int a = 15;
            int b = 13;
            int x = 11;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumJumps(forbidden, a, b, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "forbidden = [1,6,2,14,5,17,4], a = 16, b = 9, x = 7");
        try {
            int[] forbidden = new int[]{1, 6, 2, 14, 5, 17, 4};
            int a = 16;
            int b = 9;
            int x = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumJumps(forbidden, a, b, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}