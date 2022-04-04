package GoogleChalange.GoogleChalange;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;



public class Solution1 
{
	
	public static int maxSize = 1;
	public static List<Integer> output=new ArrayList<Integer>();  
	
	
	
	public static int[] solution(int area) {
    
    	int tmp;
    	    while(area >= 1)
    	    {
    	    	tmp=highestSizeSqPannel (area);
    	    	output.add(tmp);
    	    	area= area-tmp;
    	    }
    	    int[] out = output.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
			return out;

    }
    
    public static int highestSizeSqPannel(int totalAreaLeft)
    {
    	int a=1;
    	int b=1;
    	while (b<=totalAreaLeft) {
    		maxSize=b; 
    		a++;
    		b=a*a;
    	}
    	return maxSize;
    }
    
	
	  @Test 
	  public void tests() { 
		  System.out.println(solution(15324));
		  
	  }
	 
}
