package com.leetcode.arrays_hashing_greedy;

class Solution2766 {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> pos = new HashSet<>();
        for (int x : nums) {
            pos.add(x);
        }
        for (int i = 0; i < moveFrom.length; ++i) {
            pos.remove(moveFrom[i]);
            pos.add(moveTo[i]);
        }
        List<Integer> ans = new ArrayList<>(pos);
        ans.sort((a, b) -> a - b);
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2766 _tcSol = new Solution2766();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,6,7,8], moveFrom = [1,7,2], moveTo = [2,9,5]");
        try {
            int[] nums = new int[]{1, 6, 7, 8};
            int[] moveFrom = new int[]{1, 7, 2};
            int[] moveTo = new int[]{2, 9, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.relocateMarbles(nums, moveFrom, moveTo)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,6,8,9]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,3,3], moveFrom = [1,3], moveTo = [2,2]");
        try {
            int[] nums = new int[]{1, 1, 3, 3};
            int[] moveFrom = new int[]{1, 3};
            int[] moveTo = new int[]{2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.relocateMarbles(nums, moveFrom, moveTo)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2]");
        System.out.println();
    }
}