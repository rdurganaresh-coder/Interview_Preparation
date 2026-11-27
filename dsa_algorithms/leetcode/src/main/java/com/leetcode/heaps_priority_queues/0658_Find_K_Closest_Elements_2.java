package com.leetcode.heaps_priority_queues;

class Solution0658_2 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length;
        while (r - l > k) {
            if (x - arr[l] <= arr[r - 1] - x) {
                --r;
            } else {
                ++l;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = l; i < r; ++i) {
            ans.add(arr[i]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0658_2 _tcSol = new Solution0658_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [1,2,3,4,5], k = 4, x = 3");
        try {
            int[] arr = new int[]{1, 2, 3, 4, 5};
            int k = 4;
            int x = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.findClosestElements(arr, k, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,3,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,1,2,3,4,5], k = 4, x = -1");
        try {
            int[] arr = new int[]{1, 1, 2, 3, 4, 5};
            int k = 4;
            int x = -1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findClosestElements(arr, k, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1,2,3]");
        System.out.println();
    }
}