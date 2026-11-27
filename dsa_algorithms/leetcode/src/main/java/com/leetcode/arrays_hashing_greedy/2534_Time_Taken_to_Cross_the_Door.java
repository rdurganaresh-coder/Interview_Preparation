package com.leetcode.arrays_hashing_greedy;

class Solution2534 {
    public int[] timeTaken(int[] arrival, int[] state) {
        Deque<Integer>[] q = new Deque[2];
        Arrays.setAll(q, i -> new ArrayDeque<>());
        int n = arrival.length;
        int t = 0, i = 0, st = 1;
        int[] ans = new int[n];
        while (i < n || !q[0].isEmpty() || !q[1].isEmpty()) {
            while (i < n && arrival[i] <= t) {
                q[state[i]].add(i++);
            }
            if (!q[0].isEmpty() && !q[1].isEmpty()) {
                ans[q[st].poll()] = t;
            } else if (!q[0].isEmpty() || !q[1].isEmpty()) {
                st = q[0].isEmpty() ? 1 : 0;
                ans[q[st].poll()] = t;
            } else {
                st = 1;
            }
            ++t;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2534 _tcSol = new Solution2534();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arrival = [0,1,1,2,4], state = [0,1,0,0,1]");
        try {
            int[] arrival = new int[]{0, 1, 1, 2, 4};
            int[] state = new int[]{0, 1, 0, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.timeTaken(arrival, state)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,3,1,2,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arrival = [0,0,0], state = [1,0,1]");
        try {
            int[] arrival = new int[]{0, 0, 0};
            int[] state = new int[]{1, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.timeTaken(arrival, state)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,2,1]");
        System.out.println();
    }
}
