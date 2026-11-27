package com.leetcode.arrays_hashing_greedy;

class Solution2092 {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        boolean[] vis = new boolean[n];
        vis[0] = true;
        vis[firstPerson] = true;
        int m = meetings.length;
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[2]));
        for (int i = 0; i < m;) {
            int j = i;
            for (; j + 1 < m && meetings[j + 1][2] == meetings[i][2];) {
                ++j;
            }
            Map<Integer, List<Integer>> g = new HashMap<>();
            Set<Integer> s = new HashSet<>();
            for (int k = i; k <= j; ++k) {
                int x = meetings[k][0], y = meetings[k][1];
                g.computeIfAbsent(x, key -> new ArrayList<>()).add(y);
                g.computeIfAbsent(y, key -> new ArrayList<>()).add(x);
                s.add(x);
                s.add(y);
            }
            Deque<Integer> q = new ArrayDeque<>();
            for (int u : s) {
                if (vis[u]) {
                    q.offer(u);
                }
            }
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : g.getOrDefault(u, List.of())) {
                    if (!vis[v]) {
                        vis[v] = true;
                        q.offer(v);
                    }
                }
            }
            i = j + 1;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (vis[i]) {
                ans.add(i);
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
        Solution2092 _tcSol = new Solution2092();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 6, meetings = [[1,2,5],[2,3,8],[1,5,10]], firstPerson = 1");
        try {
            int n = 6;
            int[][] meetings = new int[][]{new int[]{1, 2, 5}, new int[]{2, 3, 8}, new int[]{1, 5, 10}};
            int firstPerson = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findAllPeople(n, meetings, firstPerson)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,2,3,5]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, meetings = [[3,1,3],[1,2,2],[0,3,3]], firstPerson = 3");
        try {
            int n = 4;
            int[][] meetings = new int[][]{new int[]{3, 1, 3}, new int[]{1, 2, 2}, new int[]{0, 3, 3}};
            int firstPerson = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.findAllPeople(n, meetings, firstPerson)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,3]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 5, meetings = [[3,4,2],[1,2,1],[2,3,1]], firstPerson = 1");
        try {
            int n = 5;
            int[][] meetings = new int[][]{new int[]{3, 4, 2}, new int[]{1, 2, 1}, new int[]{2, 3, 1}};
            int firstPerson = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findAllPeople(n, meetings, firstPerson)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,2,3,4]");
        System.out.println();
    }
}
