package com.leetcode.arrays_hashing_greedy;

class Solution1125 {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> d = new HashMap<>();
        int m = req_skills.length;
        int n = people.size();
        for (int i = 0; i < m; ++i) {
            d.put(req_skills[i], i);
        }
        int[] p = new int[n];
        for (int i = 0; i < n; ++i) {
            for (var s : people.get(i)) {
                p[i] |= 1 << d.get(s);
            }
        }
        int[] f = new int[1 << m];
        int[] g = new int[1 << m];
        int[] h = new int[1 << m];
        final int inf = 1 << 30;
        Arrays.fill(f, inf);
        f[0] = 0;
        for (int i = 0; i < 1 << m; ++i) {
            if (f[i] == inf) {
                continue;
            }
            for (int j = 0; j < n; ++j) {
                if (f[i] + 1 < f[i | p[j]]) {
                    f[i | p[j]] = f[i] + 1;
                    g[i | p[j]] = j;
                    h[i | p[j]] = i;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = (1 << m) - 1; i != 0; i = h[i]) {
            ans.add(g[i]);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
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
        Solution1125 _tcSol = new Solution1125();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "req_skills = [\"java\",\"nodejs\",\"reactjs\"], people = [[\"java\"],[\"nodejs\"],[\"nodejs\",\"reactjs\"]]");
        try {
            String[] req_skills = new String[]{"java", "nodejs", "reactjs"};
            List<List<String>> people = _tcL(_tcL("java"), _tcL("nodejs"), _tcL("nodejs", "reactjs"));
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestSufficientTeam(req_skills, people)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "req_skills = [\"algorithms\",\"math\",\"java\",\"reactjs\",\"csharp\",\"aws\"], people = [[\"algorithms\",\"math\",\"java\"],[\"algorithms\",\"math\",\"reactjs\"],[\"java\",\"csharp\",\"aws\"],[\"reactjs\",\"csharp\"],[\"csharp\",\"math\"],[\"aws\",\"java\"]]");
        try {
            String[] req_skills = new String[]{"algorithms", "math", "java", "reactjs", "csharp", "aws"};
            List<List<String>> people = _tcL(_tcL("algorithms", "math", "java"), _tcL("algorithms", "math", "reactjs"), _tcL("java", "csharp", "aws"), _tcL("reactjs", "csharp"), _tcL("csharp", "math"), _tcL("aws", "java"));
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestSufficientTeam(req_skills, people)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2]");
        System.out.println();
    }
}