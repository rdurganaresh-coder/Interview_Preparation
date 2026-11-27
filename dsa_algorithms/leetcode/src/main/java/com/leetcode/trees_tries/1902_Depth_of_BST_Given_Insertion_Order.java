package com.leetcode.trees_tries;

class Solution1902 {
    public int maxDepthBST(int[] order) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        tm.put(0, 0);
        tm.put(Integer.MAX_VALUE, 0);
        tm.put(order[0], 1);
        int ans = 1;
        for (int i = 1; i < order.length; ++i) {
            int v = order[i];
            Map.Entry<Integer, Integer> lower = tm.lowerEntry(v);
            Map.Entry<Integer, Integer> higher = tm.higherEntry(v);
            int depth = 1 + Math.max(lower.getValue(), higher.getValue());
            ans = Math.max(ans, depth);
            tm.put(v, depth);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1902 _tcSol = new Solution1902();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "order = [2,1,4,3]");
        try {
            int[] order = new int[]{2, 1, 4, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDepthBST(order)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "order = [2,1,3,4]");
        try {
            int[] order = new int[]{2, 1, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDepthBST(order)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "order = [1,2,3,4]");
        try {
            int[] order = new int[]{1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDepthBST(order)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}