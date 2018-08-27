package middle;

import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		int len = nums.length;
		if (len == 0 || len == 1)
			return;

		for (int i = len - 1; i > 0; i--) {
			if (nums[i] == nums[i - 1]) {
				continue;
			} else if (nums[i] > nums[i - 1]) {
				exchange(nums, i, i - 1);
				return;
			} else {
				break;
			}
		}

		boolean hasChanged = false;
		for (int i = len - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				hasChanged = true;
				int propIndex = i + 1;
				for (int j = i + 1; j < len; j++) {
					if (nums[j] > nums[i] && nums[j] <= nums[propIndex]) {
						propIndex = j;
					}
				}

				exchange(nums, i, propIndex);
				for (int k = i + 1; k <= (len + i) / 2; k++) {
					exchange(nums, k, len + i - k);
				}

				break;
			}
		}

		if (!hasChanged) {
			Arrays.sort(nums);
		}

	}

	private void exchange(int[] nums, int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}

	public static void main(String[] args) {
		NextPermutation test = new NextPermutation();
		int[] a = { 2,1,2,2,2,2,2,1 };
		test.nextPermutation(a);

	}

}
