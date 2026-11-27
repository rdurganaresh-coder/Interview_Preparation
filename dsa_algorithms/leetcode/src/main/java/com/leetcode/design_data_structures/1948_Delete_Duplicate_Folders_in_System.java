package com.leetcode.design_data_structures;

class Trie1948 {
    Map<String, Trie1948> children;
    boolean deleted;

    public Trie1948() {
        children = new HashMap<>();
        deleted = false;
    }
}

class Solution1948 {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Trie1948 root = new Trie1948();
        for (List<String> path : paths) {
            Trie1948 cur = root;
            for (String name : path) {
                if (!cur.children.containsKey(name)) {
                    cur.children.put(name, new Trie1948());
                }
                cur = cur.children.get(name);
            }
        }

        Map<String, Trie1948> g = new HashMap<>();

        var dfs = new Function<Trie1948, String>() {
            @Override
            public String apply(Trie1948 node) {
                if (node.children.isEmpty()) {
                    return "";
                }
                List<String> subs = new ArrayList<>();
                for (var entry : node.children.entrySet()) {
                    subs.add(entry.getKey() + "(" + apply(entry.getValue()) + ")");
                }
                Collections.sort(subs);
                String s = String.join("", subs);
                if (g.containsKey(s)) {
                    node.deleted = true;
                    g.get(s).deleted = true;
                } else {
                    g.put(s, node);
                }
                return s;
            }
        };

        dfs.apply(root);

        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();

        var dfs2 = new Function<Trie1948, Void>() {
            @Override
            public Void apply(Trie1948 node) {
                if (node.deleted) {
                    return null;
                }
                if (!path.isEmpty()) {
                    ans.add(new ArrayList<>(path));
                }
                for (Map.Entry<String, Trie1948> entry : node.children.entrySet()) {
                    path.add(entry.getKey());
                    apply(entry.getValue());
                    path.remove(path.size() - 1);
                }
                return null;
            }
        };

        dfs2.apply(root);

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
        Solution1948 _tcSol = new Solution1948();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "paths = [[\"a\"],[\"c\"],[\"d\"],[\"a\",\"b\"],[\"c\",\"b\"],[\"d\",\"a\"]]");
        try {
            List<List<String>> paths = _tcL(_tcL("a"), _tcL("c"), _tcL("d"), _tcL("a", "b"), _tcL("c", "b"), _tcL("d", "a"));
            System.out.println("  Output  : " + _tcShow(_tcSol.deleteDuplicateFolder(paths)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"d\"],[\"d\",\"a\"]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "paths = [[\"a\"],[\"c\"],[\"a\",\"b\"],[\"c\",\"b\"],[\"a\",\"b\",\"x\"],[\"a\",\"b\",\"x\",\"y\"],[\"w\"],[\"w\",\"y\"]]");
        try {
            List<List<String>> paths = _tcL(_tcL("a"), _tcL("c"), _tcL("a", "b"), _tcL("c", "b"), _tcL("a", "b", "x"), _tcL("a", "b", "x", "y"), _tcL("w"), _tcL("w", "y"));
            System.out.println("  Output  : " + _tcShow(_tcSol.deleteDuplicateFolder(paths)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"c\"],[\"c\",\"b\"],[\"a\"],[\"a\",\"b\"]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "paths = [[\"a\",\"b\"],[\"c\",\"d\"],[\"c\"],[\"a\"]]");
        try {
            List<List<String>> paths = _tcL(_tcL("a", "b"), _tcL("c", "d"), _tcL("c"), _tcL("a"));
            System.out.println("  Output  : " + _tcShow(_tcSol.deleteDuplicateFolder(paths)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"c\"],[\"c\",\"d\"],[\"a\"],[\"a\",\"b\"]]");
        System.out.println();
    }
}
