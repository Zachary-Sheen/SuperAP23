import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;

class main {
	public static void main(String args[]) {
		ArrayList<Node> nodeList = new ArrayList<Node>();
		Node baseNode = new Node((int)(Math.random()*100));
		nodeList.add(baseNode);
		baseNode.setNext(new Node((int)(Math.random()*100)));
		for(int i = 0; i<=100;i++)
		{
			int random = (int)(Math.random()*100);
			nodeList.add(nodeList.get(i).getNext());
			if(i != 100){
			Node nextNode = new Node(random);
			nodeList.get(i+1).setNext(nextNode);
			System.out.println(nextNode.getData());
			}
		}

		for(int print = 0; print < nodeList.size();print++){
			System.out.println(nodeList.get(print).getData());
		}

		/*
			Create an ArrayList of 100 Nodes
			Store random integers in each of them
			Print out all of the values
		*/
		

	}
}
