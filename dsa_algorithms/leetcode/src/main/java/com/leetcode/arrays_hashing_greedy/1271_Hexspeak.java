package com.leetcode.arrays_hashing_greedy;

class Solution1271 {
    private static final Set<Character> S = Set.of('A', 'B', 'C', 'D', 'E', 'F', 'I', 'O');

    public String toHexspeak(String num) {
        String t
            = Long.toHexString(Long.valueOf(num)).toUpperCase().replace("0", "O").replace("1", "I");
        for (char c : t.toCharArray()) {
            if (!S.contains(c)) {
                return "ERROR";
            }
        }
        return t;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1271 _tcSol = new Solution1271();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = \"257\"");
        try {
            String num = "257";
            System.out.println("  Output  : " + _tcShow(_tcSol.toHexspeak(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"IOI\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = \"3\"");
        try {
            String num = "3";
            System.out.println("  Output  : " + _tcShow(_tcSol.toHexspeak(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"ERROR\"");
        System.out.println();
    }
}