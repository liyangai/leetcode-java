package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum3 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		
		Arrays.sort(nums);
		def(nums, target, re, new ArrayList<Integer>(), 0);

		return re;
	}

	private void def(int[] nums, int target, List<List<Integer>> re, List<Integer> con, int index) {
		
		if (con.size() == 4) {
			if (getSum(con) == target) {
				re.add(new ArrayList<Integer>(con));
			}
			return;
		}
		if (index >= nums.length)
			return;
		for (int i = index; i < nums.length; i++) {
			if (i > index && nums[i] == nums[i - 1]){
				continue;
			}
				
			con.add(nums[i]);
			def(nums, target, re, con, i + 1);
			if (!con.isEmpty()) {
				con.remove(con.size() - 1);
			}
		}
	}

	private int getSum(List<Integer> l) {
		int re = 0;
		for (int i : l) {
			re = re + i;
		}
		return re;
	}

	public static void main(String[] args) {
		FourSum3 test = new FourSum3();
		int[] a = { 1, 0, -1, 0, -2, 2 };
		test.fourSum(a, 0);
	}
}
