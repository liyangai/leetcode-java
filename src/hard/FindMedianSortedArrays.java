package hard;

public class FindMedianSortedArrays {
	public double findMedianSortedArrays(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		if (m > n) { // to ensure m<=n
			int[] temp = A;
			A = B;
			B = temp;
			int tmp = m;
			m = n;
			n = tmp;
		}
		int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
		while (iMin <= iMax) {
			int i = (iMin + iMax) / 2;
			int j = halfLen - i;
			if (i < iMax && B[j - 1] > A[i]) {
				 iMin = i + 1;// i is too small
			} else if (i > iMin && A[i - 1] > B[j]) {
				iMax = i - 1; // i is too big
			} else { // i is perfect
				int maxLeft = 0;
				if (i == 0) {
					maxLeft = B[j - 1];
				} else if (j == 0) {
					maxLeft = A[i - 1];
				} else {
					maxLeft = Math.max(A[i - 1], B[j - 1]);
				}
				if ((m + n) % 2 == 1) {
					return maxLeft;
				}

				int minRight = 0;
				if (i == m) {
					minRight = B[j];
				} else if (j == n) {
					minRight = A[i];
				} else {
					minRight = Math.min(B[j], A[i]);
				}

				return (maxLeft + minRight) / 2.0;
			}
		}
		return 0.0;
	}

	public double findMedianSortedArrays2(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		
		if (m > n) { // to ensure m<=n
			int[] temp = A;
			A = B;
			B = temp;
			int tmp = m;
			m = n;
			n = tmp;
		}
		if(m==0){
			A = new int[]{B[0],B[n-1]};
			return findMedianSortedArrays2(A,B);
		}
		int mini = 0;
		int maxi = m;
		int halfLen = (m + n + 1) / 2;
		while (mini <= maxi) {
			int i = (maxi+mini)/2;
			int j = halfLen - i;
			if(j>0 && i<m && B[j-1]>A[i]){
				mini = i+1;
			}else if(i>0&& j<n &&  A[i-1]>B[j]){
				maxi = i-1;
			}else{
				int reusltL,resultR;
				if(i==0){
					reusltL = B[j-1];
					if(j==n){
						resultR = A[0];
					}else{
						resultR = Math.min(B[j], A[i]) ;
					}
				}else if(i==m){
					
					if(j-1>=0){
						reusltL =  Math.max(A[m-1], B[j-1]);
					}else{
						reusltL = A[m-1];
					}
					resultR = B[j];
				}else{
					reusltL = Math.max(A[i-1], B[j-1]);
					resultR = Math.min(A[i],B[j]);
				}
				
				if((m+n)%2==1){
					return reusltL;
				}else{
					return (reusltL + resultR)/2.0;
				}
			}
		}

		return 0.0;
	}

	public static void main(String[] args) {
		
		int[] nums1 = new int[]{1,2,4};
		int[] nums2 = new int[]{3};
		FindMedianSortedArrays a = new FindMedianSortedArrays();
		System.out.println( a.findMedianSortedArrays2(nums1, nums2));
//		System.out.println( a.findMedianSortedArrays(nums1, nums2));

	}

}
