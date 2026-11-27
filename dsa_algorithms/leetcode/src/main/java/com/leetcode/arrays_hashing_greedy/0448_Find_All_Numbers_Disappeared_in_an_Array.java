package com.leetcode.arrays_hashing_greedy;

class Solution0448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        boolean[] s = new boolean[n + 1];
        for (int x : nums) {
            s[x] = true;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!s[i]) {
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
        Solution0448 _tcSol = new Solution0448();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,3,2,7,8,2,3,1]");
        try {
            int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findDisappearedNumbers(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,6]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1]");
        try {
            int[] nums = new int[]{1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findDisappearedNumbers(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2]");
        System.out.println();
    }
}