package com.leetcode.arrays_hashing_greedy;

class Solution0293 {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> ans = new ArrayList<>();
        char[] s = currentState.toCharArray();
        for (int i = 0; i < s.length - 1; ++i) {
            if (s[i] == '+' && s[i + 1] == '+') {
                s[i] = '-';
                s[i + 1] = '-';
                ans.add(new String(s));
                s[i] = '+';
                s[i + 1] = '+';
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
        Solution0293 _tcSol = new Solution0293();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "currentState = \"++++\"");
        try {
            String currentState = "++++";
            System.out.println("  Output  : " + _tcShow(_tcSol.generatePossibleNextMoves(currentState)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"--++\",\"+--+\",\"++--\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "currentState = \"+\"");
        try {
            String currentState = "+";
            System.out.println("  Output  : " + _tcShow(_tcSol.generatePossibleNextMoves(currentState)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}