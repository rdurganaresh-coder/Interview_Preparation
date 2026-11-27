package com.leetcode.arrays_hashing_greedy;

class Solution2440 {
    private List<Integer>[] g;
    private int[] nums;
    private int t;

    public int componentValue(int[] nums, int[][] edges) {
        int n = nums.length;
        g = new List[n];
        this.nums = nums;
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        int s = sum(nums), mx = max(nums);
        for (int k = Math.min(n, s / mx); k > 1; --k) {
            if (s % k == 0) {
                t = s / k;
                if (dfs(0, -1) == 0) {
                    return k - 1;
                }
            }
        }
        return 0;
    }

    private int dfs(int i, int fa) {
        int x = nums[i];
        for (int j : g[i]) {
            if (j != fa) {
                int y = dfs(j, i);
                if (y == -1) {
                    return -1;
                }
                x += y;
            }
        }
        if (x > t) {
            return -1;
        }
        return x < t ? x : 0;
    }

    private int sum(int[] arr) {
        int x = 0;
        for (int v : arr) {
            x += v;
        }
        return x;
    }

    private int max(int[] arr) {
        int x = arr[0];
        for (int v : arr) {
            x = Math.max(x, v);
        }
        return x;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2440 _tcSol = new Solution2440();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [6,2,2,2,6], edges = [[0,1],[1,2],[1,3],[3,4]]");
        try {
            int[] nums = new int[]{6, 2, 2, 2, 6};
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{1, 3}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.componentValue(nums, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2], edges = []");
        try {
            int[] nums = new int[]{2};
            int[][] edges = new int[][]{};
            System.out.println("  Output  : " + _tcShow(_tcSol.componentValue(nums, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
