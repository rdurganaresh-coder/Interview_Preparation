package com.leetcode.arrays_hashing_greedy;

class Trie1233_2 {
    private Map<String, Trie1233_2> children = new HashMap<>();
    private int fid = -1;

    public void insert(int fid, String f) {
        Trie1233_2 node = this;
        String[] ps = f.split("/");
        for (int i = 1; i < ps.length; ++i) {
            String p = ps[i];
            if (!node.children.containsKey(p)) {
                node.children.put(p, new Trie1233_2());
            }
            node = node.children.get(p);
        }
        node.fid = fid;
    }

    public List<Integer> search() {
        List<Integer> ans = new ArrayList<>();
        dfs(this, ans);
        return ans;
    }

    private void dfs(Trie1233_2 root, List<Integer> ans) {
        if (root.fid != -1) {
            ans.add(root.fid);
            return;
        }
        for (var child : root.children.values()) {
            dfs(child, ans);
        }
    }
}

class Solution1233_2 {
    public List<String> removeSubfolders(String[] folder) {
        Trie1233_2 trie = new Trie1233_2();
        for (int i = 0; i < folder.length; ++i) {
            trie.insert(i, folder[i]);
        }
        List<String> ans = new ArrayList<>();
        for (int i : trie.search()) {
            ans.add(folder[i]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1233_2 _tcSol = new Solution1233_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "folder = [\"/a\",\"/a/b\",\"/c/d\",\"/c/d/e\",\"/c/f\"]");
        try {
            String[] folder = new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
            System.out.println("  Output  : " + _tcShow(_tcSol.removeSubfolders(folder)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"/a\",\"/c/d\",\"/c/f\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "folder = [\"/a\",\"/a/b/c\",\"/a/b/d\"]");
        try {
            String[] folder = new String[]{"/a", "/a/b/c", "/a/b/d"};
            System.out.println("  Output  : " + _tcShow(_tcSol.removeSubfolders(folder)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"/a\"]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "folder = [\"/a/b/c\",\"/a/b/ca\",\"/a/b/d\"]");
        try {
            String[] folder = new String[]{"/a/b/c", "/a/b/ca", "/a/b/d"};
            System.out.println("  Output  : " + _tcShow(_tcSol.removeSubfolders(folder)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"/a/b/c\",\"/a/b/ca\",\"/a/b/d\"]");
        System.out.println();
    }
}