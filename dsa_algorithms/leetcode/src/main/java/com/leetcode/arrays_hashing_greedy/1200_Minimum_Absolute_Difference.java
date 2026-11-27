package com.leetcode.arrays_hashing_greedy;

class Solution1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int mi = 1 << 30;
        for (int i = 0; i < n - 1; ++i) {
            mi = Math.min(mi, arr[i + 1] - arr[i]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n - 1; ++i) {
            if (arr[i + 1] - arr[i] == mi) {
                ans.add(List.of(arr[i], arr[i + 1]));
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
        Solution1200 _tcSol = new Solution1200();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [4,2,1,3]");
        try {
            int[] arr = new int[]{4, 2, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumAbsDifference(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,2],[2,3],[3,4]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,3,6,10,15]");
        try {
            int[] arr = new int[]{1, 3, 6, 10, 15};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumAbsDifference(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,3]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [3,8,-10,23,19,-4,-14,27]");
        try {
            int[] arr = new int[]{3, 8, -10, 23, 19, -4, -14, 27};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumAbsDifference(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[-14,-10],[19,23],[23,27]]");
        System.out.println();
    }
}