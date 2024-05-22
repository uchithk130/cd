package CD;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexicalAnalyzer {
	
	public static boolean isValidIdentifier(String str) {
        String regex = "[a-zA-Z_][a-zA-Z\\d_]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
	
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter program : ");
    	String s = sc.nextLine();
    	String arr[] = s.split(" ");
    	List<String> keywords = new ArrayList<String>(Arrays.asList("if","else","int","float","string","double","boolean"));
    	List<String> operators = new ArrayList<String>(Arrays.asList(">","<",">=","<=","+","-","*","/","%","="));
    	List<String> delimiters = new ArrayList<String>(Arrays.asList("{","}","[","]",",","(",")",";"));
    	
    	for(int i=0;i<arr.length;i++) {
    		if(keywords.contains(arr[i])) {
    			System.out.println(arr[i]+" : Keyword");
    		}
    		else if(operators.contains(arr[i])) {
    			System.out.println(arr[i]+" : operator");
    		}
    		else if(delimiters.contains(arr[i])) {
    			System.out.println(arr[i]+" : delimiter");
    		}
    		else if(isValidIdentifier(arr[i])){
    			System.out.println(arr[i]+" : Identifier");
    		}
    		else {
    			System.out.println(arr[i]+" : literal");
    		}
    	}
    	sc.close();
       
    }
}
