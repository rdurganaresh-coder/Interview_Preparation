package com.leetcode.heaps_priority_queues;

class Solution0692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String w : words) {
            cnt.merge(w, 1, Integer::sum);
        }
        Arrays.sort(words, (a, b) -> {
            int c1 = cnt.get(a), c2 = cnt.get(b);
            return c1 == c2 ? a.compareTo(b) : c2 - c1;
        });
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length && ans.size() < k; ++i) {
            if (i == 0 || !words[i].equals(words[i - 1])) {
                ans.add(words[i]);
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0692 _tcSol = new Solution0692();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"i\",\"love\",\"leetcode\",\"i\",\"love\",\"coding\"], k = 2");
        try {
            String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.topKFrequent(words, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"i\",\"love\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"the\",\"day\",\"is\",\"sunny\",\"the\",\"the\",\"the\",\"sunny\",\"is\",\"is\"], k = 4");
        try {
            String[] words = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.topKFrequent(words, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"the\",\"is\",\"sunny\",\"day\"]");
        System.out.println();
    }
}
