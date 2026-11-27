package com.leetcode.arrays_hashing_greedy;

class Solution0936 {
    public int[] movesToStamp(String stamp, String target) {
        int m = stamp.length(), n = target.length();
        int[] indeg = new int[n - m + 1];
        Arrays.fill(indeg, m);
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n - m + 1; ++i) {
            for (int j = 0; j < m; ++j) {
                if (target.charAt(i + j) == stamp.charAt(j)) {
                    if (--indeg[i] == 0) {
                        q.offer(i);
                    }
                } else {
                    g[i + j].add(i);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[n];
        while (!q.isEmpty()) {
            int i = q.poll();
            ans.add(i);
            for (int j = 0; j < m; ++j) {
                if (!vis[i + j]) {
                    vis[i + j] = true;
                    for (int k : g[i + j]) {
                        if (--indeg[k] == 0) {
                            q.offer(k);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (!vis[i]) {
                return new int[0];
            }
        }
        Collections.reverse(ans);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0936 _tcSol = new Solution0936();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "stamp = \"abc\", target = \"ababc\"");
        try {
            String stamp = "abc";
            String target = "ababc";
            System.out.println("  Output  : " + _tcShow(_tcSol.movesToStamp(stamp, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "stamp = \"abca\", target = \"aabcaca\"");
        try {
            String stamp = "abca";
            String target = "aabcaca";
            System.out.println("  Output  : " + _tcShow(_tcSol.movesToStamp(stamp, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,0,1]");
        System.out.println();
    }
}