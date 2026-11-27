package com.leetcode.dynamic_programming;

class Solution2155 {
    public List<Integer> maxScoreIndices(int[] nums) {
        int l0 = 0, r1 = Arrays.stream(nums).sum();
        int mx = r1;
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        for (int i = 1; i <= nums.length; ++i) {
            int x = nums[i - 1];
            l0 += x ^ 1;
            r1 -= x;
            int t = l0 + r1;
            if (mx == t) {
                ans.add(i);
            } else if (mx < t) {
                mx = t;
                ans.clear();
                ans.add(i);
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
        Solution2155 _tcSol = new Solution2155();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [0,0,1,0]");
        try {
            int[] nums = new int[]{0, 0, 1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScoreIndices(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,0,0]");
        try {
            int[] nums = new int[]{0, 0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScoreIndices(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,1]");
        try {
            int[] nums = new int[]{1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScoreIndices(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0]");
        System.out.println();
    }
}