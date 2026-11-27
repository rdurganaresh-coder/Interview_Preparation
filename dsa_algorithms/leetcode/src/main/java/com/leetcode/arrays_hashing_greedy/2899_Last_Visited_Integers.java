package com.leetcode.arrays_hashing_greedy;

class Solution2899 {
    public List<Integer> lastVisitedIntegers(int[] nums) {
        List<Integer> seen = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int k = 0;
        for (int x : nums) {
            if (x == -1) {
                if (++k > seen.size()) {
                    ans.add(-1);
                } else {
                    ans.add(seen.get(seen.size() - k));
                }
            } else {
                k = 0;
                seen.add(x);
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
        Solution2899 _tcSol = new Solution2899();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,-1,-1,-1]");
        try {
            int[] nums = new int[]{1, 2, -1, -1, -1};
            System.out.println("  Output  : " + _tcShow(_tcSol.lastVisitedIntegers(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,1,-1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,-1,2,-1,-1]");
        try {
            int[] nums = new int[]{1, -1, 2, -1, -1};
            System.out.println("  Output  : " + _tcShow(_tcSol.lastVisitedIntegers(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,1]");
        System.out.println();
    }
}
