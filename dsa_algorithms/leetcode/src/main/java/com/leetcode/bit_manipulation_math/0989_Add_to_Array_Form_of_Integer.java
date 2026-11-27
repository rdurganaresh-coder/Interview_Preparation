package com.leetcode.bit_manipulation_math;

class Solution0989 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        for (int i = num.length - 1; i >= 0 || k > 0; --i) {
            k += (i >= 0 ? num[i] : 0);
            ans.add(k % 10);
            k /= 10;
        }
        Collections.reverse(ans);
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0989 _tcSol = new Solution0989();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = [1,2,0,0], k = 34");
        try {
            int[] num = new int[]{1, 2, 0, 0};
            int k = 34;
            System.out.println("  Output  : " + _tcShow(_tcSol.addToArrayForm(num, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,3,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = [2,7,4], k = 181");
        try {
            int[] num = new int[]{2, 7, 4};
            int k = 181;
            System.out.println("  Output  : " + _tcShow(_tcSol.addToArrayForm(num, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,5,5]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "num = [2,1,5], k = 806");
        try {
            int[] num = new int[]{2, 1, 5};
            int k = 806;
            System.out.println("  Output  : " + _tcShow(_tcSol.addToArrayForm(num, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,0,2,1]");
        System.out.println();
    }
}
