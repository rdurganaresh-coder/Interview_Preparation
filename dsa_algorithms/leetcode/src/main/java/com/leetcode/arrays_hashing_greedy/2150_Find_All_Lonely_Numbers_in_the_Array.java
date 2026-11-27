package com.leetcode.arrays_hashing_greedy;

class Solution2150 {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.merge(x, 1, Integer::sum);
        }
        List<Integer> ans = new ArrayList<>();
        for (var e : cnt.entrySet()) {
            int x = e.getKey(), v = e.getValue();
            if (v == 1 && !cnt.containsKey(x - 1) && !cnt.containsKey(x + 1)) {
                ans.add(x);
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
        Solution2150 _tcSol = new Solution2150();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [10,6,5,8]");
        try {
            int[] nums = new int[]{10, 6, 5, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.findLonely(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[10,8]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,3,5,3]");
        try {
            int[] nums = new int[]{1, 3, 5, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.findLonely(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,5]");
        System.out.println();
    }
}