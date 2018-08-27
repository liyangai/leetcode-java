package middle;

public class IntToRoman {
	 public String intToRoman(int num) {
	      StringBuilder sb = new StringBuilder();
	   
	      int thrLeval = num/1000;
	      for(int i = 0;i<thrLeval;i++){
	    	  sb.append('M');
	      }
	      num = num - thrLeval*1000;
	      
	      int hundLeval = num/100;
	      
	      switch(hundLeval){
		case 1:
			sb.append('C');
			break;
		case 2:
			sb.append("CC");
			break;
		case 3:
			sb.append("CCC");
			break;
		case 4:
			sb.append("CD");
			break;
		case 5:
			sb.append("D");
			break;
		case 6:
			sb.append("DC");
			break;
		case 7:
			sb.append("DCC");
			break;
		case 8:
			sb.append("DCCC");
			break;
		case 9:
			sb.append("CM");
			default:
				break;
			
	      }
	      
	      num = num - hundLeval*100;
	      
	      int tenLeval = num/10;
	      
	      switch(tenLeval){
			case 1:
				sb.append('X');
				break;
			case 2:
				sb.append("XX");
				break;
			case 3:
				sb.append("XXX");
				break;
			case 4:
				sb.append("XL");
				break;
			case 5:
				sb.append("L");
				break;
			case 6:
				sb.append("LX");
				break;
			case 7:
				sb.append("LXX");
				break;
			case 8:
				sb.append("LXXX");
				break;
			case 9:
				sb.append("XC");
				break;
				default:
					break;
				
		      }
	      
	      num = num - tenLeval*10;
	      
	      int oneLeval = num;
	      switch(oneLeval){
			case 1:
				sb.append('I');
				break;
			case 2:
				sb.append("II");
				break;
			case 3:
				sb.append("III");
				break;
			case 4:
				sb.append("IV");
				break;
			case 5:
				sb.append("V");
				break;
			case 6:
				sb.append("VI");
				break;
			case 7:
				sb.append("VII");
				break;
			case 8:
				sb.append("VIII");
				break;
			case 9:
				sb.append("IX");
				default:
					break;
				
		      }
	      
	      return sb.toString();
	   
	 }
	 
	 public static void main(String[] args) {
		 IntToRoman test = new IntToRoman();
		 int a = 3;
		 System.out.println(test.intToRoman(a));
	}
}
