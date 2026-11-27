package com.leetcode.sliding_window_two_pointers;

class Solution0167 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0, n = numbers.length;; ++i) {
            int x = target - numbers[i];
            int l = i + 1, r = n - 1;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (numbers[mid] >= x) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (numbers[l] == x) {
                return new int[] {i + 1, l + 1};
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0167 _tcSol = new Solution0167();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "numbers = [2,7,11,15], target = 9");
        try {
            int[] numbers = new int[]{2, 7, 11, 15};
            int target = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.twoSum(numbers, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "numbers = [2,3,4], target = 6");
        try {
            int[] numbers = new int[]{2, 3, 4};
            int target = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.twoSum(numbers, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,3]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "numbers = [-1,0], target = -1");
        try {
            int[] numbers = new int[]{-1, 0};
            int target = -1;
            System.out.println("  Output  : " + _tcShow(_tcSol.twoSum(numbers, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2]");
        System.out.println();
    }
}