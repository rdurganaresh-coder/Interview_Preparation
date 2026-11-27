package com.leetcode.arrays_hashing_greedy;

class Solution2146 {
    public List<List<Integer>> highestRankedKItems(
        int[][] grid, int[] pricing, int[] start, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int row = start[0], col = start[1];
        int low = pricing[0], high = pricing[1];
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {row, col});
        List<int[]> pq = new ArrayList<>();
        if (low <= grid[row][col] && grid[row][col] <= high) {
            pq.add(new int[] {0, grid[row][col], row, col});
        }
        grid[row][col] = 0;
        final int[] dirs = {-1, 0, 1, 0, -1};
        for (int step = 1; !q.isEmpty(); ++step) {
            for (int size = q.size(); size > 0; --size) {
                int[] curr = q.poll();
                int x = curr[0], y = curr[1];
                for (int j = 0; j < 4; j++) {
                    int nx = x + dirs[j];
                    int ny = y + dirs[j + 1];
                    if (0 <= nx && nx < m && 0 <= ny && ny < n && grid[nx][ny] > 0) {
                        if (low <= grid[nx][ny] && grid[nx][ny] <= high) {
                            pq.add(new int[] {step, grid[nx][ny], nx, ny});
                        }
                        grid[nx][ny] = 0;
                        q.offer(new int[] {nx, ny});
                    }
                }
            }
        }

        pq.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            if (a[2] != b[2]) return Integer.compare(a[2], b[2]);
            return Integer.compare(a[3], b[3]);
        });

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < Math.min(k, pq.size()); i++) {
            ans.add(List.of(pq.get(i)[2], pq.get(i)[3]));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2146 _tcSol = new Solution2146();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,2,0,1],[1,3,0,1],[0,2,5,1]], pricing = [2,5], start = [0,0], k = 3");
        try {
            int[][] grid = new int[][]{new int[]{1, 2, 0, 1}, new int[]{1, 3, 0, 1}, new int[]{0, 2, 5, 1}};
            int[] pricing = new int[]{2, 5};
            int[] start = new int[]{0, 0};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.highestRankedKItems(grid, pricing, start, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,1],[1,1],[2,1]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,2,0,1],[1,3,3,1],[0,2,5,1]], pricing = [2,3], start = [2,3], k = 2");
        try {
            int[][] grid = new int[][]{new int[]{1, 2, 0, 1}, new int[]{1, 3, 3, 1}, new int[]{0, 2, 5, 1}};
            int[] pricing = new int[]{2, 3};
            int[] start = new int[]{2, 3};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.highestRankedKItems(grid, pricing, start, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[2,1],[1,2]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1,1,1],[0,0,1],[2,3,4]], pricing = [2,3], start = [0,0], k = 3");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 1}, new int[]{0, 0, 1}, new int[]{2, 3, 4}};
            int[] pricing = new int[]{2, 3};
            int[] start = new int[]{0, 0};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.highestRankedKItems(grid, pricing, start, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[2,1],[2,0]]");
        System.out.println();
    }
}
