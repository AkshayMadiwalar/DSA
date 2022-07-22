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

public class AddAndSearchWord {

    class WordDictionary {
        
        TrieNode root;
    
        public WordDictionary() {
            root = new TrieNode();
        }
        
        public void addWord(String word) {
            TrieNode head = root;
            for(int i=0;i<word.length();i++){
                int index = word.charAt(i)-'a';
                if(head.children[index]==null)
                    head.children[index] = new TrieNode();
                head = head.children[index];
            }
            head.isEnd= true;
        }
        
        public boolean search(String word) {
            return searchAny(word,0,root);
        }
        
        public boolean searchAny(String word,int k,TrieNode head){
            if(k==word.length())
                return head.isEnd;
            
            if(word.charAt(k)!='.'){
                int index = word.charAt(k)-'a';
                if(head.children[index]!=null && searchAny(word,k+1,head.children[index]))
                    return true;
            }
               
            
            if(word.charAt(k)=='.'){
                for(int i=0;i<head.children.length;i++){
                    if(head.children[i]!=null){
                        if(searchAny(word,k+1,head.children[i]))
                            return true;
                    }
                }
            }
            
            return false;
        }
    }
}
