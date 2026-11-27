package com.leetcode.sliding_window_two_pointers;

class Solution2607 {
    public long makeSubKSumEqual(int[] arr, int k) {
        int n = arr.length;
        int g = gcd(n, k);
        long ans = 0;
        for (int i = 0; i < g; ++i) {
            List<Integer> t = new ArrayList<>();
            for (int j = i; j < n; j += g) {
                t.add(arr[j]);
            }
            t.sort((a, b) -> a - b);
            int mid = t.get(t.size() >> 1);
            for (int x : t) {
                ans += Math.abs(x - mid);
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2607 _tcSol = new Solution2607();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [1,4,1,3], k = 2");
        try {
            int[] arr = new int[]{1, 4, 1, 3};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.makeSubKSumEqual(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [2,5,5,7], k = 3");
        try {
            int[] arr = new int[]{2, 5, 5, 7};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.makeSubKSumEqual(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}