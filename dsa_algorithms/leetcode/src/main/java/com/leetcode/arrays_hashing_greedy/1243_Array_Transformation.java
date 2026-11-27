package com.leetcode.arrays_hashing_greedy;

class Solution1243 {
    public List<Integer> transformArray(int[] arr) {
        boolean f = true;
        while (f) {
            f = false;
            int[] t = arr.clone();
            for (int i = 1; i < t.length - 1; ++i) {
                if (t[i] > t[i - 1] && t[i] > t[i + 1]) {
                    --arr[i];
                    f = true;
                }
                if (t[i] < t[i - 1] && t[i] < t[i + 1]) {
                    ++arr[i];
                    f = true;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int x : arr) {
            ans.add(x);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1243 _tcSol = new Solution1243();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [6,2,3,4]");
        try {
            int[] arr = new int[]{6, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.transformArray(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[6,3,3,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,6,3,4,3,5]");
        try {
            int[] arr = new int[]{1, 6, 3, 4, 3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.transformArray(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,4,4,4,4,5]");
        System.out.println();
    }
}