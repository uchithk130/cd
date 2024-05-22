package CD;
import java.util.*;
public class DFA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String : ");
		String s=sc.next();
		int q=0;
		for(int i=0;i<s.length()-1;i++) {
			if(s.charAt(i)!='a' && s.charAt(i)!='b' && s.charAt(i)!='c') {
				System.out.println("String not accepted");
				System.exit(0);
			}
			if(s.charAt(i)=='a') {
				q=0;
			}
			else if(i>1?s.charAt(i-1)=='a'&&s.charAt(i)=='b'&&s.charAt(i+1)=='c':q==-1) {
				q=2;
				i++;
			}
			else {
				q=0; 
			}
		}
		if(q==2) {
			System.out.println("String Accepted");
		}
		else {
			System.out.println("String not accepted");
		}
		
		sc.close();
	}

}
