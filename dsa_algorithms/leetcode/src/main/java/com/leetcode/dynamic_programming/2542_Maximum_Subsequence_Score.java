package com.leetcode.dynamic_programming;

class Solution2542 {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; ++i) {
            nums[i] = new int[] {nums1[i], nums2[i]};
        }
        Arrays.sort(nums, (a, b) -> b[1] - a[1]);
        long ans = 0, s = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; ++i) {
            s += nums[i][0];
            q.offer(nums[i][0]);
            if (q.size() == k) {
                ans = Math.max(ans, s * nums[i][1]);
                s -= q.poll();
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2542 _tcSol = new Solution2542();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [1,3,3,2], nums2 = [2,1,3,4], k = 3");
        try {
            int[] nums1 = new int[]{1, 3, 3, 2};
            int[] nums2 = new int[]{2, 1, 3, 4};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(nums1, nums2, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [4,2,3,1,1], nums2 = [7,5,10,9,6], k = 1");
        try {
            int[] nums1 = new int[]{4, 2, 3, 1, 1};
            int[] nums2 = new int[]{7, 5, 10, 9, 6};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(nums1, nums2, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "30");
        System.out.println();
    }
}