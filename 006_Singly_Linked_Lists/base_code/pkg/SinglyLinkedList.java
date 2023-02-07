package pkg;
import java.util.Scanner;
import java.util.Random;


public class SinglyLinkedList {
	Node head;

	/* 
		Postcondition: The head will be null 
	*/
	public SinglyLinkedList() {
		head = null;
	}

	/* 
		Receives an integer position, searches through the SinglyLinkedList for the position and returns the data at that positon
	   	If the position doesn't exist, it returns -1
	*/ 
	public int get(int pos){
		Node temp;
		temp = head;
		int count = 0;
		while(count<pos){
			if(temp.getNext() == null){
				return -1;
			}
			temp = temp.getNext();
			count++;
		}
		return temp.getData();
	}

	/*
		Insert a new Node at the given position with the data given
	*/
	public void insert(int pos, int data){
		Node temp;
		Node insert = new Node(data);
		if(head == null){
			head = insert;
			return;
		}
		// if(pos == 0)
		// {
		// 	insert.setNext(head);
		// 	return;
		// }
		temp = head;
		int count = 0;
		while(count<pos-1){
			if(temp.getNext() == null){
				temp.setNext(insert);
				return;
			}
			temp = temp.getNext();
			count++;
		}

		Node getNext = temp.getNext();
		temp.setNext(insert);
		insert.setNext(getNext);
	}

	/*
		Remove the node at the given position
		If no position exists, don't change the list
	*/
	public void remove(int pos){
		Node temp;
		temp = head;
		int count = 0;
		while(count<pos-1){
			if(temp.getNext() == null){
				return;
			}
			temp = temp.getNext();
			count++;
		}
		temp.setNext(temp.getNext().getNext());
	}

	/*
		Swap two Nodes with the two positions given
	*/
	public void swap(int pos1, int pos2){
		Node temp1;
			temp1 = head;
			int count1 = 0;
			while(count1<pos1-1){
				if(temp1.getNext() == null){
					return;
				}
				temp1 = temp1.getNext();
				count1++;
			}
		Node temp2;
		temp2 = head;
		int count2 = 0;
		while(count2<pos2-1){
			if(temp2.getNext() == null){
				return;
			}
			temp2 = temp2.getNext();
			count2++;
		}
	
		Node temp3 = temp1.getNext();
		Node temp4 = temp2.getNext();
		Node temp5 = temp3.getNext();
		Node temp6 = temp4.getNext();
		temp1.setNext(temp4);
		temp2.setNext(temp3);
		temp4.setNext(temp5);
		temp3.setNext(temp6);
		}

	/*
		Print all data values in the LinkedList 
	*/
	public void printList(){
		Node temp = head;  
		int counter = 0; 
		System.out.println("---------------------------------");
		while(true)   
		{ 
			if(temp.getNext() != null)  
			{
				System.out.print(temp.getData() + " ");
			}
			else
			{
				break;
			}
			    counter++;
			    temp = temp.getNext(); 
			}
			System.out.println();
	}
}
