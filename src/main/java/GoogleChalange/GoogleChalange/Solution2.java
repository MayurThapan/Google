package GoogleChalange.GoogleChalange;

import org.junit.Test;

/**
 * Hello world!
 *
 */
public class Solution2 
{
	
	public static int[] solution(int[] l, int t) {
		
		int[] out= new int[2];
    	
    	int sindex=-1;
    	int eindex=-1;
    	
    	
    	for (int i = 0; i < l.length; i++) {
    		
    		int sum=0;
    		sindex =i;
    		eindex =i;
    		while (sum < t & eindex<l.length)
    		{
    			sum= sum+ l[eindex];
    			eindex++;
    		}
    		if (sum==t) {
        		out[0] =sindex;
        		out[1] =eindex-1;
    			break;
    		}
    		else {
    			out[0] =-1;
    			out[1] =-1;
    		}
    	}
 			return out;

    }
    
	  @Test 
	  public void tests() { 
		  
		  int[] test= {4,3,5,7,8};
		  solution(test,12);
		  
	  }
	 
}
