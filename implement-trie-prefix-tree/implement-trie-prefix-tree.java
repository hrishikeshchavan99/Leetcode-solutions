class Trie {
    private Node root;
    public Trie() {
        root = new Node('\0');
    }
    
    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++){
            if (cur.children[word.charAt(i) - 'a'] == null) cur.children[word.charAt(i) - 'a'] = new Node(word.charAt(i));
            cur = cur.children[word.charAt(i) - 'a'];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        Node cur = findWord(word);
        return cur != null && cur.isWord;
    }
    
    public boolean startsWith(String prefix) {
        return findWord(prefix) != null;
    }
    public Node findWord(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++){
            if (cur.children[word.charAt(i) - 'a'] == null) return null;
            cur = cur.children[word.charAt(i) - 'a'];
        }
        return cur;
    }
    
    class Node {
        public char c;
        public boolean isWord;
        public Node[] children;
        
        public Node (char c){
            this.c = c;
            isWord = false;
            children = new Node[26];
                
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */