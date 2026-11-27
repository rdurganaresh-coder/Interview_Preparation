package com.leetcode.arrays_hashing_greedy;

class Solution1889 {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        int n = packages.length;
        final long inf = 1L << 62;
        Arrays.sort(packages);
        long ans = inf;
        for (var box : boxes) {
            Arrays.sort(box);
            if (packages[n - 1] > box[box.length - 1]) {
                continue;
            }
            long s = 0;
            int i = 0;
            for (int b : box) {
                int j = search(packages, b, i);
                s += 1L * (j - i) * b;
                i = j;
            }
            ans = Math.min(ans, s);
        }
        if (ans == inf) {
            return -1;
        }
        long s = 0;
        for (int p : packages) {
            s += p;
        }
        final int mod = (int) 1e9 + 7;
        return (int) ((ans - s) % mod);
    }

    private int search(int[] nums, int x, int l) {
        int r = nums.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] > x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1889 _tcSol = new Solution1889();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "packages = [2,3,5], boxes = [[4,8],[2,8]]");
        try {
            int[] packages = new int[]{2, 3, 5};
            int[][] boxes = new int[][]{new int[]{4, 8}, new int[]{2, 8}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minWastedSpace(packages, boxes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "packages = [2,3,5], boxes = [[1,4],[2,3],[3,4]]");
        try {
            int[] packages = new int[]{2, 3, 5};
            int[][] boxes = new int[][]{new int[]{1, 4}, new int[]{2, 3}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minWastedSpace(packages, boxes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "packages = [3,5,8,10,11,12], boxes = [[12],[11,9],[10,5,14]]");
        try {
            int[] packages = new int[]{3, 5, 8, 10, 11, 12};
            int[][] boxes = new int[][]{new int[]{12}, new int[]{11, 9}, new int[]{10, 5, 14}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minWastedSpace(packages, boxes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();
    }
}