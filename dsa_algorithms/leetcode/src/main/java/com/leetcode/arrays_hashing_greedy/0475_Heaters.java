package com.leetcode.arrays_hashing_greedy;

class Solution0475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int left = 0, right = (int) 1e9;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (check(houses, heaters, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] houses, int[] heaters, int r) {
        int m = houses.length, n = heaters.length;
        int i = 0, j = 0;
        while (i < m) {
            if (j >= n) {
                return false;
            }
            int mi = heaters[j] - r;
            int mx = heaters[j] + r;
            if (houses[i] < mi) {
                return false;
            }
            if (houses[i] > mx) {
                ++j;
            } else {
                ++i;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0475 _tcSol = new Solution0475();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "houses = [1,2,3], heaters = [2]");
        try {
            int[] houses = new int[]{1, 2, 3};
            int[] heaters = new int[]{2};
            System.out.println("  Output  : " + _tcShow(_tcSol.findRadius(houses, heaters)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "houses = [1,2,3,4], heaters = [1,4]");
        try {
            int[] houses = new int[]{1, 2, 3, 4};
            int[] heaters = new int[]{1, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.findRadius(houses, heaters)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "houses = [1,5], heaters = [2]");
        try {
            int[] houses = new int[]{1, 5};
            int[] heaters = new int[]{2};
            System.out.println("  Output  : " + _tcShow(_tcSol.findRadius(houses, heaters)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
