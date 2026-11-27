package com.leetcode.arrays_hashing_greedy;

class Solution1521 {
    public int closestToTarget(int[] arr, int target) {
        int ans = Math.abs(arr[0] - target);
        Set<Integer> pre = new HashSet<>();
        pre.add(arr[0]);
        for (int x : arr) {
            Set<Integer> cur = new HashSet<>();
            for (int y : pre) {
                cur.add(x & y);
            }
            cur.add(x);
            for (int y : cur) {
                ans = Math.min(ans, Math.abs(y - target));
            }
            pre = cur;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1521 _tcSol = new Solution1521();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [9,12,3,7,15], target = 5");
        try {
            int[] arr = new int[]{9, 12, 3, 7, 15};
            int target = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.closestToTarget(arr, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1000000,1000000,1000000], target = 1");
        try {
            int[] arr = new int[]{1000000, 1000000, 1000000};
            int target = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.closestToTarget(arr, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "999999");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [1,2,4,8,16], target = 0");
        try {
            int[] arr = new int[]{1, 2, 4, 8, 16};
            int target = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.closestToTarget(arr, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}