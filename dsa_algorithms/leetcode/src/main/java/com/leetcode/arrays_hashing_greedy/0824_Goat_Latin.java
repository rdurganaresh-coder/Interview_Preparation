package com.leetcode.arrays_hashing_greedy;

class Solution0824 {
    public String toGoatLatin(String sentence) {
        List<String> ans = new ArrayList<>();
        Set<Character> vowels
            = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int i = 1;
        for (String word : sentence.split(" ")) {
            StringBuilder t = new StringBuilder();
            if (!vowels.contains(word.charAt(0))) {
                t.append(word.substring(1));
                t.append(word.charAt(0));
            } else {
                t.append(word);
            }
            t.append("ma");
            for (int j = 0; j < i; ++j) {
                t.append("a");
            }
            ++i;
            ans.add(t.toString());
        }
        return String.join(" ", ans);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0824 _tcSol = new Solution0824();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "sentence = \"I speak Goat Latin\"");
        try {
            String sentence = "I speak Goat Latin";
            System.out.println("  Output  : " + _tcShow(_tcSol.toGoatLatin(sentence)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Imaa peaksmaaa oatGmaaaa atinLmaaaaa\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "sentence = \"The quick brown fox jumped over the lazy dog\"");
        try {
            String sentence = "The quick brown fox jumped over the lazy dog";
            System.out.println("  Output  : " + _tcShow(_tcSol.toGoatLatin(sentence)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa\"");
        System.out.println();
    }
}