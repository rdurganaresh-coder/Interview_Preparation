package com.leetcode.arrays_hashing_greedy;

class Solution2075 {
    public String decodeCiphertext(String encodedText, int rows) {
        StringBuilder ans = new StringBuilder();
        int cols = encodedText.length() / rows;
        for (int j = 0; j < cols; ++j) {
            for (int x = 0, y = j; x < rows && y < cols; ++x, ++y) {
                ans.append(encodedText.charAt(x * cols + y));
            }
        }
        while (ans.length() > 0 && ans.charAt(ans.length() - 1) == ' ') {
            ans.deleteCharAt(ans.length() - 1);
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2075 _tcSol = new Solution2075();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "encodedText = \"ch ie pr\", rows = 3");
        try {
            String encodedText = "ch ie pr";
            int rows = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.decodeCiphertext(encodedText, rows)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"cipher\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "encodedText = \"iveo eed l te olc\", rows = 4");
        try {
            String encodedText = "iveo eed l te olc";
            int rows = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.decodeCiphertext(encodedText, rows)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"i love leetcode\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "encodedText = \"coding\", rows = 1");
        try {
            String encodedText = "coding";
            int rows = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.decodeCiphertext(encodedText, rows)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"coding\"");
        System.out.println();
    }
}