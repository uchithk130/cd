package CD;
import java.util.*;

public class StackAllocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Size of the Stack : ");
		int n = sc.nextInt();
		Stack<Integer> s = new Stack<Integer>();
		while(true) {
			System.out.println("Enter your option : ");
			System.out.println("1.Push\n2.pop\n3.Display\n4.Exit");
			int choice = sc.nextInt();
			switch(choice) {
				case 1:
					if(s.size()>=n) {
						System.out.println("Overflow");
						break;
					}
					System.out.println("Enter element : ");
					int k = sc.nextInt();
					s.push(k);
					break;
				case 2:
					if(s.isEmpty()) {
						System.out.println("Underflow");
						break;
					}
					System.out.println("Poped element : "+s.pop());
					break;
				case 3:
					if(s.isEmpty()) {
						System.out.println("Stack is empty");
						break;
					}
					else {
						for(Integer e:s) {
							System.out.println(e);
						}
					}
					break;
				case 4:
					sc.close();
					System.exit(0);
			
			}
		}
		
	}	

}
