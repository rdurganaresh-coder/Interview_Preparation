package com.leetcode.arrays_hashing_greedy;

class Solution1815 {
    private Map<Long, Integer> f = new HashMap<>();
    private int size;

    public int maxHappyGroups(int batchSize, int[] groups) {
        size = batchSize;
        int ans = 0;
        long state = 0;
        for (int g : groups) {
            int i = g % size;
            if (i == 0) {
                ++ans;
            } else {
                state += 1l << (i * 5);
            }
        }
        ans += dfs(state, 0);
        return ans;
    }

    private int dfs(long state, int mod) {
        if (f.containsKey(state)) {
            return f.get(state);
        }
        int res = 0;
        for (int i = 1; i < size; ++i) {
            if ((state >> (i * 5) & 31) != 0) {
                int t = dfs(state - (1l << (i * 5)), (mod + i) % size);
                res = Math.max(res, t + (mod == 0 ? 1 : 0));
            }
        }
        f.put(state, res);
        return res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1815 _tcSol = new Solution1815();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "batchSize = 3, groups = [1,2,3,4,5,6]");
        try {
            int batchSize = 3;
            int[] groups = new int[]{1, 2, 3, 4, 5, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxHappyGroups(batchSize, groups)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "batchSize = 4, groups = [1,3,2,5,2,2,1,6]");
        try {
            int batchSize = 4;
            int[] groups = new int[]{1, 3, 2, 5, 2, 2, 1, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxHappyGroups(batchSize, groups)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}