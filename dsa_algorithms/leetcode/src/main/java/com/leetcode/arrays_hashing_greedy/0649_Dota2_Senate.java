package com.leetcode.arrays_hashing_greedy;

class Solution0649 {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Deque<Integer> qr = new ArrayDeque<>();
        Deque<Integer> qd = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') {
                qr.offer(i);
            } else {
                qd.offer(i);
            }
        }
        while (!qr.isEmpty() && !qd.isEmpty()) {
            if (qr.peek() < qd.peek()) {
                qr.offer(qr.peek() + n);
            } else {
                qd.offer(qd.peek() + n);
            }
            qr.poll();
            qd.poll();
        }
        return qr.isEmpty() ? "Dire" : "Radiant";
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0649 _tcSol = new Solution0649();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "senate = \"RD\"");
        try {
            String senate = "RD";
            System.out.println("  Output  : " + _tcShow(_tcSol.predictPartyVictory(senate)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Radiant\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "senate = \"RDD\"");
        try {
            String senate = "RDD";
            System.out.println("  Output  : " + _tcShow(_tcSol.predictPartyVictory(senate)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Dire\"");
        System.out.println();
    }
}