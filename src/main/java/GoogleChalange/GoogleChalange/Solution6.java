package GoogleChalange.GoogleChalange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;


public class Solution6 
{
    public static int solution(int start, int length) {
    	
		/*
		 * int input = 10; String result = Integer.toBinaryString(input); String
		 * resultWithPadding = String.format("%32s", result).replaceAll(" ", "0");
		 */
    	List<String> set=new ArrayList<String>();
    	
	//    	set.add("01110");
	//    	set.add("01101");
	//    	set.add("10010");
    	
    	int i,j;
    	int counter=length+1;
    	for (i=length ; i> 0; i-- )
    	{
    		for (j=1;j<length+1;j++)
    		{
    		if (counter > j)
    			
    //			set.add(Integer.toString(start));
    		set.add(String.format("%32s", Integer.toBinaryString(start)).replaceAll(" ", "0"));
    		
    		start++;
    		
    		}
    		counter --;
    	}
    		
    	
    	
    	
    	int XOR = XORofStringList(set);
    	
    //	System.out.println(resultWithPadding);
    	return 1;
    }
    
	  private static int XORofStringList(List<String> set) {
		// TODO Auto-generated method stub
		String tmpstring;
		StringBuffer output = new StringBuffer(32);
		for (int i = 0; i < 32; i++) {
			
			tmpstring=null;
			
		  for (String s:set)
		  {
				  if (tmpstring == null) tmpstring = Character. toString(s.charAt(i));
				  else
				  tmpstring=tmpstring+ Character. toString(s.charAt(i));
		  }
		  int count = (int) tmpstring.chars().filter(ch -> ch == '1').count();
		  if (count == 0)
			  output.append("0");
		  else if (count % 2 == 0)
			  output.append("0");
		  else if (count % 2 != 0)output.append("1");
		}
		  
		System.out.println(output.toString());
		System.out.println(Integer.parseInt(output.toString(), 2));
		return Integer.parseInt(output.toString(), 2);
	}

	@Test 
	  public void tests() { 
		  solution(0,3);
	  }
	 
    
}


