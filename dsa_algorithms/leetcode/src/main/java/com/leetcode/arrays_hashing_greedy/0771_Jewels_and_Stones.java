package com.leetcode.arrays_hashing_greedy;

class Solution0771 {
    public int numJewelsInStones(String jewels, String stones) {
        int[] s = new int[128];
        for (char c : jewels.toCharArray()) {
            s[c] = 1;
        }
        int ans = 0;
        for (char c : stones.toCharArray()) {
            ans += s[c];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0771 _tcSol = new Solution0771();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "jewels = \"aA\", stones = \"aAAbbbb\"");
        try {
            String jewels = "aA";
            String stones = "aAAbbbb";
            System.out.println("  Output  : " + _tcShow(_tcSol.numJewelsInStones(jewels, stones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "jewels = \"z\", stones = \"ZZ\"");
        try {
            String jewels = "z";
            String stones = "ZZ";
            System.out.println("  Output  : " + _tcShow(_tcSol.numJewelsInStones(jewels, stones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}