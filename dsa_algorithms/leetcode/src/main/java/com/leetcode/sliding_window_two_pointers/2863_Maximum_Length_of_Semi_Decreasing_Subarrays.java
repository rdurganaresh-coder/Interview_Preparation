package com.leetcode.sliding_window_two_pointers;

class Solution2863 {
    public int maxSubarrayLength(int[] nums) {
        TreeMap<Integer, List<Integer>> d = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < nums.length; ++i) {
            d.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        int ans = 0, k = 1 << 30;
        for (List<Integer> idx : d.values()) {
            ans = Math.max(ans, idx.get(idx.size() - 1) - k + 1);
            k = Math.min(k, idx.get(0));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2863 _tcSol = new Solution2863();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [7,6,5,4,3,2,1,6,10,11]");
        try {
            int[] nums = new int[]{7, 6, 5, 4, 3, 2, 1, 6, 10, 11};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSubarrayLength(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [57,55,50,60,61,58,63,59,64,60,63]");
        try {
            int[] nums = new int[]{57, 55, 50, 60, 61, 58, 63, 59, 64, 60, 63};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSubarrayLength(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3,4]");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSubarrayLength(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}