package com.leetcode.arrays_hashing_greedy;

class Solution1096_2 {
    private String exp;
    private int i;

    public List<String> braceExpansionII(String expression) {
        exp = expression;
        i = 0;
        List<String> ans = new ArrayList<>(expr());
        Collections.sort(ans);
        return ans;
    }

    private Set<String> expr() {
        Set<String> res = term();
        while (i < exp.length() && exp.charAt(i) == ',') {
            ++i;
            res.addAll(term());
        }
        return res;
    }

    private Set<String> term() {
        Set<String> res = new HashSet<>();
        res.add("");
        while (i < exp.length() && exp.charAt(i) != ',' && exp.charAt(i) != '}') {
            Set<String> cur = new HashSet<>();
            if (exp.charAt(i) == '{') {
                ++i;
                cur = expr();
                ++i;
            } else {
                int j = i + 1;
                while (j < exp.length() && exp.charAt(j) >= 'a' && exp.charAt(j) <= 'z') {
                    ++j;
                }
                cur.add(exp.substring(i, j));
                i = j;
            }
            Set<String> nxt = new HashSet<>();
            for (String a : res) {
                for (String b : cur) {
                    nxt.add(a + b);
                }
            }
            res = nxt;
        }
        return res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1096_2 _tcSol = new Solution1096_2();
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
