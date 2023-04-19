//problem link : https://leetcode.com/contest/weekly-contest-341/problems/minimum-additions-to-make-valid-string/

class Solution {
    public int addMinimum(String word) {
        
        //use window as 3 check if that window as abc
        int i = 0 , ans = 0;
        while(i < word.length()){
            int count = 0;
            if(word.charAt(i) == 'a'){
                count++;
                i++;
            }
            if(i < word.length() && word.charAt(i) == 'b'){
                count++;
                i++;
            }
            if(i < word.length() && word.charAt(i) == 'c'){
                count++;
                i++;
            }
            
            ans += (3-count);
        }
        
        return ans;
    }
}