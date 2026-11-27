package com.leetcode.strings;

class Solution3043 {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> s = new HashSet<>();
        for (int x : arr1) {
            for (; x > 0; x /= 10) {
                s.add(x);
            }
        }
        int mx = 0;
        for (int x : arr2) {
            for (; x > 0; x /= 10) {
                if (s.contains(x)) {
                    mx = Math.max(mx, x);
                    break;
                }
            }
        }
        return mx > 0 ? String.valueOf(mx).length() : 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3043 _tcSol = new Solution3043();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr1 = [1,10,100], arr2 = [1000]");
        try {
            int[] arr1 = new int[]{1, 10, 100};
            int[] arr2 = new int[]{1000};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestCommonPrefix(arr1, arr2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr1 = [1,2,3], arr2 = [4,4,4]");
        try {
            int[] arr1 = new int[]{1, 2, 3};
            int[] arr2 = new int[]{4, 4, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestCommonPrefix(arr1, arr2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
