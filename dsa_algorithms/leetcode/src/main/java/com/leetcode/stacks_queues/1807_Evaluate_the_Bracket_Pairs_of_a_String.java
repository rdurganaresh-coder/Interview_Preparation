package com.leetcode.stacks_queues;

class Solution1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> d = new HashMap<>(knowledge.size());
        for (var e : knowledge) {
            d.put(e.get(0), e.get(1));
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                int j = s.indexOf(')', i + 1);
                ans.append(d.getOrDefault(s.substring(i + 1, j), "?"));
                i = j;
            } else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
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
        Solution1807 _tcSol = new Solution1807();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"(name)is(age)yearsold\", knowledge = [[\"name\",\"bob\"],[\"age\",\"two\"]]");
        try {
            String s = "(name)is(age)yearsold";
            List<List<String>> knowledge = _tcL(_tcL("name", "bob"), _tcL("age", "two"));
            System.out.println("  Output  : " + _tcShow(_tcSol.evaluate(s, knowledge)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"bobistwoyearsold\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"hi(name)\", knowledge = [[\"a\",\"b\"]]");
        try {
            String s = "hi(name)";
            List<List<String>> knowledge = _tcL(_tcL("a", "b"));
            System.out.println("  Output  : " + _tcShow(_tcSol.evaluate(s, knowledge)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"hi?\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"(a)(a)(a)aaa\", knowledge = [[\"a\",\"yes\"]]");
        try {
            String s = "(a)(a)(a)aaa";
            List<List<String>> knowledge = _tcL(_tcL("a", "yes"));
            System.out.println("  Output  : " + _tcShow(_tcSol.evaluate(s, knowledge)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"yesyesyesaaa\"");
        System.out.println();
    }
}