class GfG
{
   public static int countDistinctSubstring(String st)
   {
       //your code here
        TrieNode root = new TrieNode();
        
        char[] arr = st.toCharArray();
        TrieNode head = root;
        int cnt=0;
            
        for(int i=0;i<arr.length;i++){
            int index = arr[i]-'a';
            if(root.children[index]==null){
                cnt++;
                root.children[index]=new TrieNode();
            }
            head=root.children[index];
            for(int j=i+1;j<arr.length;j++){
                int ind = arr[j]-'a';
                if(head.children[ind]==null){
                    head.children[ind]=new TrieNode();
                    cnt++;
                }
                head=head.children[ind];
            }
        }
        return cnt+1;
   }
   

}

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