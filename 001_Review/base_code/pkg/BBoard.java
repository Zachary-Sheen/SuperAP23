package pkg;
import java.util.*;
import java.io.*;
import java.util.Scanner;

public class BBoard {		// This is your main file that connects all classes.
	// Think about what your global variables need to be.
	private String title;
	private ArrayList<User> userarr;
	private ArrayList<Message> messarr;
	private User currentUser;
	private static int idNumber;

	// Default constructor that creates a board with a defaulttitle, empty user and message lists,
	// and no current user
	public BBoard() {
		title = "";
		userarr = new ArrayList<User>();
		messarr = new ArrayList<Message>();
	}

	// Same as the default constructor except it sets the title of the board
	public BBoard(String ttl) {	
		title = ttl;
		userarr = new ArrayList<User>();
		messarr = new ArrayList<Message>();
	}

	// Gets a filename of a file that stores the user info in a given format (users.txt)
	// Opens and reads the file of all authorized users and passwords
	// Constructs a User object from each name/password pair, and populates the userList ArrayList.
	public void loadUsers(String inputFile) throws FileNotFoundException {
		Scanner users = new Scanner(new File(inputFile));
		String line = "";
		int counter = 0;
		while(users.hasNextLine()){
			line = users.nextLine();
			String[] split = line.split(" ");
			userarr.add(new User(split[0],split[1]));
		}
		login();

	}

	// Asks for and validates a user/password. 
	// This function asks for a username and a password, then checks the userList ArrayList for a matching User.
	// If a match is found, it sets currentUser to the identified User from the list
	// If not, it will keep asking until a match is found or the user types 'q' or 'Q' as username to quit
	// When the users chooses to quit, sayu "Bye!" and return from the login function
	public void login(){
		System.out.println("ZMoney's sick board");
		Scanner input = new Scanner(System.in);
		boolean isDone = false;
		while(true){
		String user;
		String pwd;
		System.out.print("Enter your username ('Q' or 'q' to quit): ");
		user = input.nextLine();
		if(user.equals("Q") || user.equals("q")){
				System.out.println("Cya lata brotha!");
				return;
			}
		System.out.print("\nEnter your password ('Q' or 'q' to quit): ");
		pwd = input.nextLine();
			for(int i = 0; i<userarr.size(); i++){
				if(userarr.get(i).check(user,pwd)){
					currentUser = userarr.get(i);
					isDone = true;
				} 
			}
			if(isDone){
					System.out.println("Welcome back Sir " + currentUser.getUsername());
					break;
				} else{
					System.out.println("Invalid username and/or password");
				}
		}
		

	}
	
	// Contains main loop of Bulletin Board
	// IF and ONLY IF there is a valid currentUser, enter main loop, displaying menu items
	// --- Display Messages ('D' or 'd')
	// --- Add New Topic ('N' or 'n')
	// --- Add Reply ('R' or 'r')
	// --- Change Password ('P' or 'p')
	// --- Quit ('Q' or 'q')
	// With any wrong input, user is asked to try again
	// Q/q should reset the currentUser to 0 and then end return
	// Note: if login() did not set a valid currentUser, function must immediately return without showing menu
	public void run(){
		Scanner input = new Scanner(System.in);
		String inputs = "";
		while(true){
			String display = "\n--- Display Messages ('D' or 'd')\n--- Add New Topic ('N' or 'n')\n--- Add Reply ('R' or 'r')\n--- Change Password ('P' or 'p')\n--- Quit ('Q' or 'q')";
			System.out.println(display);
			inputs = input.nextLine();
		if(inputs.equals("D") || inputs.equals("d"))
		{
			display();
			break;
		}
		else if(inputs.equals("N") || inputs.equals("n"))
		{
			addTopic();
			break;
		}
		else if(inputs.equals("R") || inputs.equals("r"))
		{
			addReply();
			break;
		}
		else if(inputs.equals("P") || inputs.equals("p"))
		{
			setPassword();
			break;
		}
		else if(inputs.equals("Q") || inputs.equals("q"))
		{
			System.out.print("Later Skater");
			break;
		}
		else{
			System.out.print("Enter a valid input");
		}
	}
	}

	// Traverse the BBoard's message list, and invote the print function on Topic objects ONLY
	// It will then be the responsibility of the Topic object to invoke the print function recursively on its own replies
	// The BBoard display function will ignore all reply objects in its message list
	private void display(){
		String topbottext = "\n<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n";
		System.out.println(""+topbottext+"");
		if(messarr.size() == 0){
			System.out.print("No messages available\n");
			System.out.println(""+topbottext+"");
			run();
			return;
		}
		for(int i = 0; i < messarr.size();i++){
			messarr.get(i).print(1);
		}
		System.out.println(""+topbottext+"");
		run();

	}


	// This function asks the user to create a new Topic (i.e. the first message of a new discussion "thread")
	// Every Topic includes a subject (single line), and body (single line)

	/* 
	Subject: "Thanks"
	Body: "I love this bulletin board that you made!"
	*/

	// Each Topic also stores the username of currentUser; and message ID, which is (index of its Message + 1)

	// For example, the first message on the board will be a Topic who's index will be stored at 0 in the messarr ArrayList,
	// so its message ID will be (0+1) = 1
	// Once the Topic has been constructed, add it to the messarr
	// This should invoke your inheritance of Topic to Message
	private void addTopic(){
		idNumber++;
		Scanner inputs = new Scanner(System.in);
		System.out.print("Subject: ");
		String subject = inputs.nextLine();
		System.out.print("Body: ");
		String body = inputs.nextLine();
		messarr.add(new Topic(currentUser.getUsername()," \""+subject + "\"","\""+body +"\"",idNumber));
		run();
	}

	// This function asks the user to enter a reply to a given Message (which may be either a Topic or a Reply, so we can handle nested replies).
	//		The addReply function first asks the user for the ID of the Message to which they are replying;
	//		if the number provided is greater than the size of messarr, it should output and error message and loop back,
	// 		continuing to ask for a valid Message ID number until the user enters it or -1.
	// 		(-1 returns to menu, any other negative number asks again for a valid ID number)
	
	// If the ID is valid, then the function asks for the body of the new message, 
	// and constructs the Reply, pushing back the Reply on to the messarr.
	// The subject of the Reply is a copy of the parent Topic's subject with the "Re: " prefix.
	// e.g., suppose the subject of message #9 was "Thanks", the user is replying to that message:


	/*
			Enter Message ID (-1 for Menu): 9
			Body: It was a pleasure implementing this!
	*/

	// Note: As before, the body ends when the user enters an empty line.
	// The above dialog will generate a reply that has "Re: Thanks" as its subject
	// and "It was a pleasure implementing this!" as its body.

	// How will we know what Topic this is a reply to?
	// In addition to keeping a pointer to all the Message objects in BBoard's messarr ArrayList
	// Every Message (wheather Topic or Reply) will also store an ArrayList of pointers to all of its Replies.
	// So whenever we build a Reply, we must immediately store this Message in the parent Message's list. 
	// The Reply's constructor should set the Reply's subject to "Re: " + its parent's subject.
	// Call the addChild function on the parent Message to push back the new Message (to the new Reply) to the parent's childList ArrayList.
	// Finally, push back the Message created to the BBoard's messarr. 
	// Note: When the user chooses to return to the menu, do not call run() again - just return fro mthis addReply function. 
	private void addReply(){
		Scanner inputs = new Scanner(System.in);
		idNumber++;
		while(true)
		{
			System.out.print("\nEnter Message ID (-1 for Menu, -2 for IDS): ");
			int inputInt = inputs.nextInt();
			inputs.nextLine();
			if(inputInt == -1)
			{
				return;
			}else if(inputInt == -2){
				for(int i = 0; i<messarr.size();i++){
					System.out.print(""+messarr.get(i).getId()+ "  ");
				}
			}
			else if(inputInt > idNumber||inputInt <= 0){
				System.out.print("\nInvalid ID");
			} else{
				System.out.print("\nBody: ");
				String input = inputs.nextLine();
				int id = inputInt-1;
				messarr.get(id).addChild(new Reply(currentUser.getUsername(),"Re: " +messarr.get(id).getSubject(),"\""+input+"\"",idNumber));
				messarr.add(new Reply(currentUser.getUsername(),"Re: " +messarr.get(id).getSubject(),"\""+input+"\"",idNumber));
				break;
			}
		}
		run();
	}

	// This function allows the user to change their current password.
	// The user is asked to provide the old password of the currentUser.
	// 		If the received password matches the currentUser password, then the user will be prompted to enter a new password.
	// 		If the received password doesn't match the currentUser password, then the user will be prompted to re-enter the password. 
	// 		The user is welcome to enter 'c' or 'C' to cancel the setting of a password and return to the menu.
	// Any password is allowed except 'c' or 'C' for allowing the user to quit out to the menu. 
	// Once entered, the user will be told "Password Accepted." and returned to the menu.
	private void setPassword(){
		while(true){
		Scanner input = new Scanner(System.in);
		System.out.print("Input old password (Press 'C' or 'c' to stop): ");
		String inputs = input.nextLine();
		String copyInput;
		if(inputs.equals("C")||inputs.equals("c"))
		{
			run();
			return;
		} else if(inputs.equals(currentUser.getPassword())){
			copyInput = inputs;
			System.out.println("Input new password: ");
			inputs = input.nextLine();
			currentUser.setPassword(copyInput,inputs);
			break;
		}
		System.out.println("Invalid password");
	}
	}

}
