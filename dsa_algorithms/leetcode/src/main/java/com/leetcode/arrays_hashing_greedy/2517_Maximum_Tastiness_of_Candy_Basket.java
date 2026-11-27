package com.leetcode.arrays_hashing_greedy;

class Solution2517 {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int l = 0, r = price[price.length - 1] - price[0];
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(price, k, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(int[] price, int k, int x) {
        int cnt = 0, pre = -x;
        for (int cur : price) {
            if (cur - pre >= x) {
                pre = cur;
                ++cnt;
            }
        }
        return cnt >= k;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2517 _tcSol = new Solution2517();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "price = [13,5,1,8,21,2], k = 3");
        try {
            int[] price = new int[]{13, 5, 1, 8, 21, 2};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumTastiness(price, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "price = [1,3,1], k = 2");
        try {
            int[] price = new int[]{1, 3, 1};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumTastiness(price, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "price = [7,7,7,7], k = 2");
        try {
            int[] price = new int[]{7, 7, 7, 7};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumTastiness(price, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}