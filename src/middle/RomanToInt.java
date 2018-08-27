package middle;

public class RomanToInt {
	public int romanToInt(String s) {
		
		int result = 0;
        while(s.startsWith("M")){
        	result = result + 1000;
        	s = s.substring(1);
        }
        if(s.startsWith("CM")){
        	result = result + 900;
        	s = s.substring(2);
        }else if(s.startsWith("DCCC")){
        	result = result + 800;
        	s = s.substring(4);
        }else if(s.startsWith("DCC")){
        	result = result + 700;
        	s = s.substring(3);
        }else if(s.startsWith("DC")){
        	result = result + 600;
        	s = s.substring(2);
        }else if(s.startsWith("D")){
        	result = result + 500;
        	s = s.substring(1);
        }else if(s.startsWith("CD")){
        	result = result + 400;
        	s = s.substring(2);
        }else{
        	while(s.startsWith("C")){
        		result = result + 100;
            	s = s.substring(1);
        	}
        }
        
        
        if(s.startsWith("XC")){
        	result = result + 90;
        	s = s.substring(2);
        }else if(s.startsWith("LXXX")){
        	result = result + 80;
        	s = s.substring(4);
        }else if(s.startsWith("LXX")){
        	result = result + 70;
        	s = s.substring(3);
        }else if(s.startsWith("LX")){
        	result = result + 60;
        	s = s.substring(2);
        }else if(s.startsWith("L")){
        	result = result + 50;
        	s = s.substring(1);
        }else if(s.startsWith("XL")){
        	result = result + 40;
        	s = s.substring(2);
        }else{
        	while(s.startsWith("X")){
        		result = result + 10;
            	s = s.substring(1);
        	}
        }
        
        if(s.startsWith("IX")){
        	result = result + 9;
        	s = s.substring(2);
        }else if(s.startsWith("VIII")){
        	result = result + 8;
        	s = s.substring(4);
        }else if(s.startsWith("VII")){
        	result = result + 7;
        	s = s.substring(3);
        }else if(s.startsWith("VI")){
        	result = result + 6;
        	s = s.substring(2);
        }else if(s.startsWith("V")){
        	result = result + 5;
        	s = s.substring(1);
        }else if(s.startsWith("IV")){
        	result = result + 4;
        	s = s.substring(2);
        }else{
        	while(s.startsWith("I")){
        		result = result + 1;
            	s = s.substring(1);
        	}
        }
        
        
        
        return result;
        
        
        
        
        
        
    }
}
