package com.leetcode.arrays_hashing_greedy;

class Solution2234 {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        Arrays.sort(flowers);
        int n = flowers.length;
        long[] s = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + flowers[i];
        }
        long ans = 0;
        int x = 0;
        for (int v : flowers) {
            if (v >= target) {
                ++x;
            }
        }
        for (; x <= n; ++x) {
            newFlowers -= (x == 0 ? 0 : Math.max(target - flowers[n - x], 0));
            if (newFlowers < 0) {
                break;
            }
            int l = 0, r = n - x - 1;
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                if ((long) flowers[mid] * (mid + 1) - s[mid + 1] <= newFlowers) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            long y = 0;
            if (r != -1) {
                long cost = (long) flowers[l] * (l + 1) - s[l + 1];
                y = Math.min(flowers[l] + (newFlowers - cost) / (l + 1), target - 1);
            }
            ans = Math.max(ans, (long) x * full + y * partial);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2234 _tcSol = new Solution2234();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "flowers = [1,3,1,1], newFlowers = 7, target = 6, full = 12, partial = 1");
        try {
            int[] flowers = new int[]{1, 3, 1, 1};
            long newFlowers = 7L;
            int target = 6;
            int full = 12;
            int partial = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumBeauty(flowers, newFlowers, target, full, partial)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "14");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "flowers = [2,4,5,3], newFlowers = 10, target = 5, full = 2, partial = 6");
        try {
            int[] flowers = new int[]{2, 4, 5, 3};
            long newFlowers = 10L;
            int target = 5;
            int full = 2;
            int partial = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumBeauty(flowers, newFlowers, target, full, partial)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "30");
        System.out.println();
    }
}