package com.leetcode.arrays_hashing_greedy;


class Solution0282 {
    private List<String> ans;
    private String num;
    private int target;

    public List<String> addOperators(String num, int target) {
        ans = new ArrayList<>();
        this.num = num;
        this.target = target;
        dfs(0, 0, 0, "");
        return ans;
    }

    private void dfs(int u, long prev, long curr, String path) {
        if (u == num.length()) {
            if (curr == target) ans.add(path);
            return;
        }
        for (int i = u; i < num.length(); i++) {
            if (i != u && num.charAt(u) == '0') {
                break;
            }
            long next = Long.parseLong(num.substring(u, i + 1));
            if (u == 0) {
                dfs(i + 1, next, next, path + next);
            } else {
                dfs(i + 1, next, curr + next, path + "+" + next);
                dfs(i + 1, -next, curr - next, path + "-" + next);
                dfs(i + 1, prev * next, curr - prev + prev * next, path + "*" + next);
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0282 _tcSol = new Solution0282();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = \"123\", target = 6");
        try {
            String num = "123";
            int target = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.addOperators(num, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"1*2*3\",\"1+2+3\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = \"232\", target = 8");
        try {
            String num = "232";
            int target = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.addOperators(num, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"2*3+2\",\"2+3*2\"]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "num = \"3456237490\", target = 9191");
        try {
            String num = "3456237490";
            int target = 9191;
            System.out.println("  Output  : " + _tcShow(_tcSol.addOperators(num, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}