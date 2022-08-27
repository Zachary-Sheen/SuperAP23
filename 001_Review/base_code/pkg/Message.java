package pkg;
import java.util.*;
import java.io.*;

public class Message {
	private String mess;
	private String subject;
	private String person;
	private int id;
	private int indent;
	public ArrayList<Message> children = new ArrayList<Message>();

	// Default Constructor
	public Message() {
		mess = "";
	}
	
	// Parameterized Constructor
	public Message(String auth, String subj, String bod, int i) {
		mess = ""+bod;
		subject = ""+subj;
		person = auth;
		id = i;
	}

	// This function is responsbile for printing the Message
	// (whether Topic or Reply), and all of the Message's "subtree" recursively:

	// After printing the Message with indentation n and appropriate format (see output details),
	// it will invoke itself recursively on all of the Replies inside its childList, 
	// incrementing the indentation value at each new level.

	// Note: Each indentation increment represents 2 spaces. e.g. if indentation ==  1, the reply should be indented 2 spaces, 
	// if it's 2, indent by 4 spaces, etc. 
	public void print(int indentation){
		int ids = indentation;
		int indents = indentation*2;
		String topbottext = "\n<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>";
		String message = "Message #"+id+": "+subject+"\n From " + person + ": "+mess + ""+children.size()+"\n";
		for(int i = 0; i<=indents; i++)
		{
			// System.out.print(indents);
			message = " " + message;
		}
		System.out.print(message);
		
		for(int i = 0; i<children.size();i++){
			children.get(i).print(ids++);
		}
		
	}

	// Default function for inheritance
	public boolean isReply(){
		return false;
	}

	// Returns the subject String
	public String getSubject(){
		return subject;
	} 

	// Returns the ID
	public int getId(){
		return id;
	}

	// Adds a child pointer to the parent's childList.
	public void addChild(Message child){
		children.add(child);
	}

}
