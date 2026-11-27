package com.leetcode.arrays_hashing_greedy;

class Solution2561 {
    public long minCost(int[] basket1, int[] basket2) {
        int n = basket1.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            cnt.merge(basket1[i], 1, Integer::sum);
            cnt.merge(basket2[i], -1, Integer::sum);
        }
        int mi = 1 << 30;
        List<Integer> nums = new ArrayList<>();
        for (var e : cnt.entrySet()) {
            int x = e.getKey(), v = e.getValue();
            if (v % 2 != 0) {
                return -1;
            }
            for (int i = Math.abs(v) / 2; i > 0; --i) {
                nums.add(x);
            }
            mi = Math.min(mi, x);
        }
        Collections.sort(nums);
        int m = nums.size();
        long ans = 0;
        for (int i = 0; i < m / 2; ++i) {
            ans += Math.min(nums.get(i), mi * 2);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2561 _tcSol = new Solution2561();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "basket1 = [4,2,2,2], basket2 = [1,4,1,2]");
        try {
            int[] basket1 = new int[]{4, 2, 2, 2};
            int[] basket2 = new int[]{1, 4, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(basket1, basket2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "basket1 = [2,3,4,1], basket2 = [3,2,5,1]");
        try {
            int[] basket1 = new int[]{2, 3, 4, 1};
            int[] basket2 = new int[]{3, 2, 5, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(basket1, basket2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}