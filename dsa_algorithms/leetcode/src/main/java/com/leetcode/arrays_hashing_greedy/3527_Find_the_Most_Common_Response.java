package com.leetcode.arrays_hashing_greedy;

class Solution3527 {
    public String findCommonResponse(List<List<String>> responses) {
        Map<String, Integer> cnt = new HashMap<>();
        for (var ws : responses) {
            Set<String> s = new HashSet<>();
            for (var w : ws) {
                if (s.add(w)) {
                    cnt.merge(w, 1, Integer::sum);
                }
            }
        }
        String ans = responses.get(0).get(0);
        for (var e : cnt.entrySet()) {
            String w = e.getKey();
            int v = e.getValue();
            if (cnt.get(ans) < v || (cnt.get(ans) == v && w.compareTo(ans) < 0)) {
                ans = w;
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
        Solution3527 _tcSol = new Solution3527();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "responses = [[\"good\",\"ok\",\"good\",\"ok\"],[\"ok\",\"bad\",\"good\",\"ok\",\"ok\"],[\"good\"],[\"bad\"]]");
        try {
            List<List<String>> responses = _tcL(_tcL("good", "ok", "good", "ok"), _tcL("ok", "bad", "good", "ok", "ok"), _tcL("good"), _tcL("bad"));
            System.out.println("  Output  : " + _tcShow(_tcSol.findCommonResponse(responses)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"good\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "responses = [[\"good\",\"ok\",\"good\"],[\"ok\",\"bad\"],[\"bad\",\"notsure\"],[\"great\",\"good\"]]");
        try {
            List<List<String>> responses = _tcL(_tcL("good", "ok", "good"), _tcL("ok", "bad"), _tcL("bad", "notsure"), _tcL("great", "good"));
            System.out.println("  Output  : " + _tcShow(_tcSol.findCommonResponse(responses)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"bad\"");
        System.out.println();
    }
}