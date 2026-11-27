package com.leetcode.arrays_hashing_greedy;

class Solution1096 {
    private TreeSet<String> s = new TreeSet<>();

    public List<String> braceExpansionII(String expression) {
        dfs(expression);
        return new ArrayList<>(s);
    }

    private void dfs(String exp) {
        int j = exp.indexOf('}');
        if (j == -1) {
            s.add(exp);
            return;
        }
        int i = exp.lastIndexOf('{', j);
        String a = exp.substring(0, i);
        String c = exp.substring(j + 1);
        for (String b : exp.substring(i + 1, j).split(",")) {
            dfs(a + b + c);
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1096 _tcSol = new Solution1096();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "expression = \"{a,b}{c,{d,e}}\"");
        try {
            String expression = "{a,b}{c,{d,e}}";
            System.out.println("  Output  : " + _tcShow(_tcSol.braceExpansionII(expression)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"ac\",\"ad\",\"ae\",\"bc\",\"bd\",\"be\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "expression = \"{{a,z},a{b,c},{ab,z}}\"");
        try {
            String expression = "{{a,z},a{b,c},{ab,z}}";
            System.out.println("  Output  : " + _tcShow(_tcSol.braceExpansionII(expression)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"a\",\"ab\",\"ac\",\"z\"]");
        System.out.println();
    }
}