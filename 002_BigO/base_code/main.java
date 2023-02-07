import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;


class main {
	static final long createdNano = System.nanoTime();

	public static void main(String args[]) {
		long start = System.nanoTime();
		long finish = System.nanoTime();
		System.out.println("Created: " + createdNano);
		
		int [] times = {10, 100, 1000, 10000, 100000, 1000000, 10000000};
		int [] nums = new int[100];


		System.out.println("-------------------Test-------------------");
		System.out.println("");
		for(int i : times){
			System.out.println("Interval: " + i);
			
			nums = new int[i];
			randomize(nums);
			start = System.nanoTime();

			//  Put your method between these two comments
				randomizeSickSort(nums);
			//

			finish = System.nanoTime();
			System.out.println("Started: " + start);
			System.out.println("Finished: " + finish);
			System.out.println("Duration: " + (finish-start));
			System.out.println("");
		}
	}
	public static void randomize(int[] nums){
		System.out.println(nums.length);
		for(int i = 0; i<nums.length-1;i++){
			nums[i] = (int)(Math.random()*nums.length)+1;
			// System.out.print(nums[i]+"  ");
		}
	}
	public static void randomizeSickSort(int []nums){
		int[] numcopy = new int[100];
		int d = 0;
		for(int i = 0; i<nums.length-1;i++){
			nums[i] = (int)(Math.random()*nums.length);
			numcopy[i] = nums[i];
		}
		while(d<100){
				int rand =(int)(Math.random()*nums.length)+1;
				if(numcopy[rand] == -1){
				nums[d] = nums[rand];
				numcopy[rand] = -1;
				d++;
			}
		}
		
	}

	public static void bubbleBaby(int []nums){
		int temp = 0;
		for(int i = 0; i<nums.length;i++){
			for(int d = 0; d<nums.length-i-1;d++){ 
				if(nums[d]>nums[d+1]){ 
					temp = nums[d];
					nums[d] = nums[d+1];
					nums[d+1] = temp;
				}
			}
		}
	}
	public static void Insertion(int[] nums){
		int i;
		int key;
		int j;
		for(i = 1; i<nums.length ;i++){
			key = nums[i];
			j = i-1;
				while(j>=0 && nums[j]> key){
					nums[j+1] = nums[j];
					j = j-1;
				}
				nums[j+1] = key;
		}
	}
	public static void selectionSort(int[] arr){  
        for (int i = 0; i < arr.length - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < arr.length; j++){  
                if (arr[j] < arr[index]){  
                    index = j;//searching for lowest index  
                }  
            }
        }
    }  
}
