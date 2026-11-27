package com.leetcode.arrays_hashing_greedy;

class Solution2079 {
    public int wateringPlants(int[] plants, int capacity) {
        int ans = 0, water = capacity;
        for (int i = 0; i < plants.length; ++i) {
            if (water >= plants[i]) {
                water -= plants[i];
                ans += 1;
            } else {
                water = capacity - plants[i];
                ans += i * 2 + 1;
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
        Solution2079 _tcSol = new Solution2079();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "plants = [2,2,3,3], capacity = 5");
        try {
            int[] plants = new int[]{2, 2, 3, 3};
            int capacity = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.wateringPlants(plants, capacity)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "14");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "plants = [1,1,1,4,2,3], capacity = 4");
        try {
            int[] plants = new int[]{1, 1, 1, 4, 2, 3};
            int capacity = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.wateringPlants(plants, capacity)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "30");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "plants = [7,7,7,7,7,7,7], capacity = 8");
        try {
            int[] plants = new int[]{7, 7, 7, 7, 7, 7, 7};
            int capacity = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.wateringPlants(plants, capacity)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "49");
        System.out.println();
    }
}