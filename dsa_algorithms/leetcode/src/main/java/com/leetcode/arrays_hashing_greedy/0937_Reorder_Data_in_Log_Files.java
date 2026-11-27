package com.leetcode.arrays_hashing_greedy;

class Solution0937 {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);

            boolean isLetter1 = Character.isLetter(split1[1].charAt(0));
            boolean isLetter2 = Character.isLetter(split2[1].charAt(0));

            if (isLetter1 && isLetter2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) {
                    return cmp;
                }
                return split1[0].compareTo(split2[0]);
            }

            return isLetter1 ? -1 : (isLetter2 ? 1 : 0);
        });

        return logs;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0937 _tcSol = new Solution0937();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "logs = [\"dig1 8 1 5 1\",\"let1 art can\",\"dig2 3 6\",\"let2 own kit dig\",\"let3 art zero\"]");
        try {
            String[] logs = new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
            System.out.println("  Output  : " + _tcShow(_tcSol.reorderLogFiles(logs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"let1 art can\",\"let3 art zero\",\"let2 own kit dig\",\"dig1 8 1 5 1\",\"dig2 3 6\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "logs = [\"a1 9 2 3 1\",\"g1 act car\",\"zo4 4 7\",\"ab1 off key dog\",\"a8 act zoo\"]");
        try {
            String[] logs = new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};
            System.out.println("  Output  : " + _tcShow(_tcSol.reorderLogFiles(logs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"g1 act car\",\"a8 act zoo\",\"ab1 off key dog\",\"a1 9 2 3 1\",\"zo4 4 7\"]");
        System.out.println();
    }
}
