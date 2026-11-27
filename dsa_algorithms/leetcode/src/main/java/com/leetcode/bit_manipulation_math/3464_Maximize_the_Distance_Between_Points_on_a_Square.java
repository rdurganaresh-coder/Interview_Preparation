package com.leetcode.bit_manipulation_math;

class Solution3464 {
    private int side;
    private long[] nums;
    private int k;

    public int maxDistance(int side, int[][] points, int k) {
        this.side = side;
        this.k = k;
        int n = points.length;
        this.nums = new long[n];
        for (int i = 0; i < n; i++) {
            int x = points[i][0];
            int y = points[i][1];
            if (x == 0) {
                nums[i] = (long) y;
            } else if (y == side) {
                nums[i] = (long) side + x;
            } else if (x == side) {
                nums[i] = (long) side * 3 - y;
            } else {
                nums[i] = (long) side * 4 - x;
            }
        }
        Arrays.sort(nums);

        int l = 1, r = side;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(int lo) {
        long total = (long) side * 4;
        for (int i = 0; i < nums.length; i++) {
            long start = nums[i];
            long end = start + total - lo;
            long cur = start;
            boolean ok = true;
            for (int j = 0; j < k - 1; j++) {
                long target = cur + lo;
                int idx = lowerBound(nums, target);
                if (idx == nums.length || nums[idx] > end) {
                    ok = false;
                    break;
                }
                cur = nums[idx];
            }
            if (ok) {
                return true;
            }
        }
        return false;
    }

    private int lowerBound(long[] arr, long target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3464 _tcSol = new Solution3464();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "side = 2, points = [[0,2],[2,0],[2,2],[0,0]], k = 4");
        try {
            int side = 2;
            int[][] points = new int[][]{new int[]{0, 2}, new int[]{2, 0}, new int[]{2, 2}, new int[]{0, 0}};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDistance(side, points, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "side = 2, points = [[0,0],[1,2],[2,0],[2,2],[2,1]], k = 4");
        try {
            int side = 2;
            int[][] points = new int[][]{new int[]{0, 0}, new int[]{1, 2}, new int[]{2, 0}, new int[]{2, 2}, new int[]{2, 1}};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDistance(side, points, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "side = 2, points = [[0,0],[0,1],[0,2],[1,2],[2,0],[2,2],[2,1]], k = 5");
        try {
            int side = 2;
            int[][] points = new int[][]{new int[]{0, 0}, new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 2}, new int[]{2, 0}, new int[]{2, 2}, new int[]{2, 1}};
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDistance(side, points, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
