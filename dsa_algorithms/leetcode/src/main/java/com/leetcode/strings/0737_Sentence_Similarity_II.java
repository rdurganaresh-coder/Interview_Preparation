package com.leetcode.strings;

class Solution0737 {
    private int[] p;

    public boolean areSentencesSimilarTwo(
        String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }
        int n = similarPairs.size();
        p = new int[n << 1];
        for (int i = 0; i < p.length; ++i) {
            p[i] = i;
        }
        Map<String, Integer> words = new HashMap<>();
        int idx = 0;
        for (List<String> e : similarPairs) {
            String a = e.get(0), b = e.get(1);
            if (!words.containsKey(a)) {
                words.put(a, idx++);
            }
            if (!words.containsKey(b)) {
                words.put(b, idx++);
            }
            p[find(words.get(a))] = find(words.get(b));
        }
        for (int i = 0; i < sentence1.length; ++i) {
            if (Objects.equals(sentence1[i], sentence2[i])) {
                continue;
            }
            if (!words.containsKey(sentence1[i]) || !words.containsKey(sentence2[i])
                || find(words.get(sentence1[i])) != find(words.get(sentence2[i]))) {
                return false;
            }
        }
        return true;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
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
        Solution0737 _tcSol = new Solution0737();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "sentence1 = [\"great\",\"acting\",\"skills\"], sentence2 = [\"fine\",\"drama\",\"talent\"], similarPairs = [[\"great\",\"good\"],[\"fine\",\"good\"],[\"drama\",\"acting\"],[\"skills\",\"talent\"]]");
        try {
            String[] sentence1 = new String[]{"great", "acting", "skills"};
            String[] sentence2 = new String[]{"fine", "drama", "talent"};
            List<List<String>> similarPairs = _tcL(_tcL("great", "good"), _tcL("fine", "good"), _tcL("drama", "acting"), _tcL("skills", "talent"));
            System.out.println("  Output  : " + _tcShow(_tcSol.areSentencesSimilarTwo(sentence1, sentence2, similarPairs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "sentence1 = [\"I\",\"love\",\"leetcode\"], sentence2 = [\"I\",\"love\",\"onepiece\"], similarPairs = [[\"manga\",\"onepiece\"],[\"platform\",\"anime\"],[\"leetcode\",\"platform\"],[\"anime\",\"manga\"]]");
        try {
            String[] sentence1 = new String[]{"I", "love", "leetcode"};
            String[] sentence2 = new String[]{"I", "love", "onepiece"};
            List<List<String>> similarPairs = _tcL(_tcL("manga", "onepiece"), _tcL("platform", "anime"), _tcL("leetcode", "platform"), _tcL("anime", "manga"));
            System.out.println("  Output  : " + _tcShow(_tcSol.areSentencesSimilarTwo(sentence1, sentence2, similarPairs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "sentence1 = [\"I\",\"love\",\"leetcode\"], sentence2 = [\"I\",\"love\",\"onepiece\"], similarPairs = [[\"manga\",\"hunterXhunter\"],[\"platform\",\"anime\"],[\"leetcode\",\"platform\"],[\"anime\",\"manga\"]]");
        try {
            String[] sentence1 = new String[]{"I", "love", "leetcode"};
            String[] sentence2 = new String[]{"I", "love", "onepiece"};
            List<List<String>> similarPairs = _tcL(_tcL("manga", "hunterXhunter"), _tcL("platform", "anime"), _tcL("leetcode", "platform"), _tcL("anime", "manga"));
            System.out.println("  Output  : " + _tcShow(_tcSol.areSentencesSimilarTwo(sentence1, sentence2, similarPairs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}