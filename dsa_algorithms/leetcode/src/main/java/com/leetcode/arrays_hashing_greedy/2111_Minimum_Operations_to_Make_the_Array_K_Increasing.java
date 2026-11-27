package com.leetcode.arrays_hashing_greedy;

class Solution2111 {
    public int kIncreasing(int[] arr, int k) {
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < k; ++i) {
            List<Integer> t = new ArrayList<>();
            for (int j = i; j < n; j += k) {
                t.add(arr[j]);
            }
            ans += lis(t);
        }
        return ans;
    }

    private int lis(List<Integer> arr) {
        List<Integer> t = new ArrayList<>();
        for (int x : arr) {
            int idx = searchRight(t, x);
            if (idx == t.size()) {
                t.add(x);
            } else {
                t.set(idx, x);
            }
        }
        return arr.size() - t.size();
    }

    private int searchRight(List<Integer> arr, int x) {
        int left = 0, right = arr.size();
        while (left < right) {
            int mid = (left + right) >> 1;
            if (arr.get(mid) > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2111 _tcSol = new Solution2111();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [5,4,3,2,1], k = 1");
        try {
            int[] arr = new int[]{5, 4, 3, 2, 1};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.kIncreasing(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [4,1,5,2,6,2], k = 2");
        try {
            int[] arr = new int[]{4, 1, 5, 2, 6, 2};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.kIncreasing(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [4,1,5,2,6,2], k = 3");
        try {
            int[] arr = new int[]{4, 1, 5, 2, 6, 2};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.kIncreasing(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}