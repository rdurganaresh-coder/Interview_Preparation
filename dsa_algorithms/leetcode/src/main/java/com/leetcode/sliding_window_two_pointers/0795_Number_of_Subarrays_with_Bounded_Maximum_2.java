package com.leetcode.sliding_window_two_pointers;

class Solution0795_2 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];
        Arrays.fill(l, -1);
        Arrays.fill(r, n);
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            int v = nums[i];
            while (!stk.isEmpty() && nums[stk.peek()] <= v) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                l[i] = stk.peek();
            }
            stk.push(i);
        }
        stk.clear();
        for (int i = n - 1; i >= 0; --i) {
            int v = nums[i];
            while (!stk.isEmpty() && nums[stk.peek()] < v) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                r[i] = stk.peek();
            }
            stk.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (left <= nums[i] && nums[i] <= right) {
                ans += (i - l[i]) * (r[i] - i);
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
        Solution0795_2 _tcSol = new Solution0795_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,1,4,3], left = 2, right = 3");
        try {
            int[] nums = new int[]{2, 1, 4, 3};
            int left = 2;
            int right = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.numSubarrayBoundedMax(nums, left, right)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,9,2,5,6], left = 2, right = 8");
        try {
            int[] nums = new int[]{2, 9, 2, 5, 6};
            int left = 2;
            int right = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.numSubarrayBoundedMax(nums, left, right)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}