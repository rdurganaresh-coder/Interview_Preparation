package com.leetcode.bit_manipulation_math;

class Solution2501_2 {
    private Map<Long, Integer> f = new HashMap<>();
    private Set<Long> s = new HashSet<>();

    public int longestSquareStreak(int[] nums) {
        for (long x : nums) {
            s.add(x);
        }
        int ans = 0;
        for (long x : s) {
            ans = Math.max(ans, dfs(x));
        }
        return ans < 2 ? -1 : ans;
    }

    private int dfs(long x) {
        if (!s.contains(x)) {
            return 0;
        }
        if (f.containsKey(x)) {
            return f.get(x);
        }
        int ans = 1 + dfs(x * x);
        f.put(x, ans);
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2501_2 _tcSol = new Solution2501_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,3,6,16,8,2]");
        try {
            int[] nums = new int[]{4, 3, 6, 16, 8, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestSquareStreak(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,3,5,6,7]");
        try {
            int[] nums = new int[]{2, 3, 5, 6, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestSquareStreak(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}