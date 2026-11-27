package com.leetcode.arrays_hashing_greedy;

class Solution1233 {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> ans = new ArrayList<>();
        ans.add(folder[0]);
        for (int i = 1; i < folder.length; ++i) {
            int m = ans.get(ans.size() - 1).length();
            int n = folder[i].length();
            if (m >= n
                || !(ans.get(ans.size() - 1).equals(folder[i].substring(0, m))
                    && folder[i].charAt(m) == '/')) {
                ans.add(folder[i]);
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1233 _tcSol = new Solution1233();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "folder = [\"/a\",\"/a/b\",\"/c/d\",\"/c/d/e\",\"/c/f\"]");
        try {
            String[] folder = new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
            System.out.println("  Output  : " + _tcShow(_tcSol.removeSubfolders(folder)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"/a\",\"/c/d\",\"/c/f\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "folder = [\"/a\",\"/a/b/c\",\"/a/b/d\"]");
        try {
            String[] folder = new String[]{"/a", "/a/b/c", "/a/b/d"};
            System.out.println("  Output  : " + _tcShow(_tcSol.removeSubfolders(folder)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"/a\"]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "folder = [\"/a/b/c\",\"/a/b/ca\",\"/a/b/d\"]");
        try {
            String[] folder = new String[]{"/a/b/c", "/a/b/ca", "/a/b/d"};
            System.out.println("  Output  : " + _tcShow(_tcSol.removeSubfolders(folder)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"/a/b/c\",\"/a/b/ca\",\"/a/b/d\"]");
        System.out.println();
    }
}