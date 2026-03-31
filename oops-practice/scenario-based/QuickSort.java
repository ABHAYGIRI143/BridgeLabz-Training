
public class QuickSort {
	public static void main(String args[]) {
		
		int arr [] = {4,2,5,7,10,1,4};
		
		quickTort(arr,0,arr.length-1);
		
		for(int i:arr) {
			System.out.println(i);
		}
 	}
	
	public static void quickTort(int arr[],int low,int high) {
		if(low < high) {
			int pivot  = partition(arr,low,high);
			
			quickTort(arr, low, pivot-1);
			quickTort(arr, pivot+1, high);
		}
	}
	
	public static int partition(int arr[],int low,int high) {
		int pivotEle = arr[high];
		int i = low-1;
		
		for(int j=low;j<high;j++) {
			
			if(arr[j]<pivotEle) {
				i++;
				
				int temp = arr[i];
				arr[i]=arr[j];
				arr[j] = temp;
				
			}
		}
		
		i++;
		int temp =  arr[high];
		arr[high] = arr[i];
		arr[i]=temp;
	
		return i;
	}
	
}
