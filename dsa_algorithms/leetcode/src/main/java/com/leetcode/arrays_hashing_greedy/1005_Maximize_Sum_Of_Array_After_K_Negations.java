package com.leetcode.arrays_hashing_greedy;

class Solution1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.merge(x, 1, Integer::sum);
        }
        for (int x = -100; x < 0 && k > 0; ++x) {
            if (cnt.getOrDefault(x, 0) > 0) {
                int m = Math.min(cnt.get(x), k);
                cnt.merge(x, -m, Integer::sum);
                cnt.merge(-x, m, Integer::sum);
                k -= m;
            }
        }
        if ((k & 1) == 1 && cnt.getOrDefault(0, 0) == 0) {
            for (int x = 1; x <= 100; ++x) {
                if (cnt.getOrDefault(x, 0) > 0) {
                    cnt.merge(x, -1, Integer::sum);
                    cnt.merge(-x, 1, Integer::sum);
                    break;
                }
            }
        }
        int ans = 0;
        for (var e : cnt.entrySet()) {
            ans += e.getKey() * e.getValue();
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1005 _tcSol = new Solution1005();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,2,3], k = 1");
        try {
            int[] nums = new int[]{4, 2, 3};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.largestSumAfterKNegations(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,-1,0,2], k = 3");
        try {
            int[] nums = new int[]{3, -1, 0, 2};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.largestSumAfterKNegations(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [2,-3,-1,5,-4], k = 2");
        try {
            int[] nums = new int[]{2, -3, -1, 5, -4};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.largestSumAfterKNegations(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();
    }
}