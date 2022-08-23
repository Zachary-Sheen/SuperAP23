package pkg;
import java.util.*;
import java.io.*;

public class Reply extends Message {

	// Default Constructor
	public Reply() {
		super();
	}

	// Parameterized Constructor
	public Reply(String auth, String subj, String bod, int i) {
		String re = "Re: \""+subj + "\"";
		String corr = "\""+bod +"\"";
		super(auth,re,corr,i);
	}

	// Returns if this is a reply (true)
	public boolean isReply(){
		return true;
	}
}
