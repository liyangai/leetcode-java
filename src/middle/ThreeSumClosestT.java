package middle;

import java.util.Arrays;

public class ThreeSumClosestT {
	 public int threeSumClosest(int[] nums, int target) {
		 Arrays.sort(nums);
		 int resultAbs = Integer.MAX_VALUE;
		 int resultTotal = Integer.MAX_VALUE;
		 for(int i = 0 ;i<nums.length;i++){
			 if(i>0&&nums[i]==nums[i-1]) continue;
			 int left = i+1;
			 int right = nums.length -1;
			 while(right>left){
				 if(left>i+1&&nums[left]==nums[left-1]){
					 left++;
					 continue;
				 }else if(right<nums.length-1 && nums[right]==nums[right+1]){
					 right --;
					 continue;
				 }else{
					 int total = nums[i] + nums[left]+ nums[right];
					 if(Math.abs(total-target)<resultAbs){
						 resultAbs = Math.abs(total-target);
						 resultTotal = total;
					 }
					 if(total>target){
						 right --;
					 }else if(total < target){
						 left ++;
					 }else{
						 return total;
					 }
				 }
			 }
		 }
		 return resultTotal;
		 
	 }
}
