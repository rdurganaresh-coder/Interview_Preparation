package com.leetcode.heaps_priority_queues;

class Solution0373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < Math.min(nums1.length, k); ++i) {
            q.offer(new int[] {nums1[i] + nums2[0], i, 0});
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (!q.isEmpty() && k > 0) {
            int[] e = q.poll();
            ans.add(Arrays.asList(nums1[e[1]], nums2[e[2]]));
            --k;
            if (e[2] + 1 < nums2.length) {
                q.offer(new int[] {nums1[e[1]] + nums2[e[2] + 1], e[1], e[2] + 1});
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
        Solution0373 _tcSol = new Solution0373();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [1,7,11], nums2 = [2,4,6], k = 3");
        try {
            int[] nums1 = new int[]{1, 7, 11};
            int[] nums2 = new int[]{2, 4, 6};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.kSmallestPairs(nums1, nums2, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,2],[1,4],[1,6]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [1,1,2], nums2 = [1,2,3], k = 2");
        try {
            int[] nums1 = new int[]{1, 1, 2};
            int[] nums2 = new int[]{1, 2, 3};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.kSmallestPairs(nums1, nums2, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,1],[1,1]]");
        System.out.println();
    }
}