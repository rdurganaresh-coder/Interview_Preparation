package com.leetcode.arrays_hashing_greedy;

class Solution2059_2 {
    public int minimumOperations(int[] nums, int start, int goal) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        boolean[] vis = new boolean[1001];
        int ans = 0;
        while (!q.isEmpty()) {
            ++ans;
            for (int n = q.size(); n > 0; --n) {
                int x = q.poll();
                for (int y : next(nums, x)) {
                    if (y == goal) {
                        return ans;
                    }
                    if (y >= 0 && y <= 1000 && !vis[y]) {
                        vis[y] = true;
                        q.offer(y);
                    }
                }
            }
        }
        return -1;
    }

    private List<Integer> next(int[] nums, int x) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            res.add(x + num);
            res.add(x - num);
            res.add(x ^ num);
        }
        return res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2059_2 _tcSol = new Solution2059_2();
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