package com.leetcode.arrays_hashing_greedy;

class Solution0769_2 {
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> stk = new ArrayDeque<>();
        for (int v : arr) {
            if (stk.isEmpty() || v >= stk.peek()) {
                stk.push(v);
            } else {
                int mx = stk.pop();
                while (!stk.isEmpty() && stk.peek() > v) {
                    stk.pop();
                }
                stk.push(mx);
            }
        }
        return stk.size();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0769_2 _tcSol = new Solution0769_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [4,3,2,1,0]");
        try {
            int[] arr = new int[]{4, 3, 2, 1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxChunksToSorted(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,0,2,3,4]");
        try {
            int[] arr = new int[]{1, 0, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxChunksToSorted(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}