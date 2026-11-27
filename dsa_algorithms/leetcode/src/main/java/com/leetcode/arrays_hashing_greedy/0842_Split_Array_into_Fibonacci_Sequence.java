package com.leetcode.arrays_hashing_greedy;

class Solution0842 {
    private List<Integer> ans = new ArrayList<>();
    private String num;

    public List<Integer> splitIntoFibonacci(String num) {
        this.num = num;
        dfs(0);
        return ans;
    }

    private boolean dfs(int i) {
        if (i == num.length()) {
            return ans.size() >= 3;
        }
        long x = 0;
        for (int j = i; j < num.length(); ++j) {
            if (j > i && num.charAt(i) == '0') {
                break;
            }
            x = x * 10 + num.charAt(j) - '0';
            if (x > Integer.MAX_VALUE
                || (ans.size() >= 2 && x > ans.get(ans.size() - 1) + ans.get(ans.size() - 2))) {
                break;
            }
            if (ans.size() < 2 || x == ans.get(ans.size() - 1) + ans.get(ans.size() - 2)) {
                ans.add((int) x);
                if (dfs(j + 1)) {
                    return true;
                }
                ans.remove(ans.size() - 1);
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0842 _tcSol = new Solution0842();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = \"1101111\"");
        try {
            String num = "1101111";
            System.out.println("  Output  : " + _tcShow(_tcSol.splitIntoFibonacci(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[11,0,11,11]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = \"112358130\"");
        try {
            String num = "112358130";
            System.out.println("  Output  : " + _tcShow(_tcSol.splitIntoFibonacci(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "num = \"0123\"");
        try {
            String num = "0123";
            System.out.println("  Output  : " + _tcShow(_tcSol.splitIntoFibonacci(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}