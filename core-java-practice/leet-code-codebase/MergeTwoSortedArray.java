
import java.util.*;
public class MergeTwoSortedArray {

	public static void main(String[] args) {
		
		
	}
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0){
            return ;
        }
        int i=0,j=0;
        while(nums1[i]!=0 ){
            if(nums1[i]>nums2[j]){
                int temp=nums1[i];
                nums1[i]=nums2[j];
                nums2[j]=temp;
                Arrays.sort(nums2);
            }
                i++;
    }
            if(j!=nums2.length){
                for(;i<nums1.length;i++){
                    nums1[i]=nums2[j];
                    j++;
                }
            }
        return ;
        }
}