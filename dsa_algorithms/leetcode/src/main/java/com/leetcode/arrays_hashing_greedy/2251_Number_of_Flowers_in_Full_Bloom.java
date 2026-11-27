package com.leetcode.arrays_hashing_greedy;

class Solution2251 {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; ++i) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int m = people.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; ++i) {
            ans[i] = search(start, people[i] + 1) - search(end, people[i]);
        }
        return ans;
    }

    private int search(int[] nums, int x) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= x) {
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
        Solution2251 _tcSol = new Solution2251();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "flowers = [[1,6],[3,7],[9,12],[4,13]], people = [2,3,7,11]");
        try {
            int[][] flowers = new int[][]{new int[]{1, 6}, new int[]{3, 7}, new int[]{9, 12}, new int[]{4, 13}};
            int[] people = new int[]{2, 3, 7, 11};
            System.out.println("  Output  : " + _tcShow(_tcSol.fullBloomFlowers(flowers, people)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,2,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "flowers = [[1,10],[3,3]], people = [3,3,2]");
        try {
            int[][] flowers = new int[][]{new int[]{1, 10}, new int[]{3, 3}};
            int[] people = new int[]{3, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.fullBloomFlowers(flowers, people)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,2,1]");
        System.out.println();
    }
}