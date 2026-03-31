
import java.util.*;
public class CanVoteOrNot {

	public static void main(String[] args) {		// TODO Auto-generated method stub
		
		//create the scanner object
		Scanner sc = new Scanner(System.in);
		
		//take input ( number of students )
		int numberOfStudents = sc.nextInt();
		
		//initialize the array with number of students
		int ageOfStudents[] =  new int[numberOfStudents];
		
		//take input (age)
		for(int i = 0; i<numberOfStudents ;i++) {
			ageOfStudents[i] = sc.nextInt();
		}
		
		//check whether the student in eligible for voting or not
		for(int i = 0 ; i<ageOfStudents.length ; i++) {
			
			if(ageOfStudents[i] >= 18 ) {
				System.out.println("Can vote");
			}
			
			else if(ageOfStudents[i]<=0) {
				System.out.println("Invalid age");
			}
			
			else {
				System.out.println("Cant't vote");
			}
		}
		
		//close the scanner object
		sc.close();
		
	}

}
