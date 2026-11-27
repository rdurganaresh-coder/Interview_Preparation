package com.leetcode.arrays_hashing_greedy;

class Solution2103 {
    public int countPoints(String rings) {
        int[] d = new int['Z'];
        d['R'] = 1;
        d['G'] = 2;
        d['B'] = 4;
        int[] mask = new int[10];
        for (int i = 0, n = rings.length(); i < n; i += 2) {
            int c = rings.charAt(i);
            int j = rings.charAt(i + 1) - '0';
            mask[j] |= d[c];
        }
        int ans = 0;
        for (int x : mask) {
            if (x == 7) {
                ++ans;
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
        Solution2103 _tcSol = new Solution2103();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "rings = \"B0B6G0R6R0R6G9\"");
        try {
            String rings = "B0B6G0R6R0R6G9";
            System.out.println("  Output  : " + _tcShow(_tcSol.countPoints(rings)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "rings = \"B0R0G0R9R0B0G0\"");
        try {
            String rings = "B0R0G0R9R0B0G0";
            System.out.println("  Output  : " + _tcShow(_tcSol.countPoints(rings)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "rings = \"G4\"");
        try {
            String rings = "G4";
            System.out.println("  Output  : " + _tcShow(_tcSol.countPoints(rings)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}