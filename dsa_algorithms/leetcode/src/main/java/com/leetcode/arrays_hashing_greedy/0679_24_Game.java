package com.leetcode.arrays_hashing_greedy;

class Solution0679 {
    private final char[] ops = {'+', '-', '*', '/'};

    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int num : cards) {
            nums.add((double) num);
        }
        return dfs(nums);
    }

    private boolean dfs(List<Double> nums) {
        int n = nums.size();
        if (n == 1) {
            return Math.abs(nums.get(0) - 24) < 1e-6;
        }
        boolean ok = false;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i != j) {
                    List<Double> nxt = new ArrayList<>();
                    for (int k = 0; k < n; ++k) {
                        if (k != i && k != j) {
                            nxt.add(nums.get(k));
                        }
                    }
                    for (char op : ops) {
                        switch (op) {
                            case '/' -> {
                                if (nums.get(j) == 0) {
                                    continue;
                                }
                                nxt.add(nums.get(i) / nums.get(j));
                            }
                            case '*' -> {
                                nxt.add(nums.get(i) * nums.get(j));
                            }
                            case '+' -> {
                                nxt.add(nums.get(i) + nums.get(j));
                            }
                            case '-' -> {
                                nxt.add(nums.get(i) - nums.get(j));
                            }
                        }
                        ok |= dfs(nxt);
                        if (ok) {
                            return true;
                        }
                        nxt.remove(nxt.size() - 1);
                    }
                }
            }
        }
        return ok;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0679 _tcSol = new Solution0679();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "cards = [4,1,8,7]");
        try {
            int[] cards = new int[]{4, 1, 8, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.judgePoint24(cards)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "cards = [1,2,1,2]");
        try {
            int[] cards = new int[]{1, 2, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.judgePoint24(cards)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}