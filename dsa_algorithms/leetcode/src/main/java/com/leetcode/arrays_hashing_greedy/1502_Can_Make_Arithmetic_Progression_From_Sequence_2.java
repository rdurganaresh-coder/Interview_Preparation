package com.leetcode.arrays_hashing_greedy;

class Solution1502_2 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;
        int a = arr[0], b = arr[0];
        Set<Integer> s = new HashSet<>();
        for (int x : arr) {
            a = Math.min(a, x);
            b = Math.max(b, x);
            s.add(x);
        }
        if ((b - a) % (n - 1) != 0) {
            return false;
        }
        int d = (b - a) / (n - 1);
        for (int i = 0; i < n; ++i) {
            if (!s.contains(a + d * i)) {
                return false;
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
        Solution1502_2 _tcSol = new Solution1502_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [3,5,1]");
        try {
            int[] arr = new int[]{3, 5, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.canMakeArithmeticProgression(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,2,4]");
        try {
            int[] arr = new int[]{1, 2, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.canMakeArithmeticProgression(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}