package com.leetcode.arrays_hashing_greedy;

class Solution3134 {
    private long m;
    private int[] nums;

    public int medianOfUniquenessArray(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        m = (1L + n) * n / 2;
        int l = 0, r = n;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int mx) {
        Map<Integer, Integer> cnt = new HashMap<>();
        long k = 0;
        for (int l = 0, r = 0; r < nums.length; ++r) {
            int x = nums[r];
            cnt.merge(x, 1, Integer::sum);
            while (cnt.size() > mx) {
                int y = nums[l++];
                if (cnt.merge(y, -1, Integer::sum) == 0) {
                    cnt.remove(y);
                }
            }
            k += r - l + 1;
            if (k >= (m + 1) / 2) {
                return true;
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3134 _tcSol = new Solution3134();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3]");
        try {
            int[] nums = new int[]{1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.medianOfUniquenessArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,4,3,4,5]");
        try {
            int[] nums = new int[]{3, 4, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.medianOfUniquenessArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [4,3,5,4]");
        try {
            int[] nums = new int[]{4, 3, 5, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.medianOfUniquenessArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}