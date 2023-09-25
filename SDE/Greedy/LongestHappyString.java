class Pair{
    char key;
    int value;
    Pair(char k, int v){
        this.key = k;
        this.value=v;
    }
}
public class LongestHappyString {
    public String longestDiverseString(int a, int b, int c) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('a',a);
        map.put('b',b);
        map.put('c',c);
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->y.value-x.value);
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            if(entry.getValue()>0)
                pq.add(new Pair(entry.getKey(),entry.getValue()));
        }
        Queue<Pair> queue = new LinkedList<>();
                   
        StringBuilder sb = new StringBuilder();
                   
        int lastcount = 0;
        
        while(!pq.isEmpty() || !queue.isEmpty()){
            
            Pair pair = pq.poll();
           
            char ch = pair.key;
            int freq = pair.value;
            if(freq>=2 && lastcount < pair.value){
                sb.append(ch);
                sb.append(ch);
                pair.value=pair.value-2;
            }else if(freq==1 || (freq>=2 && lastcount>=pair.value)){
                sb.append(ch);
                pair.value--;
            }
            
            lastcount = pair.value;
            if(pair.value>0){
                queue.add(pair);
            }
            
            
            if(!queue.isEmpty()){
                Pair npair = queue.peek();
                char nextchar = npair.key;
                if(nextchar!=ch){
                    pq.add(npair);
                    queue.poll();
                }
                else if(pq.size()==0){
                    break;
                }
            }
            
            
        }
                   
        return sb.toString();
    }
}
