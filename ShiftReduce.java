package CD;
import java.util.*;
public class ShiftReduce {
	
	private static void Display(Stack<String> s) {
		if(s.isEmpty()) {
			System.out.println("Stack is empty");
		}
		else {
			for(String e:s) {
				System.out.print(e+" ");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of productions : ");
		int n = sc.nextInt();
		Map<String,String> map = new HashMap<String,String>();
		Stack<String> stack = new Stack<String>();
		System.out.println("Enter production (E->A) : ");
		for(int i=0;i<n;i++) {
			String str=sc.next();
			map.put(str.substring(3), str.substring(0,1));
		}
		System.out.println("Enter input string : ");
		String str=sc.next();
		int len = str.length();
		int i=1;
		stack.push(str.substring(0,1));
		Display(stack);
		System.out.println();
		while(i<=len) {
			
			String temp="";
			while(!stack.isEmpty()) {
				
				temp+=stack.pop();
				if(map.containsKey(temp)) {
					stack.push(map.get(temp));
					Display(stack);
					
					System.out.println("\tReduce");
					break;
				}
			}
			if(stack.isEmpty()) {
				int k=temp.length()-1;
				while(k>=0) {
					stack.push(temp.substring(k,k+1));
					k--;
				}
				if(i<str.length())
				stack.push(str.substring(i,i+1));
				Display(stack);
				
				System.out.println("\tShift");
				i++;
			}
		}
		if(i==len+1 && stack.size()==1) {
			System.out.println("String accepted");
		}
		else {
			System.out.println("Not accepted");
		}

	}

}
