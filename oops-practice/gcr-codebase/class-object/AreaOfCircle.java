import java.util.Scanner;

class Circle{
	
	int radius;
	static float PI=3.14f;
	
	public Circle(int radius) {
		this.radius = radius;
	}
	
	public void area() {
		System.out.println("The area of circle of radius "+radius+" is "+PI*radius*radius );
	}
	
}

public class AreaOfCircle {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the radius of circle in cm");
		int radius = sc.nextInt();
		
		Circle c1 = new Circle(radius);
		c1.area();

		sc.close();
	
	}

}
