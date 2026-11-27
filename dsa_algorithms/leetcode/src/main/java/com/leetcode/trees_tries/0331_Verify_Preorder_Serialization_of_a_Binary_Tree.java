package com.leetcode.trees_tries;

class Solution0331 {
    public boolean isValidSerialization(String preorder) {
        List<String> stk = new ArrayList<>();
        for (String s : preorder.split(",")) {
            stk.add(s);
            while (stk.size() >= 3 && stk.get(stk.size() - 1).equals("#")
                && stk.get(stk.size() - 2).equals("#") && !stk.get(stk.size() - 3).equals("#")) {
                stk.remove(stk.size() - 1);
                stk.remove(stk.size() - 1);
                stk.remove(stk.size() - 1);
                stk.add("#");
            }
        }
        return stk.size() == 1 && stk.get(0).equals("#");
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0331 _tcSol = new Solution0331();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "preorder = \"9,3,4,#,#,1,#,#,2,#,6,#,#\"");
        try {
            String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
            System.out.println("  Output  : " + _tcShow(_tcSol.isValidSerialization(preorder)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "preorder = \"1,#\"");
        try {
            String preorder = "1,#";
            System.out.println("  Output  : " + _tcShow(_tcSol.isValidSerialization(preorder)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "preorder = \"9,#,#,1\"");
        try {
            String preorder = "9,#,#,1";
            System.out.println("  Output  : " + _tcShow(_tcSol.isValidSerialization(preorder)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}