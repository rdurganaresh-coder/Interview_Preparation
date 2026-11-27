package com.leetcode.arrays_hashing_greedy;

class Solution1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char ans = keysPressed.charAt(0);
        int mx = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; ++i) {
            int d = releaseTimes[i] - releaseTimes[i - 1];
            if (d > mx || (d == mx && keysPressed.charAt(i) > ans)) {
                mx = d;
                ans = keysPressed.charAt(i);
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
        Solution1629 _tcSol = new Solution1629();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "releaseTimes = [9,29,49,50], keysPressed = \"cbcd\"");
        try {
            int[] releaseTimes = new int[]{9, 29, 49, 50};
            String keysPressed = "cbcd";
            System.out.println("  Output  : " + _tcShow(_tcSol.slowestKey(releaseTimes, keysPressed)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"c\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "releaseTimes = [12,23,36,46,62], keysPressed = \"spuda\"");
        try {
            int[] releaseTimes = new int[]{12, 23, 36, 46, 62};
            String keysPressed = "spuda";
            System.out.println("  Output  : " + _tcShow(_tcSol.slowestKey(releaseTimes, keysPressed)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"a\"");
        System.out.println();
    }
}