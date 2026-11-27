package com.leetcode.strings;

class Solution0854_2 {
    public int kSimilarity(String s1, String s2) {
        PriorityQueue<Pair<Integer, String>> q
            = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        q.offer(new Pair<>(f(s1, s2), s1));
        Map<String, Integer> dist = new HashMap<>();
        dist.put(s1, 0);
        while (true) {
            String s = q.poll().getValue();
            if (s.equals(s2)) {
                return dist.get(s);
            }
            for (String nxt : next(s, s2)) {
                if (!dist.containsKey(nxt) || dist.get(nxt) > dist.get(s) + 1) {
                    dist.put(nxt, dist.get(s) + 1);
                    q.offer(new Pair<>(dist.get(nxt) + f(nxt, s2), nxt));
                }
            }
        }
    }

    private int f(String s, String s2) {
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != s2.charAt(i)) {
                ++cnt;
            }
        }
        return (cnt + 1) >> 1;
    }

    private List<String> next(String s, String s2) {
        int i = 0, n = s.length();
        char[] cs = s.toCharArray();
        for (; cs[i] == s2.charAt(i); ++i) {
        }

        List<String> res = new ArrayList<>();
        for (int j = i + 1; j < n; ++j) {
            if (cs[j] == s2.charAt(i) && cs[j] != s2.charAt(j)) {
                swap(cs, i, j);
                res.add(new String(cs));
                swap(cs, i, j);
            }
        }
        return res;
    }

    private void swap(char[] cs, int i, int j) {
        char t = cs[i];
        cs[i] = cs[j];
        cs[j] = t;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0854_2 _tcSol = new Solution0854_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s1 = \"ab\", s2 = \"ba\"");
        try {
            String s1 = "ab";
            String s2 = "ba";
            System.out.println("  Output  : " + _tcShow(_tcSol.kSimilarity(s1, s2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s1 = \"abc\", s2 = \"bca\"");
        try {
            String s1 = "abc";
            String s2 = "bca";
            System.out.println("  Output  : " + _tcShow(_tcSol.kSimilarity(s1, s2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}