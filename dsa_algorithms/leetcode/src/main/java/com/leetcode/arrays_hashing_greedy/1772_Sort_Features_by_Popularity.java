package com.leetcode.arrays_hashing_greedy;

class Solution1772 {
    public String[] sortFeatures(String[] features, String[] responses) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String s : responses) {
            Set<String> vis = new HashSet<>();
            for (String w : s.split(" ")) {
                if (vis.add(w)) {
                    cnt.merge(w, 1, Integer::sum);
                }
            }
        }
        int n = features.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> {
            int x = cnt.getOrDefault(features[i], 0);
            int y = cnt.getOrDefault(features[j], 0);
            return x == y ? i - j : y - x;
        });
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[i] = features[idx[i]];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1772 _tcSol = new Solution1772();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "features = [\"cooler\",\"lock\",\"touch\"], responses = [\"i like cooler cooler\",\"lock touch cool\",\"locker like touch\"]");
        try {
            String[] features = new String[]{"cooler", "lock", "touch"};
            String[] responses = new String[]{"i like cooler cooler", "lock touch cool", "locker like touch"};
            System.out.println("  Output  : " + _tcShow(_tcSol.sortFeatures(features, responses)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"touch\",\"cooler\",\"lock\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "features = [\"a\",\"aa\",\"b\",\"c\"], responses = [\"a\",\"a aa\",\"a a a a a\",\"b a\"]");
        try {
            String[] features = new String[]{"a", "aa", "b", "c"};
            String[] responses = new String[]{"a", "a aa", "a a a a a", "b a"};
            System.out.println("  Output  : " + _tcShow(_tcSol.sortFeatures(features, responses)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"a\",\"aa\",\"b\",\"c\"]");
        System.out.println();
    }
}