package com.leetcode.arrays_hashing_greedy;

class Solution2105 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int a = capacityA, b = capacityB;
        int ans = 0;
        int i = 0, j = plants.length - 1;
        for (; i < j; ++i, --j) {
            if (a < plants[i]) {
                ++ans;
                a = capacityA;
            }
            a -= plants[i];
            if (b < plants[j]) {
                ++ans;
                b = capacityB;
            }
            b -= plants[j];
        }
        ans += i == j && Math.max(a, b) < plants[i] ? 1 : 0;
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2105 _tcSol = new Solution2105();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "plants = [2,2,3,3], capacityA = 5, capacityB = 5");
        try {
            int[] plants = new int[]{2, 2, 3, 3};
            int capacityA = 5;
            int capacityB = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumRefill(plants, capacityA, capacityB)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "plants = [2,2,3,3], capacityA = 3, capacityB = 4");
        try {
            int[] plants = new int[]{2, 2, 3, 3};
            int capacityA = 3;
            int capacityB = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumRefill(plants, capacityA, capacityB)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "plants = [5], capacityA = 10, capacityB = 8");
        try {
            int[] plants = new int[]{5};
            int capacityA = 10;
            int capacityB = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumRefill(plants, capacityA, capacityB)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}