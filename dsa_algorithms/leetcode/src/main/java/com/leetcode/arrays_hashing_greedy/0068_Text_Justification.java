package com.leetcode.arrays_hashing_greedy;

class Solution0068 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        for (int i = 0, n = words.length; i < n;) {
            List<String> t = new ArrayList<>();
            t.add(words[i]);
            int cnt = words[i].length();
            ++i;
            while (i < n && cnt + 1 + words[i].length() <= maxWidth) {
                cnt += 1 + words[i].length();
                t.add(words[i++]);
            }
            if (i == n || t.size() == 1) {
                String left = String.join(" ", t);
                String right = " ".repeat(maxWidth - left.length());
                ans.add(left + right);
                continue;
            }
            int spaceWidth = maxWidth - (cnt - t.size() + 1);
            int w = spaceWidth / (t.size() - 1);
            int m = spaceWidth % (t.size() - 1);
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < t.size() - 1; ++j) {
                row.append(t.get(j));
                row.append(" ".repeat(w + (j < m ? 1 : 0)));
            }
            row.append(t.get(t.size() - 1));
            ans.add(row.toString());
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0068 _tcSol = new Solution0068();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"This\", \"is\", \"an\", \"example\", \"of\", \"text\", \"justification.\"], maxWidth = 16");
        try {
            String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
            int maxWidth = 16;
            System.out.println("  Output  : " + _tcShow(_tcSol.fullJustify(words, maxWidth)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[ \"This is an\", \"example of text\", \"justification. \" ]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"What\",\"must\",\"be\",\"acknowledgment\",\"shall\",\"be\"], maxWidth = 16");
        try {
            String[] words = new String[]{"What", "must", "be", "acknowledgment", "shall", "be"};
            int maxWidth = 16;
            System.out.println("  Output  : " + _tcShow(_tcSol.fullJustify(words, maxWidth)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[ \"What must be\", \"acknowledgment \", \"shall be \" ]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "words = [\"Science\",\"is\",\"what\",\"we\",\"understand\",\"well\",\"enough\",\"to\",\"explain\",\"to\",\"a\",\"computer.\",\"Art\",\"is\",\"everything\",\"else\",\"we\",\"do\"], maxWidth = 20");
        try {
            String[] words = new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
            int maxWidth = 20;
            System.out.println("  Output  : " + _tcShow(_tcSol.fullJustify(words, maxWidth)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[ \"Science is what we\", \"understand well\", \"enough to explain to\", \"a computer. Art is\", \"everything else we\", \"do \" ]");
        System.out.println();
    }
}