package CD;
import java.util.*;
public class Leftrecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. of productions : ");
		int n = sc.nextInt();
		String str[] = new String[n];
		System.out.println("Enter productions : ");
		for(int i=0;i<n;i++) {
			str[i]=sc.next();
		}
		for(int i=0;i<n;i++) {
			String s = str[i];
			String first = s.substring(0,1);
			String second = s.substring(3);
			String arr[] = second.split("\\|");
			List<String> l1 = new ArrayList<String>();
			List<String> l2 = new ArrayList<String>();
			for(int j=0;j<arr.length;j++) {
				if(!first.equals(arr[j].substring(0,1))) {
					l1.add(arr[j]);
				}
				else {
					l2.add(arr[j]);
				}
			}
			if(!l2.isEmpty()) {
				System.out.print(first+"->");
				for(int k1=0;k1<l1.size();k1++) {
					System.out.print(l1.get(k1)+first+"'|");
				}
				System.out.print("\n"+first+"'->");
				for(int k1=0;k1<l2.size();k1++) {
					System.out.print(l2.get(k1).substring(1)+first+"'|");
				}
				System.out.print(" ϵ\n");
			}
			else {
				System.out.print(first+"->");
				for(int k1=0;k1<l1.size();k1++) {
					System.out.print(l1.get(k1)+"|");
				}
				System.out.println();
			}
		}
		sc.close();

	}

}
