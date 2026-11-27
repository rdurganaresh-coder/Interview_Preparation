package com.leetcode.backtracking;

class Solution0090_2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int mask = 0; mask < 1 << n; ++mask) {
            List<Integer> t = new ArrayList<>();
            boolean ok = true;
            for (int i = 0; i < n; ++i) {
                if ((mask >> i & 1) == 1) {
                    if (i > 0 && (mask >> (i - 1) & 1) == 0 && nums[i] == nums[i - 1]) {
                        ok = false;
                        break;
                    }
                    t.add(nums[i]);
                }
            }
            if (ok) {
                ans.add(t);
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
        Solution0090_2 _tcSol = new Solution0090_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,2]");
        try {
            int[] nums = new int[]{1, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.subsetsWithDup(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[],[1],[1,2],[1,2,2],[2],[2,2]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0]");
        try {
            int[] nums = new int[]{0};
            System.out.println("  Output  : " + _tcShow(_tcSol.subsetsWithDup(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[],[0]]");
        System.out.println();
    }
}