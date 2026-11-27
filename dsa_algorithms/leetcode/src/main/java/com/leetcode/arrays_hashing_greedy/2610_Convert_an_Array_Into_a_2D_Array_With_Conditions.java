package com.leetcode.arrays_hashing_greedy;

class Solution2610 {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int[] cnt = new int[n + 1];
        for (int x : nums) {
            ++cnt[x];
        }
        for (int x = 1; x <= n; ++x) {
            int v = cnt[x];
            for (int j = 0; j < v; ++j) {
                if (ans.size() <= j) {
                    ans.add(new ArrayList<>());
                }
                ans.get(j).add(x);
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
        Solution2610 _tcSol = new Solution2610();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,4,1,2,3,1]");
        try {
            int[] nums = new int[]{1, 3, 4, 1, 2, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMatrix(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,3,4,2],[1,3],[1]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4]");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMatrix(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[4,3,2,1]]");
        System.out.println();
    }
}