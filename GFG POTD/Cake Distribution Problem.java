class Solution{
    
    private boolean checkSweetness(int mid , int k , int[] sweetness){
        int sum = 0 , count = 0;
        for(int i = 0 ; i < sweetness.length ; i++){
            sum += sweetness[i];
            if(sum >= mid) {
                count++;
                sum = 0;
            }
        }
        return count >= k+1 ;
    }
	int maxSweetness(int [] sweetness, int N, int K) {
	    // Write your code here.

        /*
          they mentioned to pick consecutive values
          and constraints are nlogm
          so , instead of thinking in recursion + dp
          think to search the answer in a range - binary search
          if k == 0 then we have to divide the cake into k+1 chunks and the sweetness is sum
          if k == n-1 then we have to divide the cake into n chunks and the sweetness is min value
          so the range is [minvalue , sum_of_the_elements]
          now for every possible sum in this range check whether we can divide into k+1 chunks with sweetness > give sum 
        */
	    int right  = 0;
	    int left = Integer.MAX_VALUE;
	    for(int i = 0 ; i < sweetness.length ; i++){
	        right += sweetness[i];
	        if(sweetness[i] < left){
	            left = sweetness[i];
	        }
	    }
	    int ans = 0;
	    while(left <= right){
	        int mid = left + (right-left) / 2 ;
	        if(checkSweetness(mid,K,sweetness)){
	            ans = mid;
	            left = mid+1;
	        }else{
	            right = mid-1;
	        }
	    }
	    
	    return ans;
	}
}