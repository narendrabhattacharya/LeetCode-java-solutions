package easy;

import java.util.Arrays;

public class LongestSubSequence {

    int[] nums;
    
    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length-1, Integer.MIN_VALUE, 0);
    }
    
    /*
        Brute force approach
    */
    public int helper(int start, int end, int prev, int length){
        //base case
        if(start == end && nums[start] > prev){
            return length+1;
        }
        if(start == end){
            return length;
        }
        
        if(start > end){
            return Integer.MIN_VALUE;
        }
        
        int a = helper(start+1, end, prev, length);
        
        int b = Integer.MIN_VALUE;
        if(nums[start] > prev){
            prev = nums[start];
            b = helper(start+1, end, prev, length+1);
        }
        
        return Math.max(a,b);
    }

    /*
        DP approach
    */

    public int helper1(int start, int end, int prev, int length){
        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);
                    
        for(int i=nums.length-1; i>=0; i--){
            for(int j=nums.length-1; j>i; j--){
                if(nums[j] > nums[i]){
                    lis[i]= Math.max(lis[i],lis[j]+1);
                }
            }
        }
        
        int maxLength = 0;
        for(int l : lis){
            maxLength=Math.max(maxLength, l);
        }
        return maxLength;
    }


    
}
