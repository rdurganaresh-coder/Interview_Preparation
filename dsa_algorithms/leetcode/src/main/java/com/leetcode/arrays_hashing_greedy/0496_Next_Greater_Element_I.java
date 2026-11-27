package com.leetcode.arrays_hashing_greedy;

class Solution0496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stk = new ArrayDeque<>();
        int m = nums1.length, n = nums2.length;
        Map<Integer, Integer> d = new HashMap(n);
        for (int i = n - 1; i >= 0; --i) {
            int x = nums2[i];
            while (!stk.isEmpty() && stk.peek() < x) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                d.put(x, stk.peek());
            }
            stk.push(x);
        }
        int[] ans = new int[m];
        for (int i = 0; i < m; ++i) {
            ans[i] = d.getOrDefault(nums1[i], -1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0496 _tcSol = new Solution0496();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [4,1,2], nums2 = [1,3,4,2]");
        try {
            int[] nums1 = new int[]{4, 1, 2};
            int[] nums2 = new int[]{1, 3, 4, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.nextGreaterElement(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,3,-1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [2,4], nums2 = [1,2,3,4]");
        try {
            int[] nums1 = new int[]{2, 4};
            int[] nums2 = new int[]{1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.nextGreaterElement(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,-1]");
        System.out.println();
    }
}
