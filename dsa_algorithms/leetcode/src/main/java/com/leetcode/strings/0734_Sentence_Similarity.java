package com.leetcode.strings;

class Solution0734 {
    public boolean areSentencesSimilar(
        String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }
        Set<List<String>> s = new HashSet<>();
        for (var p : similarPairs) {
            s.add(p);
        }
        for (int i = 0; i < sentence1.length; i++) {
            if (!sentence1[i].equals(sentence2[i])
                && !s.contains(List.of(sentence1[i], sentence2[i]))
                && !s.contains(List.of(sentence2[i], sentence1[i]))) {
                return false;
            }
        }
        return true;
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
        Solution0734 _tcSol = new Solution0734();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "sentence1 = [\"great\",\"acting\",\"skills\"], sentence2 = [\"fine\",\"drama\",\"talent\"], similarPairs = [[\"great\",\"fine\"],[\"drama\",\"acting\"],[\"skills\",\"talent\"]]");
        try {
            String[] sentence1 = new String[]{"great", "acting", "skills"};
            String[] sentence2 = new String[]{"fine", "drama", "talent"};
            List<List<String>> similarPairs = _tcL(_tcL("great", "fine"), _tcL("drama", "acting"), _tcL("skills", "talent"));
            System.out.println("  Output  : " + _tcShow(_tcSol.areSentencesSimilar(sentence1, sentence2, similarPairs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "sentence1 = [\"great\"], sentence2 = [\"great\"], similarPairs = []");
        try {
            String[] sentence1 = new String[]{"great"};
            String[] sentence2 = new String[]{"great"};
            List<List<String>> similarPairs = _tcL();
            System.out.println("  Output  : " + _tcShow(_tcSol.areSentencesSimilar(sentence1, sentence2, similarPairs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "sentence1 = [\"great\"], sentence2 = [\"doubleplus\",\"good\"], similarPairs = [[\"great\",\"doubleplus\"]]");
        try {
            String[] sentence1 = new String[]{"great"};
            String[] sentence2 = new String[]{"doubleplus", "good"};
            List<List<String>> similarPairs = _tcL(_tcL("great", "doubleplus"));
            System.out.println("  Output  : " + _tcShow(_tcSol.areSentencesSimilar(sentence1, sentence2, similarPairs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
