package com.leetcode.arrays_hashing_greedy;

class Solution3117 {
    private int[] nums;
    private int[] andValues;
    private final int inf = 1 << 29;
    private Map<Long, Integer> f = new HashMap<>();

    public int minimumValueSum(int[] nums, int[] andValues) {
        this.nums = nums;
        this.andValues = andValues;
        int ans = dfs(0, 0, -1);
        return ans >= inf ? -1 : ans;
    }

    private int dfs(int i, int j, int a) {
        if (nums.length - i < andValues.length - j) {
            return inf;
        }
        if (j == andValues.length) {
            return i == nums.length ? 0 : inf;
        }
        a &= nums[i];
        if (a < andValues[j]) {
            return inf;
        }
        long key = (long) i << 36 | (long) j << 32 | a;
        if (f.containsKey(key)) {
            return f.get(key);
        }

        int ans = dfs(i + 1, j, a);
        if (a == andValues[j]) {
            ans = Math.min(ans, dfs(i + 1, j + 1, -1) + nums[i]);
        }
        f.put(key, ans);
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3117 _tcSol = new Solution3117();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,4,3,3,2], andValues = [0,3,3,2]");
        try {
            int[] nums = new int[]{1, 4, 3, 3, 2};
            int[] andValues = new int[]{0, 3, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumValueSum(nums, andValues)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,3,5,7,7,7,5], andValues = [0,7,5]");
        try {
            int[] nums = new int[]{2, 3, 5, 7, 7, 7, 5};
            int[] andValues = new int[]{0, 7, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumValueSum(nums, andValues)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "17");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3,4], andValues = [2]");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            int[] andValues = new int[]{2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumValueSum(nums, andValues)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
