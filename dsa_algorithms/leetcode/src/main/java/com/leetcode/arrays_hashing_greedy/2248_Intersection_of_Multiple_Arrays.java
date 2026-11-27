package com.leetcode.arrays_hashing_greedy;

class Solution2248 {
    public List<Integer> intersection(int[][] nums) {
        int[] cnt = new int[1001];
        for (var arr : nums) {
            for (int x : arr) {
                ++cnt[x];
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int x = 0; x < 1001; ++x) {
            if (cnt[x] == nums.length) {
                ans.add(x);
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
        Solution2248 _tcSol = new Solution2248();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]");
        try {
            int[][] nums = new int[][]{new int[]{3, 1, 2, 4, 5}, new int[]{1, 2, 3, 4}, new int[]{3, 4, 5, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.intersection(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [[1,2,3],[4,5,6]]");
        try {
            int[][] nums = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.intersection(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}