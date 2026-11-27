package com.leetcode.sql_database;

class UnionFind0721 {
    private final int[] p;
    private final int[] size;

    public UnionFind0721(int n) {
        p = new int[n];
        size = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public boolean union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) {
            return false;
        }
        if (size[pa] > size[pb]) {
            p[pb] = pa;
            size[pa] += size[pb];
        } else {
            p[pa] = pb;
            size[pb] += size[pa];
        }
        return true;
    }
}

class Solution0721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind0721 uf = new UnionFind0721(n);
        Map<String, Integer> d = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 1; j < accounts.get(i).size(); ++j) {
                String email = accounts.get(i).get(j);
                if (d.containsKey(email)) {
                    uf.union(i, d.get(email));
                } else {
                    d.put(email, i);
                }
            }
        }
        Map<Integer, Set<String>> g = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int root = uf.find(i);
            g.computeIfAbsent(root, k -> new HashSet<>())
                .addAll(accounts.get(i).subList(1, accounts.get(i).size()));
        }
        List<List<String>> ans = new ArrayList<>();
        for (var e : g.entrySet()) {
            List<String> emails = new ArrayList<>(e.getValue());
            Collections.sort(emails);
            ans.add(new ArrayList<>());
            ans.get(ans.size() - 1).add(accounts.get(e.getKey()).get(0));
            ans.get(ans.size() - 1).addAll(emails);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution0721 _tcSol = new Solution0721();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "accounts = [[\"John\",\"johnsmith@mail.com\",\"john_newyork@mail.com\"],[\"John\",\"johnsmith@mail.com\",\"john00@mail.com\"],[\"Mary\",\"mary@mail.com\"],[\"John\",\"johnnybravo@mail.com\"]]");
        try {
            List<List<String>> accounts = _tcL(_tcL("John", "johnsmith@mail.com", "john_newyork@mail.com"), _tcL("John", "johnsmith@mail.com", "john00@mail.com"), _tcL("Mary", "mary@mail.com"), _tcL("John", "johnnybravo@mail.com"));
            System.out.println("  Output  : " + _tcShow(_tcSol.accountsMerge(accounts)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"John\",\"john00@mail.com\",\"john_newyork@mail.com\",\"johnsmith@mail.com\"],[\"Mary\",\"mary@mail.com\"],[\"John\",\"johnnybravo@mail.com\"]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "accounts = [[\"Gabe\",\"Gabe0@m.co\",\"Gabe3@m.co\",\"Gabe1@m.co\"],[\"Kevin\",\"Kevin3@m.co\",\"Kevin5@m.co\",\"Kevin0@m.co\"],[\"Ethan\",\"Ethan5@m.co\",\"Ethan4@m.co\",\"Ethan0@m.co\"],[\"Hanzo\",\"Hanzo3@m.co\",\"Hanzo1@m.co\",\"Hanzo0@m.co\"],[\"Fern\",\"Fern5@m.co\",\"Fern1@m.co\",\"Fern0@m.co\"]]");
        try {
            List<List<String>> accounts = _tcL(_tcL("Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe1@m.co"), _tcL("Kevin", "Kevin3@m.co", "Kevin5@m.co", "Kevin0@m.co"), _tcL("Ethan", "Ethan5@m.co", "Ethan4@m.co", "Ethan0@m.co"), _tcL("Hanzo", "Hanzo3@m.co", "Hanzo1@m.co", "Hanzo0@m.co"), _tcL("Fern", "Fern5@m.co", "Fern1@m.co", "Fern0@m.co"));
            System.out.println("  Output  : " + _tcShow(_tcSol.accountsMerge(accounts)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"Ethan\",\"Ethan0@m.co\",\"Ethan4@m.co\",\"Ethan5@m.co\"],[\"Gabe\",\"Gabe0@m.co\",\"Gabe1@m.co\",\"Gabe3@m.co\"],[\"Hanzo\",\"Hanzo0@m.co\",\"Hanzo1@m.co\",\"Hanzo3@m.co\"],[\"Kevin\",\"Kevin0@m.co\",\"Kevin3@m.co\",\"Kevin5@m.co\"],[\"Fern\",\"Fern0@m.co\",\"Fern1@m.co\",\"Fern5@m.co\"]]");
        System.out.println();
    }
}