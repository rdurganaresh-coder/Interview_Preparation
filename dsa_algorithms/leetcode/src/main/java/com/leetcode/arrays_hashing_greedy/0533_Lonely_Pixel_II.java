package com.leetcode.arrays_hashing_greedy;

class Solution0533 {
    public int findBlackPixel(char[][] picture, int target) {
        int m = picture.length;
        int n = picture[0].length;
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        int[] rows = new int[m];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (picture[i][j] == 'B') {
                    ++rows[i];
                    g[j].add(i);
                }
            }
        }
        int ans = 0;
        for (int j = 0; j < n; ++j) {
            if (g[j].isEmpty() || (rows[g[j].get(0)] != target)) {
                continue;
            }
            int i1 = g[j].get(0);
            int ok = 0;
            if (g[j].size() == rows[i1]) {
                ok = target;
                for (int i2 : g[j]) {
                    if (!Arrays.equals(picture[i1], picture[i2])) {
                        ok = 0;
                        break;
                    }
                }
            }
            ans += ok;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0533 _tcSol = new Solution0533();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "picture = [[\"W\",\"B\",\"W\",\"B\",\"B\",\"W\"],[\"W\",\"B\",\"W\",\"B\",\"B\",\"W\"],[\"W\",\"B\",\"W\",\"B\",\"B\",\"W\"],[\"W\",\"W\",\"B\",\"W\",\"B\",\"W\"]], target = 3");
        try {
            char[][] picture = new char[][]{new char[]{'W', 'B', 'W', 'B', 'B', 'W'}, new char[]{'W', 'B', 'W', 'B', 'B', 'W'}, new char[]{'W', 'B', 'W', 'B', 'B', 'W'}, new char[]{'W', 'W', 'B', 'W', 'B', 'W'}};
            int target = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.findBlackPixel(picture, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "picture = [[\"W\",\"W\",\"B\"],[\"W\",\"W\",\"B\"],[\"W\",\"W\",\"B\"]], target = 1");
        try {
            char[][] picture = new char[][]{new char[]{'W', 'W', 'B'}, new char[]{'W', 'W', 'B'}, new char[]{'W', 'W', 'B'}};
            int target = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findBlackPixel(picture, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}