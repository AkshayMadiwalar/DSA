package SDE.StackAndQueueII;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {

    //---O(m+n) 
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
            
        stack.push(nums2[0])
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=1;i<nums2.length;i++){
            if(stack.size()==0){ 
                stack.push(nums2[i]); 
                continue;
            }
            while(nums2[i]>stack.peek()){
                map.put(stack.pop(),nums2[i]);
                if(stack.size()==0)
                    break;
            }
            stack.push(nums2[i]);
        }
        
        while(stack.size()>0){
            map.put(stack.pop(),-1);
        }
        
        int[] nge = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            nge[i]=map.get(nums1[i]);
        }
        
        return nge;
    }
}
