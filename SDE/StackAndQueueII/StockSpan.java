package SDE.StackAndQueueII;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpan {
    
    Stack<Integer> stk; 
    List<Integer> stocks;
    List<Integer> lge;
    
    public StockSpan() {
        stk=new Stack<>();
        stocks=new ArrayList<>();
        lge=new ArrayList<>();
    }
    
    public int next(int price) {
        stocks.add(price);
        if(stocks.size()==1){
            stk.push(stk.size());
            return 1;
        }
        
        int i = stocks.size()-1;
         
        
            while(stk.size()>0 && stocks.get(stk.peek()) <= stocks.get(i) ){
                //add lge
               stk.pop();
            }
        
            int res;
            if(stk.size()==0){
                res=i+1;
            }else{
                res = i-stk.peek();
            }
                  

            stk.push(i);
            return res;
        
    }
}
                  