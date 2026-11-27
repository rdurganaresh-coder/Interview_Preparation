package com.leetcode.arrays_hashing_greedy;

class Solution0904_2 {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int j = 0, n = fruits.length;
        for (int x : fruits) {
            cnt.merge(x, 1, Integer::sum);
            if (cnt.size() > 2) {
                int y = fruits[j++];
                if (cnt.merge(y, -1, Integer::sum) == 0) {
                    cnt.remove(y);
                }
            }
        }
        return n - j;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0904_2 _tcSol = new Solution0904_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "fruits = [1,2,1]");
        try {
            int[] fruits = new int[]{1, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.totalFruit(fruits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "fruits = [0,1,2,2]");
        try {
            int[] fruits = new int[]{0, 1, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.totalFruit(fruits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "fruits = [1,2,3,2,2]");
        try {
            int[] fruits = new int[]{1, 2, 3, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.totalFruit(fruits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}