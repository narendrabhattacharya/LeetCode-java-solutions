package medium;

public class MaximumSumNo2Adjacent {


    /*
    dp O(n^2)
    */
    public int maximumSum(int[] arr){
		int maxSum[] = new int[arr.length];
		int max = 0;
		for(int i=arr.length-1; i>=0; i--){
			maxSum[i] = arr[i];
			for(int j=arr.length-1; j>i+1; j--){
				maxSum[i] = Math.max(maxSum[i], maxSum[j] + arr[i]);
			}
			max = Math.max(maxSum[i], max);
		}
		return max;
	} 

    /*
    O(n)
    */
    public int findMaxSum(int arr[], int n)
    {
        int incl = arr[0];
        int excl = 0;
        int excl_new;
        int i;
 
        for (i = 1; i < n; i++) {
            // Current max excluding i
            excl_new = Math.max(incl, excl);
 
            // Current max including i
            incl = excl + arr[i];
            excl = excl_new;
        }
 
        // Return max of incl and excl
        return Math.max(incl, excl);
    }
    public static void main(String[] args){

        int[] testArr = new int[]{108 ,105, 2 ,1002};
        MaximumSumNo2Adjacent obj = new MaximumSumNo2Adjacent();
        System.out.println(obj.maximumSum(testArr));
        System.out.println(obj.findMaxSum(testArr, testArr.length));
    }
}


/*
108 105 2 1002

*/