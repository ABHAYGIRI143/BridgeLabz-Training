

class Listt{
	private int arr [];
	private  int head=0;
	private  int tail=0;
	private  int size=0;
	
	Listt(int size){
		this.size=size;
		arr= new int[this.size];
	}
	
	void add(int n) {
		if(tail==size) {
			System.out.println("No space is there to add");
			return;
		}
		arr[tail++]=n;
	}
	
	void remove() {
		if(arr.length==0){
			System.out.println("There is no element in linked list");
			return;
		}
		arr[tail]=0;
		tail--;
	}
	
	int peek() {
		if(tail>0) {			
			return arr[tail-1];
		}
		else return -1;
	}
}



public class LinkedListusingArray {
		public static void main(String args[]) {
			Listt ll= new Listt(5);
			ll.add(10);
			ll.add(2);
			ll.add(3);
			System.out.println(ll.peek());
			
		}
	
}
