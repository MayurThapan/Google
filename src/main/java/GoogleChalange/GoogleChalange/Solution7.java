package GoogleChalange.GoogleChalange;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Solution7 
{
	
	private static String a;
	private static String XOR = "00000000000000000000000000000000";
	
    public static int solution(int start, int length) {
    	
    	a= null;
    	int i,j;
    	int counter=length+1;
    	for (i=length ; i> 0; i-- )
    	{for (j=1;j<length+1;j++){
    		if (counter > j && start <=2000000000) {
    		
    			a= String.format("%32s", Integer.toBinaryString(start)).replaceAll(" ", "0");
//    		System.out.println(a);
//    		System.out.println(Integer.parseInt(a, 2));
    		XORofStringList();
    		}
    		start++;
    		}
    		counter --;
    	}
    	System.out.println(XOR);
    	System.out.println(Integer.parseInt(XOR, 2));
    	return Integer.parseInt(XOR, 2);
    }
    
	  private static void XORofStringList() {
		
		 
		String tmp1 = null;
		String tmp2 = null;
		for (int i = 0; i < 32; i++) {
			
			if ( Character.toString(a.charAt(i)).equals("0") &&  Character.toString(XOR.charAt(i)).equals("0") )
				tmp1 = "0";
			if ( Character.toString(a.charAt(i)).equals("0") &&  Character.toString(XOR.charAt(i)).equals("1") )
				tmp1 = "1";
			if ( Character.toString(a.charAt(i)).equals("1") &&  Character.toString(XOR.charAt(i)).equals("0") )
				tmp1 = "1";
			if ( Character.toString(a.charAt(i)).equals("1") &&  Character.toString(XOR.charAt(i)).equals("1") )
				tmp1 = "0";	
			
			if (tmp2==null) tmp2=tmp1;
			else tmp2=tmp2+tmp1;
		  }
		XOR=tmp2;
	}
	  
		@Test 
		  public void tests() { 
			  solution(1999999999,2);
		  }
    
}


