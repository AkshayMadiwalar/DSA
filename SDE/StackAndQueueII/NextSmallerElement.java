package SDE.StackAndQueueII;

import java.util.HashMap;
import java.util.Stack;

public class NextSmallerElement {
    
    public static int[] help_classmate(int arr[], int n) 
	{ 
	    // Your code goes here
	    Stack<Integer> stack = new Stack<Integer>();
	    stack.push(arr[0]);
	    int[] nse = new int[n];
	    HashMap<Integer,Integer> map = new HashMap<>();
	    
	    for(int i=1;i<n;i++){
	        if(stack.size()==0){
	            stack.push(arr[i]);
	            continue;
	        }
	        while(arr[i]<stack.peek()){
	            map.put(stack.pop(),arr[i]);
	            if(stack.size()==0)
	                break;
	        }
	        stack.push(arr[i]);
	    }
	    while(stack.size()>0){
	        map.put(stack.pop(),-1);
	    }
	    for(int i=0;i<n;i++){
	        nse[i]=map.get(arr[i]);
	    }
	    return nse;
	} 
}
