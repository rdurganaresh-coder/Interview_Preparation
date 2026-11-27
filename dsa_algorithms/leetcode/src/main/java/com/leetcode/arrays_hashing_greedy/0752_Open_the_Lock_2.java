package com.leetcode.arrays_hashing_greedy;

class Solution0752_2 {
    private String start;
    private String target;
    private Set<String> s = new HashSet<>();

    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }
        start = "0000";
        this.target = target;
        for (String d : deadends) {
            s.add(d);
        }
        if (s.contains(start)) {
            return -1;
        }
        return bfs();
    }

    private int bfs() {
        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();
        Deque<String> q1 = new ArrayDeque<>();
        Deque<String> q2 = new ArrayDeque<>();
        m1.put(start, 0);
        m2.put(target, 0);
        q1.offer(start);
        q2.offer(target);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int t = q1.size() <= q2.size() ? extend(m1, m2, q1) : extend(m2, m1, q2);
            if (t != -1) {
                return t;
            }
        }
        return -1;
    }

    private int extend(Map<String, Integer> m1, Map<String, Integer> m2, Deque<String> q) {
        for (int n = q.size(); n > 0; --n) {
            String p = q.poll();
            int step = m1.get(p);
            for (String t : next(p)) {
                if (m1.containsKey(t) || s.contains(t)) {
                    continue;
                }
                if (m2.containsKey(t)) {
                    return step + 1 + m2.get(t);
                }
                m1.put(t, step + 1);
                q.offer(t);
            }
        }
        return -1;
    }

    private List<String> next(String t) {
        List res = new ArrayList<>();
        char[] chars = t.toCharArray();
        for (int i = 0; i < 4; ++i) {
            char c = chars[i];
            chars[i] = c == '0' ? '9' : (char) (c - 1);
            res.add(String.valueOf(chars));
            chars[i] = c == '9' ? '0' : (char) (c + 1);
            res.add(String.valueOf(chars));
            chars[i] = c;
        }
        return res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0752_2 _tcSol = new Solution0752_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "deadends = [\"0201\",\"0101\",\"0102\",\"1212\",\"2002\"], target = \"0202\"");
        try {
            String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
            String target = "0202";
            System.out.println("  Output  : " + _tcShow(_tcSol.openLock(deadends, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "deadends = [\"8888\"], target = \"0009\"");
        try {
            String[] deadends = new String[]{"8888"};
            String target = "0009";
            System.out.println("  Output  : " + _tcShow(_tcSol.openLock(deadends, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "deadends = [\"8887\",\"8889\",\"8878\",\"8898\",\"8788\",\"8988\",\"7888\",\"9888\"], target = \"8888\"");
        try {
            String[] deadends = new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
            String target = "8888";
            System.out.println("  Output  : " + _tcShow(_tcSol.openLock(deadends, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}