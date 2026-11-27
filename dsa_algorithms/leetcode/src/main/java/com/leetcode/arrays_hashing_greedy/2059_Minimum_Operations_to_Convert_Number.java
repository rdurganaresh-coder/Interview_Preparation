package com.leetcode.arrays_hashing_greedy;

class Solution2059 {
    public int minimumOperations(int[] nums, int start, int goal) {
        IntBinaryOperator op1 = (x, y) -> x + y;
        IntBinaryOperator op2 = (x, y) -> x - y;
        IntBinaryOperator op3 = (x, y) -> x ^ y;
        IntBinaryOperator[] ops = {op1, op2, op3};
        boolean[] vis = new boolean[1001];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {start, 0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int x = p[0], step = p[1];
            for (int num : nums) {
                for (IntBinaryOperator op : ops) {
                    int nx = op.applyAsInt(x, num);
                    if (nx == goal) {
                        return step + 1;
                    }
                    if (nx >= 0 && nx <= 1000 && !vis[nx]) {
                        queue.offer(new int[] {nx, step + 1});
                        vis[nx] = true;
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
        Solution2059 _tcSol = new Solution2059();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,4,12], start = 2, goal = 12");
        try {
            int[] nums = new int[]{2, 4, 12};
            int start = 2;
            int goal = 12;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperations(nums, start, goal)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,5,7], start = 0, goal = -4");
        try {
            int[] nums = new int[]{3, 5, 7};
            int start = 0;
            int goal = -4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperations(nums, start, goal)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [2,8,16], start = 0, goal = 1");
        try {
            int[] nums = new int[]{2, 8, 16};
            int start = 0;
            int goal = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperations(nums, start, goal)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}