import pkg.*;
import java.util.*;


public class main {
		
		public static void main(String[] args){
			System.out.print(checkPalindrome(121));
			System.out.print(checkPalindrome(123));
			System.out.print(checkPalindrome(-121));
		}

		public static boolean checkPalindrome(int x){
			boolean returnval = true;
			if(x<0){
				return false;
			}
			double convert = (double)x;
			int counter = 0;
			double mod = 10;
			while(true){
				if((convert%mod)>-0.1){
					counter++;
				} else{
					break;
				}
				mod+=10;
			}
			int[] nums = new int[counter];
			int modulo = 10;
			for(int i = nums.length;i>0;i++){
				nums[i] = x%modulo;
			}
			int ifOdd = 0;
			if(nums.length/2!=0){
				ifOdd = 1;
			}
			for(int g = 0; g<(nums.length/2)-ifOdd;g++){
				if(nums[g+1]-nums[g-1]==0){
					returnval = true;
				}
				else{
					return false;
				}
			}
			return returnval;
		}
      
}
