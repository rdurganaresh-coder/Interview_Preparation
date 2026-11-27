package com.leetcode.arrays_hashing_greedy;

class Solution1298 {
    public int maxCandies(
        int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Deque<Integer> q = new ArrayDeque<>();
        Set<Integer> has = new HashSet<>();
        Set<Integer> took = new HashSet<>();
        int ans = 0;
        for (int box : initialBoxes) {
            has.add(box);
            if (status[box] == 1) {
                q.offer(box);
                took.add(box);
                ans += candies[box];
            }
        }
        while (!q.isEmpty()) {
            int box = q.poll();
            for (int k : keys[box]) {
                if (status[k] == 0) {
                    status[k] = 1;
                    if (has.contains(k) && !took.contains(k)) {
                        q.offer(k);
                        took.add(k);
                        ans += candies[k];
                    }
                }
            }
            for (int b : containedBoxes[box]) {
                has.add(b);
                if (status[b] == 1 && !took.contains(b)) {
                    q.offer(b);
                    took.add(b);
                    ans += candies[b];
                }
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
        Solution1298 _tcSol = new Solution1298();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "status = [1,0,1,0], candies = [7,5,4,100], keys = [[],[],[1],[]], containedBoxes = [[1,2],[3],[],[]], initialBoxes = [0]");
        try {
            int[] status = new int[]{1, 0, 1, 0};
            int[] candies = new int[]{7, 5, 4, 100};
            int[][] keys = new int[][]{new int[]{}, new int[]{}, new int[]{1}, new int[]{}};
            int[][] containedBoxes = new int[][]{new int[]{1, 2}, new int[]{3}, new int[]{}, new int[]{}};
            int[] initialBoxes = new int[]{0};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxCandies(status, candies, keys, containedBoxes, initialBoxes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "status = [1,0,0,0,0,0], candies = [1,1,1,1,1,1], keys = [[1,2,3,4,5],[],[],[],[],[]], containedBoxes = [[1,2,3,4,5],[],[],[],[],[]], initialBoxes = [0]");
        try {
            int[] status = new int[]{1, 0, 0, 0, 0, 0};
            int[] candies = new int[]{1, 1, 1, 1, 1, 1};
            int[][] keys = new int[][]{new int[]{1, 2, 3, 4, 5}, new int[]{}, new int[]{}, new int[]{}, new int[]{}, new int[]{}};
            int[][] containedBoxes = new int[][]{new int[]{1, 2, 3, 4, 5}, new int[]{}, new int[]{}, new int[]{}, new int[]{}, new int[]{}};
            int[] initialBoxes = new int[]{0};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxCandies(status, candies, keys, containedBoxes, initialBoxes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}
