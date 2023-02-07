import pkg.*;
import java.util.*;
import java.io.*;       

class main {        
	public static void main(String args[]){
        System.out.println("Select a number 1-8: ");
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
		printParentheses(input);

	}
	public static String[] printParentheses(int input) // (((()))) ((()))() (())()()
	{
		ArrayList<String> returnArr = new ArrayList<String>();
		int subTypes = input;
		int counter = 1;
		String addParen = "()";
		String base = "()";
		int ins = 0;;
		int outs = 0;
		while(true)
		{
			for(int i = 0;i<subTypes;i++){
				
			}
		}
	}
	
	public static String in(String input){
		return input.substring(0,1)+ "()" +input.substring(1);
	}
	public static String out(String input){
		return input + "()";
	}

}
