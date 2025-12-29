class Solution {
    public int jump(int[] nums) {
        int coverage =0;
        int lastIndex=0;
        int totalJump=0;
        int i=0;

        if(nums.length==1) return 0;
        while(i<nums.length){
            coverage= Math.max(coverage,i+nums[i]);

            if(i==lastIndex){
                lastIndex= coverage;
                totalJump++;
            if(coverage>=nums.length-1) return totalJump; 
            }
            i++;
            
        }
        return totalJump;
    }
}