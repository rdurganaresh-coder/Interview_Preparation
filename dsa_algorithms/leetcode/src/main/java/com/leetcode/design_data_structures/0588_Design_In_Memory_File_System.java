package com.leetcode.design_data_structures;

class Trie0588 {
    String name;
    boolean isFile;
    StringBuilder content = new StringBuilder();
    Map<String, Trie0588> children = new HashMap<>();

    Trie0588 insert(String path, boolean isFile) {
        Trie0588 node = this;
        String[] ps = path.split("/");
        for (int i = 1; i < ps.length; ++i) {
            String p = ps[i];
            if (!node.children.containsKey(p)) {
                node.children.put(p, new Trie0588());
            }
            node = node.children.get(p);
        }
        node.isFile = isFile;
        if (isFile) {
            node.name = ps[ps.length - 1];
        }
        return node;
    }

    Trie0588 search(String path) {
        Trie0588 node = this;
        String[] ps = path.split("/");
        for (int i = 1; i < ps.length; ++i) {
            String p = ps[i];
            if (!node.children.containsKey(p)) {
                return null;
            }
            node = node.children.get(p);
        }
        return node;
    }
}

class FileSystem0588 {
    private Trie0588 root = new Trie0588();

    public FileSystem0588() {
    }

    public List<String> ls(String path) {
        List<String> ans = new ArrayList<>();
        Trie0588 node = root.search(path);
        if (node == null) {
            return ans;
        }
        if (node.isFile) {
            ans.add(node.name);
            return ans;
        }
        for (String v : node.children.keySet()) {
            ans.add(v);
        }
        Collections.sort(ans);
        return ans;
    }

    public void mkdir(String path) {
        root.insert(path, false);
    }

    public void addContentToFile(String filePath, String content) {
        Trie0588 node = root.insert(filePath, true);
        node.content.append(content);
    }

    public String readContentFromFile(String filePath) {
        Trie0588 node = root.search(filePath);
        return node.content.toString();
    }
}

/**
 * Your FileSystem0588 object will be instantiated and called as such:
 * FileSystem0588 obj = new FileSystem0588();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */