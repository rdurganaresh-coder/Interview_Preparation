package com.leetcode.arrays_hashing_greedy;

class Solution2404 {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            if (x % 2 == 0) {
                cnt.merge(x, 1, Integer::sum);
            }
        }
        int ans = -1, mx = 0;
        for (var e : cnt.entrySet()) {
            int x = e.getKey(), v = e.getValue();
            if (mx < v || (mx == v && ans > x)) {
                ans = x;
                mx = v;
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
        Solution2404 _tcSol = new Solution2404();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [0,1,2,2,4,4,1]");
        try {
            int[] nums = new int[]{0, 1, 2, 2, 4, 4, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.mostFrequentEven(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,4,4,9,2,4]");
        try {
            int[] nums = new int[]{4, 4, 4, 9, 2, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.mostFrequentEven(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [29,47,21,41,13,37,25,7]");
        try {
            int[] nums = new int[]{29, 47, 21, 41, 13, 37, 25, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.mostFrequentEven(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}