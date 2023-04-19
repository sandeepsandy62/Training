//problem link : https://leetcode.com/contest/weekly-contest-341/problems/find-the-maximum-divisibility-score/

class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        
        int divLen = divisors.length , numsLen = nums.length ;
        
        int[] divScore = new int[divLen];
        for(int i = 0 ; i < divLen ; i++){
            divScore[i] = 0;
        }
        
        for(int i = 0 ; i < divLen ; i++){
            for(int j = 0 ; j < numsLen ; j++){
                if(nums[j] % divisors[i] == 0){
                    divScore[i]++;
                }
            }
        }
        int maxi = divScore[0];
        for(int i = 0 ; i < divLen ; i++){
            if(divScore[i] > maxi){
                maxi = divScore[i];
            }
        }
        
        int count = 0 , min_value = Integer.MAX_VALUE;
        for(int i = 0 ; i < divLen ; i++){
            if(maxi == divScore[i]){
                count++;
                min_value = Math.min(min_value,divisors[i]);
            }
        }
        
        if(count == 1) return min_value;
        
        int max_divisor = divisors[0];
        int max_divisor_score = divScore[0];
        
        for(int i = 0 ; i < divLen ; i++){
            if( divScore[i] > max_divisor_score || (divScore[i] == max_divisor_score && divisors[i] < max_divisor) ){
                max_divisor_score = divScore[i];
                max_divisor = divisors[i];
            }
        }
        return max_divisor;
    }
}