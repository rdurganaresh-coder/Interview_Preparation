package com.leetcode.arrays_hashing_greedy;

class Solution2440_2 {
    public int componentValue(int[] nums, int[][] edges) {
        int n = nums.length;
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        int s = sum(nums), mx = max(nums);
        for (int k = Math.min(n, s / mx); k > 1; --k) {
            if (s % k == 0 && check(nums, g, s / k)) {
                return k - 1;
            }
        }
        return 0;
    }

    private boolean check(int[] nums, List<Integer>[] g, int t) {
        int n = nums.length;
        int[] sz = new int[n];
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {0, -1, 0});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int i = cur[0], fa = cur[1], state = cur[2];
            if (state == 0) {
                stk.push(new int[] {i, fa, 1});
                for (int j : g[i]) {
                    if (j != fa) {
                        stk.push(new int[] {j, i, 0});
                    }
                }
            } else {
                int x = nums[i];
                for (int j : g[i]) {
                    if (j != fa) {
                        x += sz[j];
                    }
                }
                if (x > t) {
                    return false;
                }
                sz[i] = x == t ? 0 : x;
            }
        }
        return sz[0] == 0;
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
        Solution2440_2 _tcSol = new Solution2440_2();
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
