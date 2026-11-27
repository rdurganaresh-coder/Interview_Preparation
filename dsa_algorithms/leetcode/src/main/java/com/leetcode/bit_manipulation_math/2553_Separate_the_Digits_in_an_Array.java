package com.leetcode.bit_manipulation_math;

class Solution2553 {
    public int[] separateDigits(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int x : nums) {
            List<Integer> t = new ArrayList<>();
            for (; x > 0; x /= 10) {
                t.add(x % 10);
            }
            Collections.reverse(t);
            res.addAll(t);
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2553 _tcSol = new Solution2553();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [13,25,83,77]");
        try {
            int[] nums = new int[]{13, 25, 83, 77};
            System.out.println("  Output  : " + _tcShow(_tcSol.separateDigits(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,3,2,5,8,3,7,7]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [7,1,3,9]");
        try {
            int[] nums = new int[]{7, 1, 3, 9};
            System.out.println("  Output  : " + _tcShow(_tcSol.separateDigits(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[7,1,3,9]");
        System.out.println();
    }
}