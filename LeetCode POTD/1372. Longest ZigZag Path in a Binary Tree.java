/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int longestZigZag(TreeNode root) {
        int[] max = new int[1];
        zigzag(root,true,0,max);
        zigzag(root,false,0,max);
        return max[0];
    }
    
    public void zigzag(TreeNode node , boolean dir , int len , int[] max){
        
        if(node == null) return;
        
        max[0] = Math.max(len,max[0]);
        
        if(dir){ // if direction is true we move to right assume
            zigzag(node.right,false,len+1,max); //if we are following the zigzag path , then increase the len
            zigzag(node.left,true,1,max); //if we are not following the zigzag path , then start from that node only
        }else{
            zigzag(node.left,true,len+1,max);
            zigzag(node.right,false,1,max);//if we are not following the zigzag path , then start from that node only
        }
        
    }
}