package com.leetcode.backtracking;

class Trie0212 {
    Trie0212[] children = new Trie0212[26];
    int ref = -1;

    public void insert(String w, int ref) {
        Trie0212 node = this;
        for (int i = 0; i < w.length(); ++i) {
            int j = w.charAt(i) - 'a';
            if (node.children[j] == null) {
                node.children[j] = new Trie0212();
            }
            node = node.children[j];
        }
        node.ref = ref;
    }
}

class Solution0212 {
    private char[][] board;
    private String[] words;
    private List<String> ans = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.words = words;
        Trie0212 tree = new Trie0212();
        for (int i = 0; i < words.length; ++i) {
            tree.insert(words[i], i);
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dfs(tree, i, j);
            }
        }
        return ans;
    }

    private void dfs(Trie0212 node, int i, int j) {
        int idx = board[i][j] - 'a';
        if (node.children[idx] == null) {
            return;
        }
        node = node.children[idx];
        if (node.ref != -1) {
            ans.add(words[node.ref]);
            node.ref = -1;
        }
        char c = board[i][j];
        board[i][j] = '#';
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; ++k) {
            int x = i + dirs[k], y = j + dirs[k + 1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] != '#') {
                dfs(node, x, y);
            }
        }
        board[i][j] = c;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0212 _tcSol = new Solution0212();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "board = [[\"o\",\"a\",\"a\",\"n\"],[\"e\",\"t\",\"a\",\"e\"],[\"i\",\"h\",\"k\",\"r\"],[\"i\",\"f\",\"l\",\"v\"]], words = [\"oath\",\"pea\",\"eat\",\"rain\"]");
        try {
            char[][] board = new char[][]{new char[]{'o', 'a', 'a', 'n'}, new char[]{'e', 't', 'a', 'e'}, new char[]{'i', 'h', 'k', 'r'}, new char[]{'i', 'f', 'l', 'v'}};
            String[] words = new String[]{"oath", "pea", "eat", "rain"};
            System.out.println("  Output  : " + _tcShow(_tcSol.findWords(board, words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"eat\",\"oath\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "board = [[\"a\",\"b\"],[\"c\",\"d\"]], words = [\"abcb\"]");
        try {
            char[][] board = new char[][]{new char[]{'a', 'b'}, new char[]{'c', 'd'}};
            String[] words = new String[]{"abcb"};
            System.out.println("  Output  : " + _tcShow(_tcSol.findWords(board, words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}