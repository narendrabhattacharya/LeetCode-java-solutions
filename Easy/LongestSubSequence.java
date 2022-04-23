package easy;

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
    
}
