// 1768. Merge Strings Alternately : https://leetcode.com/problems/merge-strings-alternately/

// https://www.geeksforgeeks.org/strings-in-java/ - Strings in JAVA
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuffer s = new StringBuffer("");
        int i = 0 ;
        for(i = 0 ; i < word1.length() && i < word2.length() ; i++){
            s.append(word1.charAt(i));;
            s.append(word2.charAt(i));
        }
        for( ; i < word1.length() ; i++){
            s.append(word1.charAt(i));
        }
        for( ; i < word2.length() ; i++){
            s.append(word2.charAt(i));
        }
        
        String ans = new String(s);
        return ans;
    }
}
