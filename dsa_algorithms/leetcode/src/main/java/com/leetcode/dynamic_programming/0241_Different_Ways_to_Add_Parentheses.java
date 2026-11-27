package com.leetcode.dynamic_programming;

class Solution0241 {
    private static Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        return dfs(expression);
    }

    private List<Integer> dfs(String exp) {
        if (memo.containsKey(exp)) {
            return memo.get(exp);
        }
        List<Integer> ans = new ArrayList<>();
        if (exp.length() < 3) {
            ans.add(Integer.parseInt(exp));
            return ans;
        }
        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                List<Integer> left = dfs(exp.substring(0, i));
                List<Integer> right = dfs(exp.substring(i + 1));
                for (int a : left) {
                    for (int b : right) {
                        if (c == '-') {
                            ans.add(a - b);
                        } else if (c == '+') {
                            ans.add(a + b);
                        } else {
                            ans.add(a * b);
                        }
                    }
                }
            }
        }
        memo.put(exp, ans);
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0241 _tcSol = new Solution0241();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "expression = \"2-1-1\"");
        try {
            String expression = "2-1-1";
            System.out.println("  Output  : " + _tcShow(_tcSol.diffWaysToCompute(expression)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "expression = \"2*3-4*5\"");
        try {
            String expression = "2*3-4*5";
            System.out.println("  Output  : " + _tcShow(_tcSol.diffWaysToCompute(expression)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-34,-14,-10,-10,10]");
        System.out.println();
    }
}