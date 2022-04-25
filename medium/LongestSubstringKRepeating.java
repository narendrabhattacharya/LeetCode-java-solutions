package medium;

import java.util.*;

/*
395. Longest Substring with At Least K Repeating Characters
*/

public class LongestSubstringKRepeating {
    int mem[][] ;
    
    public int longestSubstring(String s, int k) {
        if(k==1){
            return s.length();
        }
        
        mem = new int[s.length()][s.length()];
        for(int[] m : mem){
            Arrays.fill(m, -1);
        }
        
        return dfs(s, 0, s.length()-1, k);
    }
    

    public int dfs(String s, int start, int end , int k){
        
        if(start > end){
            return 0;
        }
        
        //cache
        if(mem[start][end] != -1){
            return mem[start][end];
        }
        
        int length = 0;
        
        Map<Character, Integer> repeat = new HashMap();
        for(int i=start; i<=end; i++){
            Character c = s.charAt(i);
            repeat.put(c, repeat.getOrDefault(c, 0) + 1);  
        }
        
        for(Integer cnt : repeat.values()){
            if(cnt < k){
                length = 0;
                break;
            }
            length = length + cnt;
        }
        
        if(length == 0){
            int a = dfs(s, start+1, end, k);
            int b = dfs(s, start, end-1, k);
            length = Math.max(a, b);
        }
        
        mem[start][end] = length;
        
        return length;
    }
    
}
