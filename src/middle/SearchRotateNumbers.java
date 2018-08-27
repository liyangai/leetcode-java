package middle;

public class SearchRotateNumbers {
	public int search(int[] nums, int target) {
		int len = nums.length;
        int left = 0,right = len-1;
        if(len==1){
            if(nums[0]==target) return 0;
            return -1;
        }
        while(right>left){
        	if(nums[left]==target) return left;
    		if(nums[right]==target) return right;
        	if(right-left==1){
        		return -1;
        	}
        	
        	int middle = (left+right)/2;
        	if(nums[middle]==target) return middle;
        	if(nums[right]>nums[left]){
        		if(nums[middle]>target){
        			right = middle;
        		}else{
        			left = middle;
        		}
        	}else{
        		if(nums[right]<target&&nums[left]>target) return -1;
        		if(nums[middle]>nums[left]){
        			if(target>nums[left]&&nums[middle]>target){
        				right = middle;
        			}else{
        				left = middle;
        			}
        		}else{
        			if(target>nums[middle]&&nums[right]>target){
        				left = middle;
        			}else{
        				right = middle;
        			}
        		}
        	}
        	
        }
        return -1;
		
    }
	
	
	public static void main(String[] args) {
		SearchRotateNumbers test = new SearchRotateNumbers();
		int[] nums = {4,5,6,7,0,1,2};
		test.search(nums,0);

	}
	
			

}
