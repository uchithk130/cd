package CD;

import java.util.Scanner;
import java.util.Stack;

public class operator_precedence {

private static final String[] handles = {")E(", "E*E", "E+E", "i", "E^E"};
    private static final char[][] prec = {
        {'>', '>', '<', '<', '<', '<', '<', '>', '>'},
        {'>', '>', '<', '<', '<', '<', '<', '>', '>'},
        {'>', '>', '>', '>', '<', '<', '<', '>', '>'},
        {'>', '>', '>', '>', '<', '<', '<', '>', '>'},
        {'>', '>', '>', '>', '<', '<', '<', '>', '>'},
        {'>', '>', '>', '>', '>', 'e', 'e', '>', '>'},
        {'<', '<', '<', '<', '<', '<', '<', '>', 'e'},
        {'>', '>', '>', '>', '>', 'e', 'e', '>', '>'},
        {'<', '<', '<', '<', '<', '<', '<', '<', '>'}
    };
    private char[] stack = new char[50];
    private int top = 0;
    private String lastHandle;
    private String input;
    private int i = 0;
    private int l;

    public static void main(String[] args) {
        operator_precedence parser =  new operator_precedence ();
        parser.parse();
    }

    private void parse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter the string");
        input = scanner.next() + "$";
        l = input.length();
        stack[top] = '$';
        System.out.println("\nSTACK\tINPUT\tACTION");
        while (i < l-1||reduce()&&top>0) {
            shift();
            System.out.println();
            displayStack();
            System.out.print("\t");
            displayInput();
            System.out.print("\tShift");
            if (prec[getIndex(stack[top])][getIndex(input.charAt(i))] == '>') {
                while (reduce()) {
                    System.out.println();
                    displayStack();
                    System.out.print("\t");
                    displayInput();
                    System.out.print("\tReduced: E->" + lastHandle);
                }
            }
        }
        if (new String(stack, 0, top + 1).equals("$E$")&&stack[top]=='$')
            System.out.println("\nNot Accepted");
        else
            System.out.println("\n Accepted");
        scanner.close();
    }

    private int getIndex(char c) {
        switch (c) {
            case '+': return 0;
            case '-': return 1;
            case '*': return 2;
            case '/': return 3;
            case '^': return 4;
            case 'i': return 5;
            case '(': return 6;
            case ')': return 7;
            case '$': return 8;
            default: return -1;
        }
    }

    private void shift() {
        stack[++top] = input.charAt(i++);
    }

    private boolean reduce() {
        for (int j = 0; j < handles.length; j++) {
            int len = handles[j].length();
            if (top + 1 >= len && new String(stack, top - len + 1, len).equals(handles[j])) {
                top -= len - 1;
                stack[top] = 'E';
                lastHandle = handles[j];
                return true;
            }
        }
        return false;
    }

    private void displayStack() {
        for (int j = 0; j <= top; j++)
            System.out.print(stack[j]);
    }

    private void displayInput() {
        for (int j = i; j < l; j++)
            System.out.print(input.charAt(j));
    }
}