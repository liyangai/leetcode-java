package middle;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSUm {
	 public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
			Arrays.sort(numbers);
			ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
			dfs(ret, new ArrayList<Integer>(), numbers, 0, target);
			return ret;
		}
		
		private void dfs(ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> condidate, int[] numbers, int curIndex,
				int target) {
		    // �Ժ���n���ͣ�ֻҪ��������ܽ��������4��Ϊ3����Ϊ5
			if (condidate.size() == 4) {
				int total = getSum(condidate);
				if (total == target) {
					ret.add(new ArrayList<>(condidate));
				}
				return;
			}
			if (curIndex > numbers.length - 1) {
				return;
			}
			for (int i = curIndex; i < numbers.length; i++) {
			    // �����һ�������֣�ֱ�Ӻ��ԣ���������ظ��Ĵ�
				if (i != curIndex && numbers[i] == numbers[i - 1]) {
					continue;
				}
				condidate.add(numbers[i]);
				// ����Ѿ�����target�����ҵ�ǰ���ִ���0����ѭ������ȥ�Ѿ�û�������ˣ���Ϊֻ�����ֱ��return
//				if (getSum(condidate) > target && numbers[i] > 0) {
//					if (!condidate.isEmpty()) {
//						condidate.remove(condidate.size() - 1);
//					}
//					return;
//				}
				dfs(ret, condidate, numbers, i + 1, target);
				if (!condidate.isEmpty()) {
					condidate.remove(condidate.size() - 1);
				}
			}
		}
	 
		private int getSum(ArrayList<Integer> condidate) {
			int total = 0;
			for (Integer num : condidate) {
				total += num;
			}
			return total;
		}
		public static void main(String[] args) {
			FourSUm test = new FourSUm();
			int[] a = { 1, 0, -1, 0, -2, 2 };
			test.fourSum(a, 0);
		}

}
