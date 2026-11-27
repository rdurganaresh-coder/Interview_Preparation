package com.leetcode.arrays_hashing_greedy;

class Solution2288 {
    public String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; ++i) {
            if (check(words[i])) {
                double t = Long.parseLong(words[i].substring(1)) * (1 - discount / 100.0);
                words[i] = String.format("$%.2f", t);
            }
        }
        return String.join(" ", words);
    }

    private boolean check(String s) {
        if (s.charAt(0) != '$' || s.length() == 1) {
            return false;
        }
        for (int i = 1; i < s.length(); ++i) {
            if (!Character.isDigit(s.charAt(i))) {
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

    public static void main(String[] args) {
        Solution2288 _tcSol = new Solution2288();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "sentence = \"there are $1 $2 and 5$ candies in the shop\", discount = 50");
        try {
            String sentence = "there are $1 $2 and 5$ candies in the shop";
            int discount = 50;
            System.out.println("  Output  : " + _tcShow(_tcSol.discountPrices(sentence, discount)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"there are $0.50 $1.00 and 5$ candies in the shop\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "sentence = \"1 2 $3 4 $5 $6 7 8$ $9 $10$\", discount = 100");
        try {
            String sentence = "1 2 $3 4 $5 $6 7 8$ $9 $10$";
            int discount = 100;
            System.out.println("  Output  : " + _tcShow(_tcSol.discountPrices(sentence, discount)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"1 2 $0.00 4 $0.00 $0.00 7 8$ $0.00 $10$\"");
        System.out.println();
    }
}