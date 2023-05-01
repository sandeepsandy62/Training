class Solution{
    private String solve(Node root , Map<String,Integer>map){
        String s = root.data+"";
        for(Node node : root.children){
            s += solve(node,map);
        }
        
        map.put(s,map.getOrDefault(s,0)+1);
        return s;
    }
    
    public int duplicateSubtreeNaryTree(Node root){
       // Code here
       Map<String,Integer>map = new HashMap<>();
       solve(root,map);
       int ans = 0 ;
       for(Map.Entry<String,Integer>val:map.entrySet()){
           if(val.getValue() > 1) ans++;
       }
       return ans;
    }
    
}

//if the problem is a tree problem then think which traversal suits the best
//if it is about structure of the subtree or anything about structure . try to use strings 
