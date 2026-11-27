package com.leetcode.arrays_hashing_greedy;

class Solution1695_2 {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> vis = new HashSet<>();
        int ans = 0, s = 0, i = 0;
        for (int x : nums) {
            while (vis.contains(x)) {
                s -= nums[i];
                vis.remove(nums[i++]);
            }
            vis.add(x);
            s += x;
            ans = Math.max(ans, s);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1695_2 _tcSol = new Solution1695_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,2,4,5,6]");
        try {
            int[] nums = new int[]{4, 2, 4, 5, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumUniqueSubarray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "17");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,2,1,2,5,2,1,2,5]");
        try {
            int[] nums = new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumUniqueSubarray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();
    }
}