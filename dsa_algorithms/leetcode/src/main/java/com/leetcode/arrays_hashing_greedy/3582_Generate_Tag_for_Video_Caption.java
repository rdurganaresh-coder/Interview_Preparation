package com.leetcode.arrays_hashing_greedy;

class Solution3582 {
    public String generateTag(String caption) {
        String[] words = caption.trim().split("\\s+");
        StringBuilder sb = new StringBuilder("#");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.isEmpty()) {
                continue;
            }

            word = word.toLowerCase();
            if (i == 0) {
                sb.append(word);
            } else {
                sb.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    sb.append(word.substring(1));
                }
            }

            if (sb.length() >= 100) {
                break;
            }
        }

        return sb.length() > 100 ? sb.substring(0, 100) : sb.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3582 _tcSol = new Solution3582();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "caption = \"Leetcode daily streak achieved\"");
        try {
            String caption = "Leetcode daily streak achieved";
            System.out.println("  Output  : " + _tcShow(_tcSol.generateTag(caption)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"#leetcodeDailyStreakAchieved\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "caption = \"can I Go There\"");
        try {
            String caption = "can I Go There";
            System.out.println("  Output  : " + _tcShow(_tcSol.generateTag(caption)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"#canIGoThere\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "caption = \"hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh\"");
        try {
            String caption = "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh";
            System.out.println("  Output  : " + _tcShow(_tcSol.generateTag(caption)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"#hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh\"");
        System.out.println();
    }
}
