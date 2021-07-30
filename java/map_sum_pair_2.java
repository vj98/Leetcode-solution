class MapSum {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        int weight = 0;
    }
    TrieNode root;
    public MapSum() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode curr = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if(curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }  
            curr = curr.children[c-'a'];
        }
        curr.weight = val;
    }
    
    public int sum(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(curr.children[c-'a'] == null) {
                return 0;   
            }
            curr = curr.children[c-'a'];
        }
        return dfs(curr);
    }
    
    private int dfs(TrieNode node){
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null){
                sum += dfs(node.children[i]);
            }
        }
        return sum + node.weight;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */