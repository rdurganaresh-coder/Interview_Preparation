package com.leetcode.backtracking;

class Solution2638 {
    public long countTheNumOfKFreeSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            g.computeIfAbsent(nums[i] % k, x -> new ArrayList<>()).add(nums[i]);
        }
        long ans = 1;
        for (var arr : g.values()) {
            int m = arr.size();
            long[] f = new long[m + 1];
            f[0] = 1;
            f[1] = 2;
            for (int i = 2; i <= m; ++i) {
                if (arr.get(i - 1) - arr.get(i - 2) == k) {
                    f[i] = f[i - 1] + f[i - 2];
                } else {
                    f[i] = f[i - 1] * 2;
                }
            }
            ans *= f[m];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2638 _tcSol = new Solution2638();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [5,4,6], k = 1");
        try {
            int[] nums = new int[]{5, 4, 6};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.countTheNumOfKFreeSubsets(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,3,5,8], k = 5");
        try {
            int[] nums = new int[]{2, 3, 5, 8};
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.countTheNumOfKFreeSubsets(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [10,5,9,11], k = 20");
        try {
            int[] nums = new int[]{10, 5, 9, 11};
            int k = 20;
            System.out.println("  Output  : " + _tcShow(_tcSol.countTheNumOfKFreeSubsets(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();
    }
}