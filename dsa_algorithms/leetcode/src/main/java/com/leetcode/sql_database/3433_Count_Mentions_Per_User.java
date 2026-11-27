package com.leetcode.sql_database;

class Solution3433 {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        events.sort((a, b) -> {
            int x = Integer.parseInt(a.get(1));
            int y = Integer.parseInt(b.get(1));
            if (x == y) {
                return a.get(0).charAt(2) - b.get(0).charAt(2);
            }
            return x - y;
        });
        int[] ans = new int[numberOfUsers];
        int[] onlineT = new int[numberOfUsers];
        int lazy = 0;
        for (var e : events) {
            String etype = e.get(0);
            int cur = Integer.parseInt(e.get(1));
            String s = e.get(2);
            if (etype.charAt(0) == 'O') {
                onlineT[Integer.parseInt(s)] = cur + 60;
            } else if (s.charAt(0) == 'A') {
                ++lazy;
            } else if (s.charAt(0) == 'H') {
                for (int i = 0; i < numberOfUsers; ++i) {
                    if (onlineT[i] <= cur) {
                        ++ans[i];
                    }
                }
            } else {
                for (var a : s.split(" ")) {
                    ++ans[Integer.parseInt(a.substring(2))];
                }
            }
        }
        if (lazy > 0) {
            for (int i = 0; i < numberOfUsers; ++i) {
                ans[i] += lazy;
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
        Solution3433 _tcSol = new Solution3433();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "numberOfUsers = 2, events = [[\"MESSAGE\",\"10\",\"id1 id0\"],[\"OFFLINE\",\"11\",\"0\"],[\"MESSAGE\",\"71\",\"HERE\"]]");
        try {
            int numberOfUsers = 2;
            List<List<String>> events = _tcL(_tcL("MESSAGE", "10", "id1 id0"), _tcL("OFFLINE", "11", "0"), _tcL("MESSAGE", "71", "HERE"));
            System.out.println("  Output  : " + _tcShow(_tcSol.countMentions(numberOfUsers, events)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "numberOfUsers = 2, events = [[\"MESSAGE\",\"10\",\"id1 id0\"],[\"OFFLINE\",\"11\",\"0\"],[\"MESSAGE\",\"12\",\"ALL\"]]");
        try {
            int numberOfUsers = 2;
            List<List<String>> events = _tcL(_tcL("MESSAGE", "10", "id1 id0"), _tcL("OFFLINE", "11", "0"), _tcL("MESSAGE", "12", "ALL"));
            System.out.println("  Output  : " + _tcShow(_tcSol.countMentions(numberOfUsers, events)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,2]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "numberOfUsers = 2, events = [[\"OFFLINE\",\"10\",\"0\"],[\"MESSAGE\",\"12\",\"HERE\"]]");
        try {
            int numberOfUsers = 2;
            List<List<String>> events = _tcL(_tcL("OFFLINE", "10", "0"), _tcL("MESSAGE", "12", "HERE"));
            System.out.println("  Output  : " + _tcShow(_tcSol.countMentions(numberOfUsers, events)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1]");
        System.out.println();
    }
}
