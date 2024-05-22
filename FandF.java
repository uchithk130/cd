package CD;
import java.util.*;
public class FandF {
	
	private static void Struct(Map<String,ArrayList<String>> map,String str[]) {
		for(int i=0;i<str.length;i++) {
			String s = str[i].substring(3);
			String s1[] = s.split("\\|");
			map.put(str[i].substring(0,1),new ArrayList<String>(Arrays.asList(s1)));
		}
	}
	
	private static void First(Map<String,ArrayList<String>> map,String str[],Map<String,ArrayList<String>> first,String temp) {
		for(int i=temp.length();i>0;i--) {
			ArrayList<String> l = map.get(temp.substring(i-1,i));
	        Set<String> set = new HashSet<>();

			for(String k:l) {
				for(int j=0;j<k.length();j++) {
					if(((int)k.charAt(j)>=97 && (int)k.charAt(j)<=122)||k.charAt(j)=='(') {
						set.add(k.substring(j,j+1));
						break;
					}
					else {
						set.addAll(first.get(k.substring(j,j+1)));
					}
				}
			}
			ArrayList<String> l2 = new ArrayList<String>(set);
			first.put(temp.substring(i-1,i), l2);

		}
	}
	
	private static void follow(Map<String,ArrayList<String>> map,Map<String,ArrayList<String>> first,Map<String,ArrayList<String>> follow,String temp) {
	int cc=0;
	String kk="";
		for(int i=1;i<temp.length();i++) {
			char st = temp.charAt(i);
			System.out.print(st+"->>");
	        Set<String> set = new HashSet<>();
			for(int j=0;j<temp.length()&&i!=j;j++) {
				
				ArrayList<String> l = map.get(temp.substring(j,j+1));
				
		        for(String k:l) {
		        	System.out.print(k+" | ");
		        	for(int z=0;z<k.length();z++) {
		        		if(z<k.length()-1&&st==k.charAt(z)) {

		        			if((int)k.charAt(z+1)>=65 && (int)k.charAt(z+1)<=90) {

		        				
		        				set.addAll(first.get(k.substring(z+1,z+2)));
		        				cc=z+1;
		        				kk=k.substring(z+1,z+2);
		        				while(cc<k.length()-1&&first.get(kk).contains("(")) {
		        					
		        					if((int)k.charAt(cc+1)>=65 && (int)k.charAt(cc+1)<=90) {
		        						set.addAll(first.get(k.substring(cc+1,cc+2)));
		        						cc++;
		        					}
		        					else {
		        						set.add(k.substring(cc+1,cc+2));
		        						break;
		        					}
		        					
		        				}
		        			}
		        			else {
		        				
		        				set.add(k.substring(z,z+1));
		        				break;
		        			}
		        		}
		        		else if(z==k.length()&&st==k.charAt(z)) {
		        			
		        			set.addAll(follow.get(temp.substring(z,z+1)));
		        			break;
		        		}
		        	}
		        	
		        }
				
				
				
			}
			set.remove("(");
			follow.put(temp.substring(i,i+1), new ArrayList<String>(set));
		}
	}
	
	private static void Display(Map<String,ArrayList<String>> first,String temp) {
		System.out.println("First Function : ");
		for(int i=0;i<temp.length();i++) {
			System.out.print(temp.charAt(i)+" --> ");
			for(String k:first.get(temp.substring(i,i+1))) {
				System.out.print(k+" ");
			}
			System.out.println();
		}
	}
	



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Map<String,ArrayList<String>> map = new LinkedHashMap<String,ArrayList<String>>();
		System.out.println("Enter of number of productions : ");
		int n = sc.nextInt();
		String str[] = new String[n];
		String temp="";
		for(int i=0;i<n;i++) {
			str[i]=sc.next();
			temp+=str[i].substring(0,1);
		}
		Map<String,ArrayList<String>> first = new LinkedHashMap<String,ArrayList<String>>();
		Map<String,ArrayList<String>> follow = new LinkedHashMap<String,ArrayList<String>>();
		
		Struct(map,str);
		First(map,str,first,temp);
		Display(first,temp);
		ArrayList<String> bb = new ArrayList<String>();
		bb.add("$");
		follow.put("S", bb);
		follow(map,first,follow,temp);
		Display(follow,temp);

	}

}
