package Trees;

import java.util.HashSet;

public class PathSumIII {
    class Solution {
        int count = 0;
        
        public int pathSum(TreeNode root, int targetSum) {
            
            HashSet<Integer> set = new HashSet<>();
            int sum = 0;
            path(root,sum,targetSum,set);
            set.add(0);
            return count;
        }
        
        public void path(TreeNode root,int sum, int targetSum, HashSet<Integer> set){
            if(root==null)
                return;
            sum = sum + root.val;
            if(root.val == targetSum || sum-targetSum==0)
                count++;
            
            if(set.contains(sum-targetSum))
                count++;
            
            set.add(sum);
            path(root.left,sum,targetSum,set);
           
            path(root.right,sum,targetSum,set);
            set.remove(sum);
            sum = sum -root.val;
        }
        
    }
}
