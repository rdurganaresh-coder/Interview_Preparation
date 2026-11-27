package com.leetcode.arrays_hashing_greedy;

class Solution1108 {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1108 _tcSol = new Solution1108();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "address = \"1.1.1.1\"");
        try {
            String address = "1.1.1.1";
            System.out.println("  Output  : " + _tcShow(_tcSol.defangIPaddr(address)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"1[.]1[.]1[.]1\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "address = \"255.100.50.0\"");
        try {
            String address = "255.100.50.0";
            System.out.println("  Output  : " + _tcShow(_tcSol.defangIPaddr(address)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"255[.]100[.]50[.]0\"");
        System.out.println();
    }
}