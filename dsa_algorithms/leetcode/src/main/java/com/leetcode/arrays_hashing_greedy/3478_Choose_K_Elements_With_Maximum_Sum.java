package com.leetcode.arrays_hashing_greedy;

class Solution3478 {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] arr = new int[n][0];
        for (int i = 0; i < n; ++i) {
            arr[i] = new int[] {nums1[i], i};
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long s = 0;
        long[] ans = new long[n];
        int j = 0;
        for (int h = 0; h < n; ++h) {
            int x = arr[h][0], i = arr[h][1];
            while (j < h && arr[j][0] < x) {
                int y = nums2[arr[j][1]];
                pq.offer(y);
                s += y;
                if (pq.size() > k) {
                    s -= pq.poll();
                }
                ++j;
            }
            ans[i] = s;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3478 _tcSol = new Solution3478();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [4,2,1,5,3], nums2 = [10,20,30,40,50], k = 2");
        try {
            int[] nums1 = new int[]{4, 2, 1, 5, 3};
            int[] nums2 = new int[]{10, 20, 30, 40, 50};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaxSum(nums1, nums2, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[80,30,0,80,50]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [2,2,2,2], nums2 = [3,1,2,3], k = 1");
        try {
            int[] nums1 = new int[]{2, 2, 2, 2};
            int[] nums2 = new int[]{3, 1, 2, 3};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaxSum(nums1, nums2, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,0,0,0]");
        System.out.println();
    }
}
