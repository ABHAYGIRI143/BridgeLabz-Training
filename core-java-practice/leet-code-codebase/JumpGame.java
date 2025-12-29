class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int maxx=0;
        int i=0;
        while(i<nums.length){
            if(i<=maxx){
                maxx=Math.max(maxx,i+nums[i]);
            }

            else{
                return false;
            }    

            i++;
        }
        return true;
    }
}