package com.leetcode.arrays_hashing_greedy;

class Solution3347 {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer, Integer> cnt = new HashMap<>();
        TreeMap<Integer, Integer> d = new TreeMap<>();
        for (int x : nums) {
            cnt.merge(x, 1, Integer::sum);
            d.putIfAbsent(x, 0);
            d.merge(x - k, 1, Integer::sum);
            d.merge(x + k + 1, -1, Integer::sum);
        }
        int ans = 0, s = 0;
        for (var e : d.entrySet()) {
            int x = e.getKey(), t = e.getValue();
            s += t;
            ans = Math.max(ans, Math.min(s, cnt.getOrDefault(x, 0) + numOperations));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3347 _tcSol = new Solution3347();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,4,5], k = 1, numOperations = 2");
        try {
            int[] nums = new int[]{1, 4, 5};
            int k = 1;
            int numOperations = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxFrequency(nums, k, numOperations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,11,20,20], k = 5, numOperations = 1");
        try {
            int[] nums = new int[]{5, 11, 20, 20};
            int k = 5;
            int numOperations = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxFrequency(nums, k, numOperations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
