package middle;

import java.util.ArrayList;
import java.util.List;

public class MergeArea {
	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
	
	 public List<Interval> merge(List<Interval> intervals) {
		 List<Interval> re = new ArrayList<>();
		 if(intervals.size() == 0) return re;
		 Interval[] par = new Interval[intervals.size()];
		 intervals.toArray(par);
		 quickSortInterval(par,0,par.length-1);
		 int startIndex = 0;
		 Interval temp = new Interval(par[0].start,par[0].end);
		 for(int i = 1;i<par.length;i++){
			 if(par[i].start<=temp.end){
				 temp.end = Math.max(par[i].end,  temp.end);
			 }else{
				 re.add(temp);
				 temp = new Interval(par[i].start,par[i].end);
			 }
		 }
		 re.add(temp);
		 return re;
		 
	  }

	private void quickSortInterval(Interval[] par,int l,int r) {
		if(r-l<=1) return;
		int start = l;
		int end = r;
		Interval temp = par[start];
		
		while(end>start){
			while(end>start&&par[end].start>=temp.start){
				end --;
			}
			if(end>start){
				par[end] = par[start];
				start ++;
			}
			while(end>start&&par[start].start<temp.start){
				start ++;
			}
			if(end>start){
				par[start] = par[end];
				end --;
			}
			
		}
		par[start] = temp;
		quickSortInterval(par,l,start-1);
		quickSortInterval(par,start+1,r);
		
		
	}

	public static void main(String[] args) {
		MergeArea test = new MergeArea();
		Interval i2 = test.new Interval(1,4);
		Interval i1 = test.new Interval(0,4);

		List<Interval> intervals = new ArrayList<>();
		intervals.add(i1);
		intervals.add(i2);
		List<Interval> re = test.merge(intervals);
		System.out.println('a');
	
	}
	
	
}
