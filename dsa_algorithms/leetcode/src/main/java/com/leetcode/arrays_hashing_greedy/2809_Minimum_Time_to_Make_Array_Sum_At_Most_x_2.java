package com.leetcode.arrays_hashing_greedy;

class Solution2809_2 {
    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int n = nums1.size();
        int[] f = new int[n + 1];
        int[][] nums = new int[n][0];
        for (int i = 0; i < n; ++i) {
            nums[i] = new int[] {nums1.get(i), nums2.get(i)};
        }
        Arrays.sort(nums, Comparator.comparingInt(a -> a[1]));
        for (int[] e : nums) {
            int a = e[0], b = e[1];
            for (int j = n; j > 0; --j) {
                f[j] = Math.max(f[j], f[j - 1] + a + b * j);
            }
        }
        int s1 = 0, s2 = 0;
        for (int v : nums1) {
            s1 += v;
        }
        for (int v : nums2) {
            s2 += v;
        }

        for (int j = 0; j <= n; ++j) {
            if (s1 + s2 * j - f[j] <= x) {
                return j;
            }
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution2809_2 _tcSol = new Solution2809_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [1,2,3], nums2 = [1,2,3], x = 4");
        try {
            List<Integer> nums1 = _tcL(1, 2, 3);
            List<Integer> nums2 = _tcL(1, 2, 3);
            int x = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTime(nums1, nums2, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [1,2,3], nums2 = [3,3,3], x = 4");
        try {
            List<Integer> nums1 = _tcL(1, 2, 3);
            List<Integer> nums2 = _tcL(3, 3, 3);
            int x = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTime(nums1, nums2, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}