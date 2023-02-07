import pkg.*;
import pkg.Stack;

import java.util.*;
import java.time.*;
import java.lang.*;

class main {
	public static void main(String args[]) {
		// bugs.push('5');
		// bugs.push('6');
		// bugs.push('1');
		// bugs.push('3');
		// System.out.print(bugs.pop() +"  ");
		// System.out.print(bugs.pop() +"  ");
		// System.out.print(bugs.pop() +"  ");
		// System.out.print(bugs.pop() +"  ");
		// System.out.print("bugs");

		Stack bugs = new Stack();
		String input = "(((3*1)+2)-9)";
        int count = 0;
        int opCount = 0;
        int operators = 0;
        String temp;
        String ops = "";
        String output = "";
		boolean justRan = false;
        while(count < input.length())
        {
            temp = input.substring(count, count+1);
            char temp2 = temp.charAt(0);
            if (temp.equals("(") || temp.equals(")")) {
				if(temp.equals(")")&& operators>0 && opCount>0 && !justRan){
					output += ops + bugs.pop();
					ops = "";
                    opCount = 0;
                    operators--;
				}
                
            } else if (Character.isDigit(temp2)) {
                opCount++;
                ops += temp;
				justRan = false;
                if (opCount == 2) {
                    output += ops + bugs.pop();
                    ops = "";
                    opCount = 0;
                    operators--;
					justRan = true;
                }
            } else {
                bugs.push(temp.charAt(0));
                operators++;
				justRan = false;
            }
            count++;
        }
			for(int i = 0; i<operators;i++)
			{
				output+=bugs.pop();
			}
			System.out.print(output);
		}
	}
		

