package com.leetcode.sliding_window_two_pointers;

class Solution3420 {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        long ans = 0;
        long cost = 0;
        int r = n - 1;
        for (int l = n - 1; l >= 0; --l) {
            int x = nums[l];
            while (!q.isEmpty() && nums[q.peekLast()] <= x) {
                int s = q.pollLast();
                int end = q.isEmpty() ? r + 1 : q.peekLast();
                cost += (long) (end - s) * (x - nums[s]);
            }
            q.offerLast(l);
            while (cost > k) {
                cost -= nums[q.peekFirst()] - nums[r];
                if (q.peekFirst() == r) {
                    q.pollFirst();
                }
                --r;
            }
            ans += r - l + 1;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3420 _tcSol = new Solution3420();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [6,3,1,2,4,4], k = 7");
        try {
            int[] nums = new int[]{6, 3, 1, 2, 4, 4};
            int k = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.countNonDecreasingSubarrays(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "17");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [6,3,1,3,6], k = 4");
        try {
            int[] nums = new int[]{6, 3, 1, 3, 6};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.countNonDecreasingSubarrays(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();
    }
}
