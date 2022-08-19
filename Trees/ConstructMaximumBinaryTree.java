package Trees;

public class ConstructMaximumBinaryTree {
    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
           
           return buildTree(0,nums.length-1,nums); 
        }
        
        public TreeNode buildTree(int start, int end, int[] nums){
            
            if(start>end || start<0 || end>=nums.length)
                return null;
            
            int maxIndex = getMax(nums,start,end);
            
            TreeNode root = new TreeNode(nums[maxIndex]);
            
            root.left = buildTree(start,maxIndex-1,nums);
            
            root.right = buildTree(maxIndex+1,end,nums);
            
            return root;
        }
        
        public int getMax(int[] nums,int start, int end){
            int max = Integer.MIN_VALUE;
            int ind = -1;
            for(int i=start;i<=end;i++){
                if(max<nums[i]){
                    max = nums[i];
                    ind = i;
                }
            }
            return ind;
        }
    }
}
