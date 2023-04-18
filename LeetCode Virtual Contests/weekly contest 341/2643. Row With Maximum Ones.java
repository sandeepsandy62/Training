public class Pair<T,U>{
    private T first;
    private U second;
    
    public Pair(T first , U second){
        this.first = first;
        this.second = second;
    }
    
    public T getFirst(){
        return first;
    }
    
    public U getSecond(){
        return second;
    }
    
    public void setFirst(T first){
        this.first = first;
    }
    
    public void setSecond(U second){
        this.second = second;
    }
}

class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        
        HashMap<Integer,Integer>hp = new HashMap<>();
        int rows = mat.length , cols = mat[0].length ;
        
        for(int i = 0 ; i < rows ; i++){
            int count = 0 ;
            for(int j = 0 ; j < cols ; j++){
                if(mat[i][j] == 1){
                    count++;
                }
            }
            hp.put(i,count);
        }
        
        int max = Integer.MIN_VALUE;
        int minIndex = Integer.MAX_VALUE;
        
        for(Map.Entry<Integer,Integer> entry : hp.entrySet()){
            if(entry.getValue() > max || (entry.getValue() == max && entry.getKey() < minIndex)){
                max = entry.getValue();
                minIndex = entry.getKey();
            }
        }
        
        int[] result = new int[2];
        result[0] = minIndex;
        result[1] = max;
        
        return result;

        
    }
}