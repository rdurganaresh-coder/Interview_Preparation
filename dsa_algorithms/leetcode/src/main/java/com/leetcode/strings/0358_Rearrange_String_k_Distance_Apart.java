package com.leetcode.strings;

class Solution0358 {
    public String rearrangeString(String s, int k) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            ++cnt[c - 'a'];
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < cnt.length; ++i) {
            if (cnt[i] > 0) {
                pq.offer(new int[] {cnt[i], i});
            }
        }
        Deque<int[]> q = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            var p = pq.poll();
            p[0] -= 1;
            ans.append((char) ('a' + p[1]));
            q.offerLast(p);
            if (q.size() >= k) {
                p = q.pollFirst();
                if (p[0] > 0) {
                    pq.offer(p);
                }
            }
        }
        return ans.length() < s.length() ? "" : ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0358 _tcSol = new Solution0358();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"aabbcc\", k = 3");
        try {
            String s = "aabbcc";
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.rearrangeString(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"abcabc\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aaabc\", k = 3");
        try {
            String s = "aaabc";
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.rearrangeString(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"aaadbbcc\", k = 2");
        try {
            String s = "aaadbbcc";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.rearrangeString(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"abacabcd\"");
        System.out.println();
    }
}
