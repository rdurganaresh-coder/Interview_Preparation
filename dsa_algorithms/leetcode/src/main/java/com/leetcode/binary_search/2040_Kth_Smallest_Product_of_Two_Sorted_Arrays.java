package com.leetcode.binary_search;

class Solution2040 {
    private int[] nums1;
    private int[] nums2;

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        int m = nums1.length;
        int n = nums2.length;
        int a = Math.max(Math.abs(nums1[0]), Math.abs(nums1[m - 1]));
        int b = Math.max(Math.abs(nums2[0]), Math.abs(nums2[n - 1]));
        long r = (long) a * b;
        long l = (long) -a * b;
        while (l < r) {
            long mid = (l + r) >> 1;
            if (count(mid) >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private long count(long p) {
        long cnt = 0;
        int n = nums2.length;
        for (int x : nums1) {
            if (x > 0) {
                int l = 0, r = n;
                while (l < r) {
                    int mid = (l + r) >> 1;
                    if ((long) x * nums2[mid] > p) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                cnt += l;
            } else if (x < 0) {
                int l = 0, r = n;
                while (l < r) {
                    int mid = (l + r) >> 1;
                    if ((long) x * nums2[mid] <= p) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                cnt += n - l;
            } else if (p >= 0) {
                cnt += n;
            }
        }
        return cnt;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2040 _tcSol = new Solution2040();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [2,5], nums2 = [3,4], k = 2");
        try {
            int[] nums1 = new int[]{2, 5};
            int[] nums2 = new int[]{3, 4};
            long k = 2L;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthSmallestProduct(nums1, nums2, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [-4,-2,0,3], nums2 = [2,4], k = 6");
        try {
            int[] nums1 = new int[]{-4, -2, 0, 3};
            int[] nums2 = new int[]{2, 4};
            long k = 6L;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthSmallestProduct(nums1, nums2, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums1 = [-2,-1,0,1,2], nums2 = [-3,-1,2,4,5], k = 3");
        try {
            int[] nums1 = new int[]{-2, -1, 0, 1, 2};
            int[] nums2 = new int[]{-3, -1, 2, 4, 5};
            long k = 3L;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthSmallestProduct(nums1, nums2, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-6");
        System.out.println();
    }
}