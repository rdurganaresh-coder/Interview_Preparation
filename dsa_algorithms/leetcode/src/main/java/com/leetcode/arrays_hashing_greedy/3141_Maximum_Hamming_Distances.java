package com.leetcode.arrays_hashing_greedy;

class Solution3141 {
    public int[] maxHammingDistances(int[] nums, int m) {
        int[] dist = new int[1 << m];
        Arrays.fill(dist, -1);
        Deque<Integer> q = new ArrayDeque<>();
        for (int x : nums) {
            dist[x] = 0;
            q.offer(x);
        }
        for (int k = 1; !q.isEmpty(); ++k) {
            for (int t = q.size(); t > 0; --t) {
                int x = q.poll();
                for (int i = 0; i < m; ++i) {
                    int y = x ^ (1 << i);
                    if (dist[y] == -1) {
                        q.offer(y);
                        dist[y] = k;
                    }
                }
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = m - dist[nums[i] ^ ((1 << m) - 1)];
        }
        return nums;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3141 _tcSol = new Solution3141();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [9,12,9,11], m = 4");
        try {
            int[] nums = new int[]{9, 12, 9, 11};
            int m = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxHammingDistances(nums, m)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3,2,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,4,6,10], m = 4");
        try {
            int[] nums = new int[]{3, 4, 6, 10};
            int m = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxHammingDistances(nums, m)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,3,2,3]");
        System.out.println();
    }
}