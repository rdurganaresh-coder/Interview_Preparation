package com.leetcode.arrays_hashing_greedy;

class Solution0970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> ans = new HashSet<>();
        for (int a = 1; a <= bound; a *= x) {
            for (int b = 1; a + b <= bound; b *= y) {
                ans.add(a + b);
                if (y == 1) {
                    break;
                }
            }
            if (x == 1) {
                break;
            }
        }
        return new ArrayList<>(ans);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0970 _tcSol = new Solution0970();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "x = 2, y = 3, bound = 10");
        try {
            int x = 2;
            int y = 3;
            int bound = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.powerfulIntegers(x, y, bound)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3,4,5,7,9,10]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "x = 3, y = 5, bound = 15");
        try {
            int x = 3;
            int y = 5;
            int bound = 15;
            System.out.println("  Output  : " + _tcShow(_tcSol.powerfulIntegers(x, y, bound)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,4,6,8,10,14]");
        System.out.println();
    }
}