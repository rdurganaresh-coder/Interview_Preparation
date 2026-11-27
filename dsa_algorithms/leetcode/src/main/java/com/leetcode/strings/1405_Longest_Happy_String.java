package com.leetcode.strings;

class Solution1405 {
    public String longestDiverseString(int a, int b, int c) {
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        if (a > 0) {
            pq.offer(new int[] {'a', a});
        }
        if (b > 0) {
            pq.offer(new int[] {'b', b});
        }
        if (c > 0) {
            pq.offer(new int[] {'c', c});
        }

        StringBuilder sb = new StringBuilder();
        while (pq.size() > 0) {
            int[] cur = pq.poll();
            int n = sb.length();
            if (n >= 2 && sb.codePointAt(n - 1) == cur[0] && sb.codePointAt(n - 2) == cur[0]) {
                if (pq.size() == 0) {
                    break;
                }
                int[] next = pq.poll();
                sb.append((char) next[0]);
                if (next[1] > 1) {
                    next[1]--;
                    pq.offer(next);
                }
                pq.offer(cur);
            } else {
                sb.append((char) cur[0]);
                if (cur[1] > 1) {
                    cur[1]--;
                    pq.offer(cur);
                }
            }
        }

        return sb.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1405 _tcSol = new Solution1405();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "a = 1, b = 1, c = 7");
        try {
            int a = 1;
            int b = 1;
            int c = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.longestDiverseString(a, b, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"ccaccbcc\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "a = 7, b = 1, c = 0");
        try {
            int a = 7;
            int b = 1;
            int c = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.longestDiverseString(a, b, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aabaa\"");
        System.out.println();
    }
}