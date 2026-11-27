package com.leetcode.strings;

class Solution2559 {
    private List<Integer> nums = new ArrayList<>();

    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        for (int i = 0; i < words.length; ++i) {
            char a = words[i].charAt(0), b = words[i].charAt(words[i].length() - 1);
            if (vowels.contains(a) && vowels.contains(b)) {
                nums.add(i);
            }
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; ++i) {
            int l = queries[i][0], r = queries[i][1];
            ans[i] = search(r + 1) - search(l);
        }
        return ans;
    }

    private int search(int x) {
        int l = 0, r = nums.size();
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums.get(mid) >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2559 _tcSol = new Solution2559();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"aba\",\"bcb\",\"ece\",\"aa\",\"e\"], queries = [[0,2],[1,4],[1,1]]");
        try {
            String[] words = new String[]{"aba", "bcb", "ece", "aa", "e"};
            int[][] queries = new int[][]{new int[]{0, 2}, new int[]{1, 4}, new int[]{1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.vowelStrings(words, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"a\",\"e\",\"i\"], queries = [[0,2],[0,1],[2,2]]");
        try {
            String[] words = new String[]{"a", "e", "i"};
            int[][] queries = new int[][]{new int[]{0, 2}, new int[]{0, 1}, new int[]{2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.vowelStrings(words, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,2,1]");
        System.out.println();
    }
}