package com.leetcode.arrays_hashing_greedy;

class Solution2170 {
    public int minimumOperations(int[] nums) {
        int[] a = f(nums, 0);
        int[] b = f(nums, 1);
        int n = nums.length;
        if (a[0] != b[0]) {
            return n - (a[1] + b[1]);
        }
        return n - Math.max(a[1] + b[3], a[3] + b[1]);
    }

    private int[] f(int[] nums, int i) {
        int k1 = 0, k2 = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (; i < nums.length; i += 2) {
            cnt.merge(nums[i], 1, Integer::sum);
        }
        for (var e : cnt.entrySet()) {
            int k = e.getKey(), v = e.getValue();
            if (cnt.getOrDefault(k1, 0) < v) {
                k2 = k1;
                k1 = k;
            } else if (cnt.getOrDefault(k2, 0) < v) {
                k2 = k;
            }
        }
        return new int[] {k1, cnt.getOrDefault(k1, 0), k2, cnt.getOrDefault(k2, 0)};
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2170 _tcSol = new Solution2170();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,1,3,2,4,3]");
        try {
            int[] nums = new int[]{3, 1, 3, 2, 4, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,2,2,2]");
        try {
            int[] nums = new int[]{1, 2, 2, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
