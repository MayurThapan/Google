package GoogleChalange.GoogleChalange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;


public class Solution3 
{
	
	public static int solution(String n, int b) {
		
		int length=n.length();
		int result;
		List<String> output=new ArrayList<String>();
		String nnew;
		int seqCont=1;
		int number1;
		int number2;
		int[] number1Array  = new int[n.length()];
		int[] number2Array  = new int[n.length()];
		
		while (seqCont > 0)
		{
		number1Array=StringToIntArray(n);
		Arrays.sort(number1Array);
		number2Array= ReverseArray(number1Array,length);

		number1=IntAryTOINT(number1Array);
		number2=IntAryTOINT(number2Array);
				
		result=baseSubstraction(b,number1, number2);
		
		nnew=appendLeadingZero(result,length);
		
		if (result == 0) return 1; 
		
		
		if (output.contains(nnew))
		{
			seqCont=output.indexOf(nnew) ;
			int totalCount = output.size();
			seqCont=totalCount - seqCont;
			return seqCont;
		}
		output.add(nnew);
		n=nnew;
		}
		return 0;

    }
	
	  private static String appendLeadingZero(int result,int length) {
		  String output = Integer.toString(result);
		    while (output.length() < length) output = "0" + output;
		    return output;
	}

	private static int[] ReverseArray(int[] number1Array, int length) {
		  int[] numberArray= new int[length];
			for(int i:number1Array){
				length--;
				numberArray[length]=i;
			}
			return numberArray;
	}

	private static int IntAryTOINT(int[] numberArray) {
		int num=0;
		for(int i:numberArray){
			num =num*10 + i ;
		}
		return num;
	}


	private static int[] StringToIntArray(String n) {
		int[] numberArray= new int[n.length()];
		int i=0;
		for(char r:n.toCharArray()){
			
			numberArray[i]= Character.getNumericValue(r);
			i++;
		}
		return numberArray;
	}

	//	Number2 is bigger than number1
	public static int baseSubstraction(int base, int number1, int number2) {
		    int rv = 0;
		    int c = 0;
		    int p = 1;
		    while (number2 > 0) {
		      int d1 = number1 % 10;
		      int d2 = number2 % 10;
		      number1 = number1 / 10;
		      number2 = number2 / 10;
		      int d = d2 - d1 - c;
		      if (d < 0) {
		        c = 1;
		        d += base;
		      } else {
		        c = 0;
		      }
		      rv += d * p;
		      p = p * 10;
		    }
		    return rv;
		  }

    
	  @Test 
	  public void tests() { 
		  System.out.println(solution("21022",3));
	  }
	 
}
