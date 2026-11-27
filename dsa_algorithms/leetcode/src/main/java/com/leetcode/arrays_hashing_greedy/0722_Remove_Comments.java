package com.leetcode.arrays_hashing_greedy;

class Solution0722 {
    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean blockComment = false;
        for (String s : source) {
            int m = s.length();
            for (int i = 0; i < m; ++i) {
                if (blockComment) {
                    if (i + 1 < m && s.charAt(i) == '*' && s.charAt(i + 1) == '/') {
                        blockComment = false;
                        ++i;
                    }
                } else {
                    if (i + 1 < m && s.charAt(i) == '/' && s.charAt(i + 1) == '*') {
                        blockComment = true;
                        ++i;
                    } else if (i + 1 < m && s.charAt(i) == '/' && s.charAt(i + 1) == '/') {
                        break;
                    } else {
                        sb.append(s.charAt(i));
                    }
                }
            }
            if (!blockComment && sb.length() > 0) {
                ans.add(sb.toString());
                sb.setLength(0);
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
        Solution0722 _tcSol = new Solution0722();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "source = [\"/*Test program */\", \"int main()\", \"{ \", \" // variable declaration \", \"int a, b, c;\", \"/* This is a test\", \" multiline \", \" comment for \", \" testing */\", \"a = b + c;\", \"}\"]");
        try {
            String[] source = new String[]{"/*Test program */", "int main()", "{ ", " // variable declaration ", "int a, b, c;", "/* This is a test", " multiline ", " comment for ", " testing */", "a = b + c;", "}"};
            System.out.println("  Output  : " + _tcShow(_tcSol.removeComments(source)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"int main()\",\"{ \",\" \",\"int a, b, c;\",\"a = b + c;\",\"}\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "source = [\"a/*comment\", \"line\", \"more_comment*/b\"]");
        try {
            String[] source = new String[]{"a/*comment", "line", "more_comment*/b"};
            System.out.println("  Output  : " + _tcShow(_tcSol.removeComments(source)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"ab\"]");
        System.out.println();
    }
}