package com.leetcode.design_data_structures;

class StringIterator0604 {
    private List<Node0604> d = new ArrayList<>();
    private int p;

    public StringIterator0604(String compressedString) {
        int n = compressedString.length();
        int i = 0;
        while (i < n) {
            char c = compressedString.charAt(i);
            int x = 0;
            while (++i < n && Character.isDigit(compressedString.charAt(i))) {
                x = x * 10 + (compressedString.charAt(i) - '0');
            }
            d.add(new Node0604(c, x));
        }
    }

    public char next() {
        if (!hasNext()) {
            return ' ';
        }
        char ans = d.get(p).c;
        if (--d.get(p).x == 0) {
            ++p;
        }
        return ans;
    }

    public boolean hasNext() {
        return p < d.size() && d.get(p).x > 0;
    }
}

class Node0604 {
    char c;
    int x;

    Node0604(char c, int x) {
        this.c = c;
        this.x = x;
    }
}

/**
 * Your StringIterator0604 object will be instantiated and called as such:
 * StringIterator0604 obj = new StringIterator0604(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */