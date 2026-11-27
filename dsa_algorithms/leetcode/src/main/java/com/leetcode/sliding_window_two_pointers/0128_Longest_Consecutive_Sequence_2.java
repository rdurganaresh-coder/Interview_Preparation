package com.leetcode.sliding_window_two_pointers;

class Solution0128_2 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int x : nums) {
            s.add(x);
        }
        int ans = 0;
        for (int x : s) {
            if (!s.contains(x - 1)) {
                int y = x + 1;
                while (s.contains(y)) {
                    ++y;
                }
                ans = Math.max(ans, y - x);
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
        Solution0128_2 _tcSol = new Solution0128_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [100,4,200,1,3,2]");
        try {
            int[] nums = new int[]{100, 4, 200, 1, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestConsecutive(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,3,7,2,5,8,4,6,0,1]");
        try {
            int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestConsecutive(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,0,1,2]");
        try {
            int[] nums = new int[]{1, 0, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestConsecutive(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
