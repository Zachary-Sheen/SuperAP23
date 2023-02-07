import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;

class main {
	public static void main(String args[]) {
		SinglyLinkedList mosquito = new SinglyLinkedList();
		for(int i = 0; i<=20;i++)
		{
			mosquito.insert(0,(int)(Math.random()*10));
		}
		for(int i = 0;i<=20;i++)
		{
			int random = (int)(Math.random()*19);
			mosquito.insert(random,-1);
		}
		
		mosquito.printList();
		int index1 = 0;
		int index2 = 40;
		while(true)
		{
			mosquito.swap(index1,index2);
			if(index1+1 == index2 || index1 == index2)
			{
				break;
			}
			index1++;
			index2--;
		}
		// mosquito.insert(30,100);
		mosquito.printList();
	}
}
