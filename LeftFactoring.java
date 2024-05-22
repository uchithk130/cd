package CD;
import java.util.*;
public class LeftFactoring {
	
	private static String CommonPrefix(String[] str) {
		
		String prefix=str[0];
		for(int i=1;i<str.length;i++) {
			while(!str[i].startsWith(prefix)) {
				prefix=prefix.substring(0,prefix.length()-1);
			}
			if(prefix.isEmpty()) {
				return "";
			}
		}
		return prefix;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. of productions : ");
		int n = sc.nextInt();
		int common = n;
		String str[] = new String[100];
		System.out.println("Enter productions(all in small characters) : ");
		for(int i=0;i<n;i++) {
			str[i]=sc.next();
		}
		String s="";
		for(int i=0;i<common;i++) {
			s = str[i];
			String second = s.substring(3);
			String arr[] = second.split("\\|");
			Map<Character,ArrayList<String>> map = new HashMap<>();
			for(String word:arr) {
				char FirstCharacter = word.charAt(0);
				if(!map.containsKey(FirstCharacter)) {
					map.put(FirstCharacter, new ArrayList<String>());
				}
				map.get(FirstCharacter).add(word);
			}
			String out=s.substring(0,1)+"->";
			String intp="";
			int flag =0;
			for(char key : map.keySet()) {
				flag=0;
				String array[] = map.get(key).toArray(new String[0]);
				String prefix = array[0];
				if(array.length>=2) {
					intp+=array[0].toUpperCase().charAt(0)+"->";
					flag=1;
					prefix = CommonPrefix(array);
				}
				if(flag==1) {
						out+=prefix+array[0].toUpperCase().charAt(0)+"|";
						for(String word:array) {
							if(word.length()>prefix.length())
							intp+=word.substring(prefix.length())+"|";
							else
							intp+="ε|";
						}
						str[common++]=intp;
				}
				else {
					out+=prefix+"|";
				}
			}
			System.out.println(out);
			
		}
		sc.close();
	}

}
