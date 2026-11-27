package com.leetcode.backtracking;

class Solution1452 {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int n = favoriteCompanies.size();
        Map<String, Integer> d = new HashMap<>();
        int idx = 0;
        Set<Integer>[] nums = new Set[n];
        Arrays.setAll(nums, i -> new HashSet<>());
        for (int i = 0; i < n; ++i) {
            var ss = favoriteCompanies.get(i);
            for (var s : ss) {
                if (!d.containsKey(s)) {
                    d.put(s, idx++);
                }
                nums[i].add(d.get(s));
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            boolean ok = true;
            for (int j = 0; j < n && ok; ++j) {
                if (i != j && nums[j].containsAll(nums[i])) {
                    ok = false;
                }
            }
            if (ok) {
                ans.add(i);
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
        Solution1452 _tcSol = new Solution1452();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "favoriteCompanies = [[\"leetcode\",\"google\",\"facebook\"],[\"google\",\"microsoft\"],[\"google\",\"facebook\"],[\"google\"],[\"amazon\"]]");
        try {
            List<List<String>> favoriteCompanies = _tcL(_tcL("leetcode", "google", "facebook"), _tcL("google", "microsoft"), _tcL("google", "facebook"), _tcL("google"), _tcL("amazon"));
            System.out.println("  Output  : " + _tcShow(_tcSol.peopleIndexes(favoriteCompanies)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "favoriteCompanies = [[\"leetcode\",\"google\",\"facebook\"],[\"leetcode\",\"amazon\"],[\"facebook\",\"google\"]]");
        try {
            List<List<String>> favoriteCompanies = _tcL(_tcL("leetcode", "google", "facebook"), _tcL("leetcode", "amazon"), _tcL("facebook", "google"));
            System.out.println("  Output  : " + _tcShow(_tcSol.peopleIndexes(favoriteCompanies)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "favoriteCompanies = [[\"leetcode\"],[\"google\"],[\"facebook\"],[\"amazon\"]]");
        try {
            List<List<String>> favoriteCompanies = _tcL(_tcL("leetcode"), _tcL("google"), _tcL("facebook"), _tcL("amazon"));
            System.out.println("  Output  : " + _tcShow(_tcSol.peopleIndexes(favoriteCompanies)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,2,3]");
        System.out.println();
    }
}
