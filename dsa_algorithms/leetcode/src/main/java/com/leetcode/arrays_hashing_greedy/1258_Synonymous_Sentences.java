package com.leetcode.arrays_hashing_greedy;

class UnionFind1258 {
    private int[] p;
    private int[] size;

    public UnionFind1258(int n) {
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

    public void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa != pb) {
            if (size[pa] > size[pb]) {
                p[pb] = pa;
                size[pa] += size[pb];
            } else {
                p[pa] = pb;
                size[pb] += size[pa];
            }
        }
    }
}

class Solution1258 {
    private List<String> ans = new ArrayList<>();
    private List<String> t = new ArrayList<>();
    private List<String> words;
    private Map<String, Integer> d;
    private UnionFind1258 uf;
    private List<Integer>[] g;
    private String[] sentence;

    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Set<String> ss = new HashSet<>();
        for (List<String> pairs : synonyms) {
            ss.addAll(pairs);
        }
        words = new ArrayList<>(ss);
        int n = words.size();
        d = new HashMap<>(n);
        for (int i = 0; i < words.size(); ++i) {
            d.put(words.get(i), i);
        }
        uf = new UnionFind1258(n);
        for (List<String> pairs : synonyms) {
            uf.union(d.get(pairs.get(0)), d.get(pairs.get(1)));
        }
        g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 0; i < n; ++i) {
            g[uf.find(i)].add(i);
        }
        for (List<Integer> e : g) {
            e.sort((i, j) -> words.get(i).compareTo(words.get(j)));
        }
        sentence = text.split(" ");
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i >= sentence.length) {
            ans.add(String.join(" ", t));
            return;
        }
        if (!d.containsKey(sentence[i])) {
            t.add(sentence[i]);
            dfs(i + 1);
            t.remove(t.size() - 1);
        } else {
            for (int j : g[uf.find(d.get(sentence[i]))]) {
                t.add(words.get(j));
                dfs(i + 1);
                t.remove(t.size() - 1);
            }
        }
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
        Solution1258 _tcSol = new Solution1258();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "synonyms = [[\"happy\",\"joy\"],[\"sad\",\"sorrow\"],[\"joy\",\"cheerful\"]], text = \"I am happy today but was sad yesterday\"");
        try {
            List<List<String>> synonyms = _tcL(_tcL("happy", "joy"), _tcL("sad", "sorrow"), _tcL("joy", "cheerful"));
            String text = "I am happy today but was sad yesterday";
            System.out.println("  Output  : " + _tcShow(_tcSol.generateSentences(synonyms, text)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"I am cheerful today but was sad yesterday\",\"I am cheerful today but was sorrow yesterday\",\"I am happy today but was sad yesterday\",\"I am happy today but was sorrow yesterday\",\"I am joy today but was sad yesterday\",\"I am joy today but was sorrow yesterday\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "synonyms = [[\"happy\",\"joy\"],[\"cheerful\",\"glad\"]], text = \"I am happy today but was sad yesterday\"");
        try {
            List<List<String>> synonyms = _tcL(_tcL("happy", "joy"), _tcL("cheerful", "glad"));
            String text = "I am happy today but was sad yesterday";
            System.out.println("  Output  : " + _tcShow(_tcSol.generateSentences(synonyms, text)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"I am happy today but was sad yesterday\",\"I am joy today but was sad yesterday\"]");
        System.out.println();
    }
}
