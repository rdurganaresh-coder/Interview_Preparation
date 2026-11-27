package com.leetcode.arrays_hashing_greedy;

class Solution1087 {
    private List<String> ans;
    private List<String[]> items;

    public String[] expand(String s) {
        ans = new ArrayList<>();
        items = new ArrayList<>();
        convert(s);
        dfs(0, new ArrayList<>());
        Collections.sort(ans);
        return ans.toArray(new String[0]);
    }

    private void convert(String s) {
        if ("".equals(s)) {
            return;
        }
        if (s.charAt(0) == '{') {
            int j = s.indexOf("}");
            items.add(s.substring(1, j).split(","));
            convert(s.substring(j + 1));
        } else {
            int j = s.indexOf("{");
            if (j != -1) {
                items.add(s.substring(0, j).split(","));
                convert(s.substring(j));
            } else {
                items.add(s.split(","));
            }
        }
    }

    private void dfs(int i, List<String> t) {
        if (i == items.size()) {
            ans.add(String.join("", t));
            return;
        }
        for (String c : items.get(i)) {
            t.add(c);
            dfs(i + 1, t);
            t.remove(t.size() - 1);
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1087 _tcSol = new Solution1087();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"{a,b}c{d,e}f\"");
        try {
            String s = "{a,b}c{d,e}f";
            System.out.println("  Output  : " + _tcShow(_tcSol.expand(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"acdf\",\"acef\",\"bcdf\",\"bcef\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abcd\"");
        try {
            String s = "abcd";
            System.out.println("  Output  : " + _tcShow(_tcSol.expand(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"abcd\"]");
        System.out.println();
    }
}