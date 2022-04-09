package GoogleChalange.GoogleChalange;

public class Solution8 
{
	
	private static String a;
	private static String xor = null;
	private static int stringSize;
	
    public static int solution(int start, int length) {
    	int i;
    	int j;
    	int counter=length+1;
    	for (i=length ; i> 0; i-- )
    	{for (j=1;j<length+1;j++){
    		if (counter > j && start <=2000000000) {
    			a= Integer.toBinaryString(start);
    			if (xor==null)
    				xor=a;
    			else {
	    				stringSize= a.length();
	        			if (xor.length() > stringSize)
	        			{
	        				stringSize= xor.length();
	        				a= String.format("%1$" + stringSize + "s", a).replace(' ', '0');
	        				
	        			}	
	      			
	        			else xor= String.format("%1$" + stringSize + "s", xor).replace(' ', '0');
	       			 XORofStringList();
    			}
    		
    		}
    		start++;
    		}
    		counter --;
    	}
    	return Integer.parseInt(xor, 2);
    }
    
	  private static void XORofStringList() {
		
		 
		String tmp1 = null;
		String tmp2 = null;
		for (int i = 0; i < stringSize; i++) {
			
			if ( Character.toString(a.charAt(i)).equals("0") &&  Character.toString(xor.charAt(i)).equals("0") )
				tmp1 = "0";
			else if ( Character.toString(a.charAt(i)).equals("0") &&  Character.toString(xor.charAt(i)).equals("1") )
				tmp1 = "1";
			else if ( Character.toString(a.charAt(i)).equals("1") &&  Character.toString(xor.charAt(i)).equals("0") )
				tmp1 = "1";
			else if ( Character.toString(a.charAt(i)).equals("1") &&  Character.toString(xor.charAt(i)).equals("1") )
				tmp1 = "0";	
			
			if (tmp2==null) tmp2=tmp1;
			else tmp2=tmp2+tmp1;
		  }
		xor=tmp2;
	}
	  

		  public void tests() { 
			System.out.println( solution(17,4));
		  }
    
}


