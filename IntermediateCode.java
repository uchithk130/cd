package CD;
import java.util.*;
public class IntermediateCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		ArrayList<String> l = new ArrayList<String>();
		String temp="";
		int c=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='(') {
				i++;
				while(str.charAt(i)!=')') {
					temp+=str.charAt(i);
					i++;
				}
				i++;
				System.out.println("T"+(c)+" = "+temp);
				l.add("T"+(c));
				c++;
				temp="";
			}
			if(i<str.length())
			l.add(str.substring(i,i+1));
		}
		int i=0;
		for(i=0;i<l.size()-2;i=i+3) {
			
				System.out.println("T"+c+"= "+l.get(i)+l.get(i+1)+l.get(i+2));
				c++;
			}
		if(l.size()>5)
		System.out.println("T"+c+"= T"+(c-1)+l.get(i-2)+l.get(i-1));

		}

	}

