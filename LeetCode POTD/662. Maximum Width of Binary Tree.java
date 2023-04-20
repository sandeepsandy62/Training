class Pair<T,U>{
    private T key;
    private U value;
    
    public Pair(T key , U value){
        this.key = key;
        this.value = value;
    }
    
    public T getKey(){
        return key;
    }
    
    public U getValue(){
        return value;
    }
    
    public void setKey(T key){
        this.key = key;
    }
    
    public void setValue(U value){
        this.value = value;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int res = 0;
        Queue<Pair<TreeNode,Long>>q = new LinkedList<>();
        q.offer(new Pair(root,0L));
        
        while(!q.isEmpty()){
            int size = q.size();
            long first = 0, last = 0;
            long min_index = q.peek().getValue();
            
            for(int i = 0 ; i < size ; i++){
               long curr_index = q.peek().getValue();
                
                TreeNode node = q.peek().getKey();
                q.poll();
                
                if(node.left != null){
                    q.offer(new Pair(node.left,curr_index*2 + 1));
                }
                
                if(node.right != null){
                    q.offer(new Pair(node.right,curr_index*2+2));
                }
                
                if(i == 0) first = curr_index ;
                if(i == size-1) last = curr_index;
                
            }
            res = (int)Math.max(res,(last-first+1));
            
        }
        return res;
    }
}
