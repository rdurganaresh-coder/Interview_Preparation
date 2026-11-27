package com.leetcode.arrays_hashing_greedy;

class Solution1346 {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> s = new HashSet<>();
        for (int x : arr) {
            if (s.contains(x * 2) || ((x % 2 == 0 && s.contains(x / 2)))) {
                return true;
            }
            s.add(x);
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1346 _tcSol = new Solution1346();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [10,2,5,3]");
        try {
            int[] arr = new int[]{10, 2, 5, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkIfExist(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [3,1,7,11]");
        try {
            int[] arr = new int[]{3, 1, 7, 11};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkIfExist(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}