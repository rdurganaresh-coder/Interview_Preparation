package com.leetcode.arrays_hashing_greedy;

class Solution3074 {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int s = 0;
        for (int x : apple) {
            s += x;
        }
        for (int i = 1, n = capacity.length;; ++i) {
            s -= capacity[n - i];
            if (s <= 0) {
                return i;
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3074 _tcSol = new Solution3074();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "apple = [1,3,2], capacity = [4,3,1,5,2]");
        try {
            int[] apple = new int[]{1, 3, 2};
            int[] capacity = new int[]{4, 3, 1, 5, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumBoxes(apple, capacity)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "apple = [5,5,5], capacity = [2,4,2,7]");
        try {
            int[] apple = new int[]{5, 5, 5};
            int[] capacity = new int[]{2, 4, 2, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumBoxes(apple, capacity)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}