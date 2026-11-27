package com.leetcode.design_data_structures;

class Trie1268 {
    Trie1268[] children = new Trie1268[26];
    List<Integer> v = new ArrayList<>();

    public void insert(String w, int i) {
        Trie1268 node = this;
        for (int j = 0; j < w.length(); ++j) {
            int idx = w.charAt(j) - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie1268();
            }
            node = node.children[idx];
            if (node.v.size() < 3) {
                node.v.add(i);
            }
        }
    }

    public List<Integer>[] search(String w) {
        Trie1268 node = this;
        int n = w.length();
        List<Integer>[] ans = new List[n];
        Arrays.setAll(ans, k -> new ArrayList<>());
        for (int i = 0; i < n; ++i) {
            int idx = w.charAt(i) - 'a';
            if (node.children[idx] == null) {
                break;
            }
            node = node.children[idx];
            ans[i] = node.v;
        }
        return ans;
    }
}

class Solution1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        Trie1268 trie = new Trie1268();
        for (int i = 0; i < products.length; ++i) {
            trie.insert(products[i], i);
        }
        List<List<String>> ans = new ArrayList<>();
        for (var v : trie.search(searchWord)) {
            List<String> t = new ArrayList<>();
            for (int i : v) {
                t.add(products[i]);
            }
            ans.add(t);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1268 _tcSol = new Solution1268();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "products = [\"mobile\",\"mouse\",\"moneypot\",\"monitor\",\"mousepad\"], searchWord = \"mouse\"");
        try {
            String[] products = new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"};
            String searchWord = "mouse";
            System.out.println("  Output  : " + _tcShow(_tcSol.suggestedProducts(products, searchWord)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"mobile\",\"moneypot\",\"monitor\"],[\"mobile\",\"moneypot\",\"monitor\"],[\"mouse\",\"mousepad\"],[\"mouse\",\"mousepad\"],[\"mouse\",\"mousepad\"]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "products = [\"havana\"], searchWord = \"havana\"");
        try {
            String[] products = new String[]{"havana"};
            String searchWord = "havana";
            System.out.println("  Output  : " + _tcShow(_tcSol.suggestedProducts(products, searchWord)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"havana\"],[\"havana\"],[\"havana\"],[\"havana\"],[\"havana\"],[\"havana\"]]");
        System.out.println();
    }
}