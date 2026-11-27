package com.leetcode.strings;

class Solution1239 {
    public int maxLength(List<String> arr) {
        List<Integer> s = new ArrayList<>();
        s.add(0);
        int ans = 0;
        for (var t : arr) {
            int x = 0;
            for (char c : t.toCharArray()) {
                int b = c - 'a';
                if ((x >> b & 1) == 1) {
                    x = 0;
                    break;
                }
                x |= 1 << b;
            }
            if (x > 0) {
                for (int i = s.size() - 1; i >= 0; --i) {
                    int y = s.get(i);
                    if ((x & y) == 0) {
                        s.add(x | y);
                        ans = Math.max(ans, Integer.bitCount(x | y));
                    }
                }
            }
        }
        return ans;
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
        Solution1239 _tcSol = new Solution1239();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [\"un\",\"iq\",\"ue\"]");
        try {
            List<String> arr = _tcL("un", "iq", "ue");
            System.out.println("  Output  : " + _tcShow(_tcSol.maxLength(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [\"cha\",\"r\",\"act\",\"ers\"]");
        try {
            List<String> arr = _tcL("cha", "r", "act", "ers");
            System.out.println("  Output  : " + _tcShow(_tcSol.maxLength(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [\"abcdefghijklmnopqrstuvwxyz\"]");
        try {
            List<String> arr = _tcL("abcdefghijklmnopqrstuvwxyz");
            System.out.println("  Output  : " + _tcShow(_tcSol.maxLength(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "26");
        System.out.println();
    }
}
