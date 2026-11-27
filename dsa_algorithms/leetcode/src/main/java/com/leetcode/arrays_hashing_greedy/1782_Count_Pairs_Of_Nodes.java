package com.leetcode.arrays_hashing_greedy;

class Solution1782 {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] cnt = new int[n];
        Map<Integer, Integer> g = new HashMap<>();
        for (var e : edges) {
            int a = e[0] - 1, b = e[1] - 1;
            ++cnt[a];
            ++cnt[b];
            int k = Math.min(a, b) * n + Math.max(a, b);
            g.merge(k, 1, Integer::sum);
        }
        int[] s = cnt.clone();
        Arrays.sort(s);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            int t = queries[i];
            for (int j = 0; j < n; ++j) {
                int x = s[j];
                int k = search(s, t - x, j + 1);
                ans[i] += n - k;
            }
            for (var e : g.entrySet()) {
                int a = e.getKey() / n, b = e.getKey() % n;
                int v = e.getValue();
                if (cnt[a] + cnt[b] > t && cnt[a] + cnt[b] - v <= t) {
                    --ans[i];
                }
            }
        }
        return ans;
    }

    private int search(int[] arr, int x, int i) {
        int left = i, right = arr.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (arr[mid] > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1782 _tcSol = new Solution1782();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, edges = [[1,2],[2,4],[1,3],[2,3],[2,1]], queries = [2,3]");
        try {
            int n = 4;
            int[][] edges = new int[][]{new int[]{1, 2}, new int[]{2, 4}, new int[]{1, 3}, new int[]{2, 3}, new int[]{2, 1}};
            int[] queries = new int[]{2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPairs(n, edges, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[6,5]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, edges = [[1,5],[1,5],[3,4],[2,5],[1,3],[5,1],[2,3],[2,5]], queries = [1,2,3,4,5]");
        try {
            int n = 5;
            int[][] edges = new int[][]{new int[]{1, 5}, new int[]{1, 5}, new int[]{3, 4}, new int[]{2, 5}, new int[]{1, 3}, new int[]{5, 1}, new int[]{2, 3}, new int[]{2, 5}};
            int[] queries = new int[]{1, 2, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPairs(n, edges, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[10,10,9,8,6]");
        System.out.println();
    }
}