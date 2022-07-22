package SDE.RecursionAndBacktracking;

import java.util.*;

public class WordSearchII {
    class Trie{
        Trie[] children = new Trie[26];
        boolean isEnd;
        Trie(){
            for(int i=0;i<children.length;i++){
                children[i]=null;
            }
            isEnd=false;
        }
    }
    class Solution {
         Set<String> ans = new HashSet<>();
        
        Trie root;
        
        public List<String> findWords(char[][] board, String[] words) {
            root = new Trie();
            for(int i=0;i<words.length;i++){
                insert(words[i]);
            }
            
         int[][] visited = new int[board.length][board[0].length];
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[i].length;j++){
                        int index = board[i][j]-'a';
                        if(root.children[index]!=null){
                            StringBuilder sb = new StringBuilder();
                            dfs(i,j,board,visited,sb,root);
                        }
                    }
                }
             return new ArrayList<>(ans);
            }
        
         public void dfs(int i, int j,char[][] board,int[][] visited,StringBuilder sb,Trie head){
    
            sb.append(board[i][j]);
             
            visited[i][j]=1;
            
    
            int index = board[i][j]-'a';
            if(head.children[index]==null){
                sb.deleteCharAt(sb.length()-1);
                visited[i][j]=0;
                return;
            }
            head = head.children[index];
             
            if(head.isEnd){
                ans.add(sb.toString());
            }
    
                    
            
            if(i<board.length-1 && visited[i+1][j]!=1){
                dfs(i+1,j,board,visited,sb,head);
              
            }
            
            if(j<board[0].length-1 && visited[i][j+1]!=1){
                dfs(i,j+1,board,visited,sb,head);
            }
            
            if(j>0 && visited[i][j-1]!=1){
                dfs(i,j-1,board,visited,sb,head);
            }
            
            if(i>0 && visited[i-1][j]!=1){
                dfs(i-1,j,board,visited,sb,head);
             }
            sb.deleteCharAt(sb.length()-1);
             visited[i][j]=0;
        }
        
        public void insert(String word){
            Trie head = root;
            for(int i=0;i<word.length();i++){
                int index = word.charAt(i)-'a';
                if(head.children[index]==null)
                    head.children[index] = new Trie();
                head= head.children[index];
            }
            head.isEnd = true;
        }
    
    
    }
        
       
    
}
