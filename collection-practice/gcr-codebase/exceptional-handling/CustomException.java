
class InvalidAgeEception extends Exception{
	public InvalidAgeEception(String message) {
		super(message);
	}
}


class Person{
	String name;
	int age;
	
	Person(String name,int age) throws InvalidAgeEception{
		
		this.name = name;
		
		if(age<18) throw new InvalidAgeEception("Kindly enter the age greater than 18");
		this.age = age;
	}
}
public class CustomException {
	public static void main(String args[]) {
		try{
			Person p1= new Person("Abhay", 20);
			Person p2= new Person("Abhay", 17);
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
