package com.leetcode.dynamic_programming;

class Solution0594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.merge(x, 1, Integer::sum);
        }
        int ans = 0;
        for (var e : cnt.entrySet()) {
            int x = e.getKey(), c = e.getValue();
            if (cnt.containsKey(x + 1)) {
                ans = Math.max(ans, c + cnt.get(x + 1));
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
        Solution0594 _tcSol = new Solution0594();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,2,2,5,2,3,7]");
        try {
            int[] nums = new int[]{1, 3, 2, 2, 5, 2, 3, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.findLHS(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4]");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.findLHS(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,1,1,1]");
        try {
            int[] nums = new int[]{1, 1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findLHS(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}