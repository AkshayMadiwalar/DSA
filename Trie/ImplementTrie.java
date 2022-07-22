package Trie;

class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
    TrieNode(){
        for(int i=0;i<children.length;i++){
            children[i]=null;
        }
        isEnd=false;
    }
}

public class ImplementTrie {
 
    
    class Trie {
        
        TrieNode root;
    
        
        public Trie() {
            root = new TrieNode();
        }
        
        public void insert(String word) {
            
            TrieNode head = root;
            
            for(int i=0;i<word.length();i++){
                int index = word.charAt(i)-'a';
                if(head.children[index]==null){
                    head.children[index]=new TrieNode();
                }
                head = head.children[index];
            }
            head.isEnd = true;
        }
        
        public boolean search(String word) {
            TrieNode head = root;
            for(int i=0;i<word.length();i++){
                int index = word.charAt(i)-'a';
                if(head.children[index]==null)
                    return false;
                head=head.children[index];
            }
            return head.isEnd;
        }
        
        public boolean startsWith(String prefix) {
            TrieNode head = root;
            for(int i=0;i<prefix.length();i++){
                int index = prefix.charAt(i)-'a';
                if(head.children[index]==null)
                    return false;
                head = head.children[index];
            }
            return true;
        }
    }
    
}
