package com.leetcode.design_data_structures;

class Solution0609 {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> d = new HashMap<>();
        for (String p : paths) {
            String[] ps = p.split(" ");
            for (int i = 1; i < ps.length; ++i) {
                int j = ps[i].indexOf('(');
                String content = ps[i].substring(j + 1, ps[i].length() - 1);
                String name = ps[0] + '/' + ps[i].substring(0, j);
                d.computeIfAbsent(content, k -> new ArrayList<>()).add(name);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (var e : d.values()) {
            if (e.size() > 1) {
                ans.add(e);
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
        Solution0609 _tcSol = new Solution0609();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "paths = [\"root/a 1.txt(abcd) 2.txt(efgh)\",\"root/c 3.txt(abcd)\",\"root/c/d 4.txt(efgh)\",\"root 4.txt(efgh)\"]");
        try {
            String[] paths = new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
            System.out.println("  Output  : " + _tcShow(_tcSol.findDuplicate(paths)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"root/a/2.txt\",\"root/c/d/4.txt\",\"root/4.txt\"],[\"root/a/1.txt\",\"root/c/3.txt\"]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "paths = [\"root/a 1.txt(abcd) 2.txt(efgh)\",\"root/c 3.txt(abcd)\",\"root/c/d 4.txt(efgh)\"]");
        try {
            String[] paths = new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)"};
            System.out.println("  Output  : " + _tcShow(_tcSol.findDuplicate(paths)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"root/a/2.txt\",\"root/c/d/4.txt\"],[\"root/a/1.txt\",\"root/c/3.txt\"]]");
        System.out.println();
    }
}