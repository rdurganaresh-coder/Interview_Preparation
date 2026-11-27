package com.leetcode.arrays_hashing_greedy;

class Solution0969 {
    public List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = n - 1; i > 0; --i) {
            int j = i;
            for (; j > 0 && arr[j] != i + 1; --j)
                ;
            if (j < i) {
                if (j > 0) {
                    ans.add(j + 1);
                    reverse(arr, j);
                }
                ans.add(i + 1);
                reverse(arr, i);
            }
        }
        return ans;
    }

    private void reverse(int[] arr, int j) {
        for (int i = 0; i < j; ++i, --j) {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0969 _tcSol = new Solution0969();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [3,2,4,1]");
        try {
            int[] arr = new int[]{3, 2, 4, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.pancakeSort(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,2,4,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,2,3]");
        try {
            int[] arr = new int[]{1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.pancakeSort(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}