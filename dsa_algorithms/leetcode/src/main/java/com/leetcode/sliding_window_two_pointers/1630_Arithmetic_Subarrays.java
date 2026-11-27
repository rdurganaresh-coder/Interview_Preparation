package com.leetcode.sliding_window_two_pointers;

class Solution1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < l.length; ++i) {
            ans.add(check(nums, l[i], r[i]));
        }
        return ans;
    }

    private boolean check(int[] nums, int l, int r) {
        Set<Integer> s = new HashSet<>();
        int n = r - l + 1;
        int a1 = 1 << 30, an = -a1;
        for (int i = l; i <= r; ++i) {
            s.add(nums[i]);
            a1 = Math.min(a1, nums[i]);
            an = Math.max(an, nums[i]);
        }
        if ((an - a1) % (n - 1) != 0) {
            return false;
        }
        int d = (an - a1) / (n - 1);
        for (int i = 1; i < n; ++i) {
            if (!s.contains(a1 + (i - 1) * d)) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1630 _tcSol = new Solution1630();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]");
        try {
            int[] nums = new int[]{4, 6, 5, 9, 3, 7};
            int[] l = new int[]{0, 0, 2};
            int[] r = new int[]{2, 3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkArithmeticSubarrays(nums, l, r)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[true,false,true]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10], l = [0,1,6,4,8,7], r = [4,4,9,7,9,10]");
        try {
            int[] nums = new int[]{-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10};
            int[] l = new int[]{0, 1, 6, 4, 8, 7};
            int[] r = new int[]{4, 4, 9, 7, 9, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkArithmeticSubarrays(nums, l, r)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[false,true,false,false,true,true]");
        System.out.println();
    }
}