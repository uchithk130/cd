package CD;
import java.util.*;
public class Op {
	
	private static void OperatorPrecedanceTable(char[][] ch, String k) {
		// TODO Auto-generated method stub
		for(int i=0;i<ch.length;i++) {
			for(int j=0;j<ch[0].length;j++) {
				if(i==0 && j==0) {
					continue;
				}
				else if(i==0&&j!=0) {
					ch[i][j]=k.charAt(j-1);
				}
				else if(j==0&&i!=0) {
					ch[i][j]=k.charAt(i-1);
				}
				else if(k.charAt(i-1)==k.charAt(j-1)){
					if(Character.isLetter(k.charAt(i-1))) {
						ch[i][j]='-';
					}
					else if(k.charAt(i-1)=='$') {
						ch[i][j]='A';
					}
					else {
						ch[i][j]='>';
					}
					
				}
				else if(Character.isLetter(k.charAt(i-1))) {
					ch[i][j]='>';
				}
				else if(Character.isLetter(k.charAt(j-1))) {
					ch[i][j]='<';
				}
				else if(k.charAt(j-1)=='$') {
					ch[i][j]='>';
				}
				else if(k.charAt(i-1)=='$') {
					ch[i][j]='<';
				}
				else if ((int)k.charAt(i-1)>(int)k.charAt(j-1)) {
					ch[i][j]='<';
				}
				else if ((int)k.charAt(i-1)<(int)k.charAt(j-1)) {
					ch[i][j]='>';
				}
			}
		}
		
	}
	private static void Display(Stack<Character> s) {
		if(s.isEmpty()) {
			System.out.println("Stack is empty");
		}
		else {
			for(Character e:s) {
				System.out.print(e+" ");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter operator Grammer : ");
		String s = sc.next();
		char first = s.charAt(0);
		String arr[] = s.substring(3).split("\\|");
		Map<Character,Integer> m = new HashMap<Character,Integer>();
		String k="";
		int var =1;
		for(int i=3;i<s.length();i++) {
			if(s.charAt(i)=='|') {
				continue;
			}
			if(!((int)s.charAt(i)>=65 && (int)s.charAt(i)<=90) && !m.containsKey(s.charAt(i))) {
				m.put(s.charAt(i), var++);
				k+=s.charAt(i);
			}
		}
		k+="$";
		m.put('$', var++);
		char ch[][] = new char[k.length()+1][k.length()+1];
		System.out.println("Operator Precedence table : ");
		OperatorPrecedanceTable(ch,k);
		for(int i=0;i<ch.length;i++) {
			for(int j=0;j<ch[0].length;j++) {
				System.out.print(ch[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("Enter input String : ");
		String input = sc.next();
		input+="$";
		System.out.println(input);
		char[] in = input.toCharArray();
		ArrayList<String> l =new ArrayList<String>(Arrays.asList(arr));
		ArrayList<Character> l2 = new ArrayList<Character>();
		for (char c : in) {
            l2.add(c);
        }
		Stack<Character> stack = new Stack<Character>();
		stack.push('$');
		int index=0;
		String temp="";
		while(l2.size()>=index) {
			if(m.containsKey(stack.peek())){
				if(ch[m.get(stack.peek())][m.get(l2.get(index))]=='A') {
					Display(stack);
					System.out.print("\tString accepted");
					sc.close();
					System.exit(0);
				}

				if(ch[m.get(stack.peek())][m.get(l2.get(index))]=='<') {
					if(temp.length()>0)
					stack.push(temp.charAt(0));
					stack.push(l2.get(index));
					index++;
					Display(stack);
					System.out.println("\t\tShift");
					temp="";
				}
				else if(ch[m.get(stack.peek())][m.get(l2.get(index))]=='>') {
					temp +=(""+stack.pop());
					while(!l.contains(temp)) {
						temp +=(""+stack.pop());
					}
					stack.push(first);
					temp="";
					Display(stack);
					System.out.println("\t\tReduce");

				}
			}
			else {
				temp +=(""+stack.pop());
				

			}
		}
		System.out.println("Not Accepted");
		sc.close();

	}

}
