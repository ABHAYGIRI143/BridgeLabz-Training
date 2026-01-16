
public class RotationPointInSortedArray {
	public static void main(String args[]) {
		   int[] arr = {15, 18, 2, 3, 6, 12};

	        // Call the method to find the rotation point
	        int rotationIndex = findRotationPoint(arr);

	        // Print the result
	        System.out.println("The rotation point (smallest element) is at index: " + rotationIndex);
	        System.out.println("The smallest element is: " + arr[rotationIndex]);
	    }
	
	public static int findRotationPoint(int arr[]) {
		int left =0;
		int right = arr.length-1;
		
		if(arr[0]<arr[arr.length-1]) {
			return -1;
		}
		
		while(left<right) {
			int mid=(left +right )/2;
			
			if(arr[mid]<arr[mid-1] && arr[mid]<arr[mid+1]) {
				return mid;
			}
			 
			else if(arr[mid]>arr[mid-1]) {
				left=mid+1;
			}
			
			else {
				right=mid;
			}
		}
		
		return -1;
	}
}
