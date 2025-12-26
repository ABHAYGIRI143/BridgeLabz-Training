
import java.util.*;
public class NumberCheckerExtended {

	public static void main(String[] args) {

		//Create Scanner Object
		Scanner sc = new Scanner(System.in);
		
		//take a number a user input
		int num = sc.nextInt();
		
		int digitCount = countDigits(num);
		int numArray[] = convertNumToArray(num,digitCount);
		int sumOfDigits = sum(numArray);
		int squareOfDigits = digitsSquare(numArray);
		int reverseDigitArray[] = ReverseDigitArray(numArray);
		
		boolean isDuck = duck(numArray);
		boolean isArmstrong = armstrong(num,digitCount);
		boolean isDeficientNumber = deficientNumber(num);
		boolean isBuzzNumber = buzzNumber(num);
		boolean isSpyNumber = spy(sumOfDigits,numArray);
		boolean isNeonNumber = neonNumber(numArray,num);
		boolean isPrime = prime(num);
		boolean isHarsjadNumber= harshadNumber(num,sumOfDigits);
		boolean isPlaindrome = palindrome(numArray,reverseDigitArray);
		boolean isPerfectNumber = perfectNumber(num);
		boolean isAbundanatNumber = abundantNumber(num);
		boolean isStrongNummber = strongNumber(num);
		
		int largest[]= new int[2];
		firstSecondLargest(numArray,largest);
		
		int smallest[] = new int[2];
		firstSecondSmallest(numArray,smallest);
		System.out.println(num+ " is perfect number "+ isPerfectNumber) ;

		System.out.println(num+" is strong number : "+isStrongNummber);
		System.out.println(num+" is deficient number : "+isDeficientNumber);
		System.out.println(num+" is abundant number : "+isAbundanatNumber);
		System.out.println(num+" is perfect number : "+isPerfectNumber);
		System.out.println(num+" is Buzz Number: "+isBuzzNumber );
		System.out.println("Is spy number: "+isSpyNumber);
		System.out.println("Digits count for number "+num +" is "+digitCount);
		System.out.println("Number is duck number : "+isDuck);
		System.out.println("Sum of the digits of number is "+sumOfDigits);
		System.out.println("Number is prime: "+isPrime);
		System.out.println("Number is armstrong : "+isArmstrong);
		System.out.println("Number is plaindrome :"+isPlaindrome);
		System.out.println("Is Neon Number : "+isNeonNumber);
		System.out.println("Number in digit array "+ Arrays.toString(numArray));
		System.out.println("Number in digit array "+ Arrays.toString(reverseDigitArray));

		System.out.println("Number "+num+ " is harshad number :"+isHarsjadNumber);
		System.out.println("Sum of Square of the digits "+ squareOfDigits);
		System.out.println("First and second largest numbers are "+ Arrays.toString(largest));
		System.out.println("First and second smallest numbers are : "+Arrays.toString(smallest));
		
		//Close Scanner object
		sc.close();
	}
	
	public static boolean strongNumber(int num) {
		int factorialSum=0;
		int temp = num;
		while(temp!=0) {
			factorialSum+=temp;
			temp--;
		}
		
		return  factorialSum==num;
	}
	
	public static boolean deficientNumber(int num) {
		
		int sumOfDivisor =0;
		
		for(int i=1; i<=num/2 ; i++) {
			if(num%i==0) {
				sumOfDivisor+=i;
			}
		}
		
		return sumOfDivisor<num;
	}
	
	public static boolean abundantNumber(int num) {
		 
	int sumOfDivisor =0;
		
		for(int i=1; i<=num/2 ; i++) {
			if(num%i==0) {
				sumOfDivisor+=i;
			}
		}
		
		return sumOfDivisor> num;
	}
	
	public static boolean perfectNumber(int num) {
		int sumOfDivisor =0;
		
		for(int i=1; i<=num/2 ; i++) {
			if(num%i==0) {
				sumOfDivisor+=i;
			}
		}
		
		return sumOfDivisor== num;
	}
	
	public static boolean buzzNumber(int num) {
			
		return num%7==0 || (num%10)==7;
	}
	
	public static boolean spy(int sumOfDigits,int arr[]) {
		 
		int multiply=1;
		
		for(int number:arr) {
			multiply*=number;
		}
		
		return multiply==sumOfDigits;
	}
	
	
	public static boolean neonNumber(int arr[],int num) {
		
		int sum=0;
		
	        for(int number:arr) {
	        	sum+=Math.pow(number, 2);
	        }
		
		return sum==num;
	}
	
	public static boolean prime(int num) {
		if(num == 2 || num == 3) {
			return true;
		}
		
		if(num%2==0 || num%3==0) {
			return false;
		}
		
		for(int i=4 ; i*i<num ;i++) {
			if(num%i==0) return false;
		}
		
		return true;
	}
	
	public static boolean palindrome(int numArray[],int reverseDigits[]){
		
		for(int i=0; i<numArray.length ; i++) {
			if( numArray[i]!=reverseDigits[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	public static int[] ReverseDigitArray(int arr[]) {
		int result[]= new int[arr.length];
		
		for(int i=0; i<arr.length; i++) {
				result[i]=arr[arr.length-1-i];
		}
		
		return result;
	}
	
	public static boolean harshadNumber(int num,int sumOfDigits) {
		return num%sumOfDigits==0;
	}
	
	
	
	public static int digitsSquare(int arr[]) {
		int result = 0;
		for(int num:arr) {
			result+=Math.pow(num,2);
			
		}
		return result;
	}
	
	
	
	public static int countDigits(int num) {
		
		int count = 0;
		
		//count number to digits 
		while(num!=0) {
			count++;
			num = num/10;
		}
		return count;
	}
	
	public static int[] convertNumToArray(int num,int count) {
		int arr[] = new int[count];
		for(int i=count-1 ; i>=0; i--) {
			arr[i]=num%10;
			num = num/10;
		}
		
		return arr;
	}
	
	public static boolean duck(int numArray[]) {
		
		for(int i=0; i<numArray.length; i++) {
			if(numArray[i]==0) {
				return false;
			}
		}
		 return true;
	}
	
	public static boolean armstrong(int num, int count) {
		
		int temp=num;
		int sum=0;
		
	        while (temp != 0) {
	            int digit = temp % 10;
	            sum += Math.pow(digit, count);
	            temp /= 10;
	        }
		
		return sum==num;
	}
	
	public static void firstSecondLargest(int arr[],int largestt[]) {
		
		
		if (arr.length < 2) {
	        System.out.println("Array must have at least 2 elements");
	        return ;
	      
	    }

	    int largest = Integer.MIN_VALUE;
	    int secondLargest = Integer.MIN_VALUE;

	    for (int i = 0; i < arr.length; i++) {

	        // Largest 
	        if (arr[i] > largest) {
	            secondLargest = largest;
	            largest = arr[i];
	        } 
	        
	        else if(secondLargest<arr[i] && secondLargest!=largest) {
	        	secondLargest = arr[i];
	        }
	    
	    }
	    
	    largestt[0] = largest;
	    largestt[1] = secondLargest;
	    


	}
	
public static void firstSecondSmallest(int arr[], int smallestt[]) {
		
		if (arr.length < 2) {
	        System.out.println("Array must have at least 2 elements");
	        return ;
	        
	    }

	    int smallest = Integer.MAX_VALUE;
	    int secondSmallest = Integer.MAX_VALUE;

	    for (int i = 0; i < arr.length; i++) {

	        // Largest 
	        if (arr[i] < smallest) {
	            secondSmallest = smallest;
	            smallest = arr[i];
	        } 
	        
	        else if(secondSmallest>arr[i] && secondSmallest!=smallest) {
	        	secondSmallest = arr[i];
	        }
	    
	    }
	    
	    smallestt[0] = smallest;
	    smallestt[1] = secondSmallest;
	    
	   }
	

public static int sum(int arr[]) {
	
	//initialize a variable that contains sum of all players height
	int sum= 0;
	for(int num: arr) {
		sum+= num;
	}
	return sum;
}

 }
