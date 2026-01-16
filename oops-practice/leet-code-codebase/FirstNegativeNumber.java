import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FirstNegativeNumber {
	public static void main(String args[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the size of an array");
		int n=Integer.parseInt(br.readLine());
		
		int arr[] = new int[n];		
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		  int index = findFirstNegative(arr);

	        // Print the result
	        if (index != -1) {
	            System.out.println("First negative number is " + arr[index] + " at index " + index);
	        } else {
	            System.out.println("No negative number found in the array.");
	        }
	    }

	    // Method to perform linear search for the first negative number
	    public static int findFirstNegative(int[] array) {
	        // Iterate through the array
	        for (int i = 0; i < array.length; i++) {
	            if (array[i] < 0) {
	                // Negative number found, return its index
	                return i;
	            }
	        }
	        // No negative number found, return -1
	        return -1;
	    }
	}


