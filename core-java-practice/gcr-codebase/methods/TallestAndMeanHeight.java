
import java.util.*;
public class TallestAndMeanHeight {
	public static void main(String args[]) {
		
		//Create Scanner Object
		Scanner sc =  new Scanner(System.in);
		
		//take number of players as input
		int noOfPlayers = sc.nextInt();
		
		//Initialize an array to store the height of the players
		int heights[] = new int[noOfPlayers];
		
		//Take height as input
		for(int i=0; i<noOfPlayers; i++) {
			heights[i] = sc.nextInt();
		}
		
		int sumOfAllPlayersHeight = sum(heights);
		int tallestPlayerHeight = tallest(heights);
		int shortestPlayerHeight = shortest(heights);
		int meanOfPlayersHeight = mean(heights);
		
		System.out.println("Sum Of all Players height is "+sumOfAllPlayersHeight);
		System.out.println("Tallest Player Height is "+tallestPlayerHeight);
		System.out.println("Shortest Player Height is "+shortestPlayerHeight);
		System.out.println("Mean of all player Heights is "+meanOfPlayersHeight);
		
		//close Scanner object
		sc.close();
		}
	
	public static int sum(int heights[]) {
		
		//initialize a variable that contains sum of all players height
		int sumOfHeights = 0;
		for(int height: heights) {
			sumOfHeights+= height;
		}
		return sumOfHeights;
	}
	
	public static int tallest(int heights[]) {
		
		//initialize a variable that contains sum of all players height
		int tallestPlayerHeight = 0;
		for(int height: heights) {
			if(tallestPlayerHeight<height) {
				tallestPlayerHeight=height;
			}
		}
		return tallestPlayerHeight;
	}
	
	public static int shortest(int heights[]) {
		
		//initialize a variable that contains sum of all players height
		int shortestPlayerHeight = Integer.MAX_VALUE;
		for(int height: heights) {
			if(shortestPlayerHeight>height) {
				shortestPlayerHeight=height;
			}
		}
		return shortestPlayerHeight;
	}

	public static int mean(int heights[]) {
		
		//initialize a variable that contains sum of all players height
		int meanHeight= 0;
		for(int height: heights) {
			
			meanHeight += height;
		}
		return meanHeight/heights.length;
	}
	
}
