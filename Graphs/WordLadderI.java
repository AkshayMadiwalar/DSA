class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> set = new HashSet<>();
        for(String word: wordList){
            set.add(word);
        }
        set.remove(beginWord);

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            if(pair.word.equals(endWord))
                return pair.steps;

            
            for(int i=0;i<pair.word.length();i++){
                for( char ch='a';ch<='z';ch++){
                    char[] charArr = pair.word.toCharArray();
                    charArr[i]=ch;
                    String new_word = new String(charArr);
                    if(set.contains(new_word)){
                        queue.add(new Pair(new_word, pair.steps+1));
                        set.remove(new_word);
                    }
                }
            }
        }
        
        return 0;
    }
}

class Pair{
    String word;
    int steps;
    Pair(String word, int steps){
        this.word=word;
        this.steps = steps;
    }
}