package com.leetcode.graphs_shortest_path;

class Solution3378_2 {
    private void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        if (visited[node]) return;
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            dfs(neighbor, adj, visited);
        }
    }

    public int countComponents(int[] nums, int threshold) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= threshold; i++) {
            adj.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[threshold + 1];
        int ans = 0;

        for (int num : nums) {
            if (num > threshold) {
                ans++;
                continue;
            }
            for (int j = 2 * num; j <= threshold; j += num) {
                adj.get(num).add(j);
                adj.get(j).add(num);
            }
        }

        for (int num : nums) {
            if (num <= threshold && !visited[num]) {
                dfs(num, adj, visited);
                ans++;
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
        Solution3378_2 _tcSol = new Solution3378_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,4,8,3,9], threshold = 5");
        try {
            int[] nums = new int[]{2, 4, 8, 3, 9};
            int threshold = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.countComponents(nums, threshold)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,4,8,3,9,12], threshold = 10");
        try {
            int[] nums = new int[]{2, 4, 8, 3, 9, 12};
            int threshold = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.countComponents(nums, threshold)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
