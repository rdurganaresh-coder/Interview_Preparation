package com.leetcode.arrays_hashing_greedy;

class Solution2454 {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        int[][] arr = new int[n][0];
        for (int i = 0; i < n; ++i) {
            arr[i] = new int[] {nums[i], i};
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        TreeSet<Integer> ts = new TreeSet<>();
        for (int[] pair : arr) {
            int i = pair[1];
            Integer j = ts.higher(i);
            if (j != null && ts.higher(j) != null) {
                ans[i] = nums[ts.higher(j)];
            }
            ts.add(i);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2454 _tcSol = new Solution2454();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,4,0,9,6]");
        try {
            int[] nums = new int[]{2, 4, 0, 9, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.secondGreaterElement(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[9,6,6,-1,-1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,3]");
        try {
            int[] nums = new int[]{3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.secondGreaterElement(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,-1]");
        System.out.println();
    }
}