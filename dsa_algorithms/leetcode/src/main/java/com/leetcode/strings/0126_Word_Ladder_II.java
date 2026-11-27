package com.leetcode.strings;

class Solution0126 {
    private List<List<String>> ans;
    private Map<String, Set<String>> prev;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        ans = new ArrayList<>();
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return ans;
        }
        words.remove(beginWord);
        Map<String, Integer> dist = new HashMap<>();
        dist.put(beginWord, 0);
        prev = new HashMap<>();
        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        boolean found = false;
        int step = 0;
        while (!q.isEmpty() && !found) {
            ++step;
            for (int i = q.size(); i > 0; --i) {
                String p = q.poll();
                char[] chars = p.toCharArray();
                for (int j = 0; j < chars.length; ++j) {
                    char ch = chars[j];
                    for (char k = 'a'; k <= 'z'; ++k) {
                        chars[j] = k;
                        String t = new String(chars);
                        if (dist.getOrDefault(t, 0) == step) {
                            prev.get(t).add(p);
                        }
                        if (!words.contains(t)) {
                            continue;
                        }
                        prev.computeIfAbsent(t, key -> new HashSet<>()).add(p);
                        words.remove(t);
                        q.offer(t);
                        dist.put(t, step);
                        if (endWord.equals(t)) {
                            found = true;
                        }
                    }
                    chars[j] = ch;
                }
            }
        }
        if (found) {
            Deque<String> path = new ArrayDeque<>();
            path.add(endWord);
            dfs(path, beginWord, endWord);
        }
        return ans;
    }

    private void dfs(Deque<String> path, String beginWord, String cur) {
        if (cur.equals(beginWord)) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (String precursor : prev.get(cur)) {
            path.addFirst(precursor);
            dfs(path, beginWord, precursor);
            path.removeFirst();
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
        Solution0126 _tcSol = new Solution0126();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "beginWord = \"hit\", endWord = \"cog\", wordList = [\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]");
        try {
            String beginWord = "hit";
            String endWord = "cog";
            List<String> wordList = _tcL("hot", "dot", "dog", "lot", "log", "cog");
            System.out.println("  Output  : " + _tcShow(_tcSol.findLadders(beginWord, endWord, wordList)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"hit\",\"hot\",\"dot\",\"dog\",\"cog\"],[\"hit\",\"hot\",\"lot\",\"log\",\"cog\"]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "beginWord = \"hit\", endWord = \"cog\", wordList = [\"hot\",\"dot\",\"dog\",\"lot\",\"log\"]");
        try {
            String beginWord = "hit";
            String endWord = "cog";
            List<String> wordList = _tcL("hot", "dot", "dog", "lot", "log");
            System.out.println("  Output  : " + _tcShow(_tcSol.findLadders(beginWord, endWord, wordList)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}