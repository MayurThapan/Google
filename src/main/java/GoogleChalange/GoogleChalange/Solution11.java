package GoogleChalange.GoogleChalange;

import java.util.stream.IntStream;
import java.util.StringJoiner; 

public class Solution11
{
	
	private static int count=0;
	private static String output = "0";
	private static String tempxplus;
	private static String tempxminus;
	private static int outputint;
	private static int a;
	private static int carry = 0;
	private static int internalcountPlus=0;
	private static int internalcountMinus=0;
	private static String maxstring="9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";

	public static int solution (String x) {
		
		if (x.equals(maxstring))
		{
			x=NewNumberMinus(x);
			count++;
		}
		
		
		while (!x.equals("1"))	
		{

			
			if ((Character.getNumericValue(x.charAt(x.length() - 1)) % 2 )==0 )
			{
			x=NewNumber(x);
			count++;
			}
			
			
			else {
				internalcountPlus=0;
				tempxplus=NewNumberplus(x);
				internalcountPlus++;
				while ((Character.getNumericValue(tempxplus.charAt(tempxplus.length() - 1)) % 2 )==0)
				{
					tempxplus=NewNumber(tempxplus);
					internalcountPlus++;
					
				}
				internalcountMinus=0;
				tempxminus=NewNumberMinus(x);
				internalcountMinus++;
				while ((Character.getNumericValue(tempxminus.charAt(tempxminus.length() - 1)) % 2 )==0)
				{
					tempxminus=NewNumber(tempxminus);
					internalcountMinus++;
					
				}
				
				if (internalcountPlus < internalcountMinus  ) 
				{
					x=tempxplus;
					count=count+internalcountPlus;
				}else 
				{
					x=tempxminus;
					count=count+internalcountMinus;
				}
				
			}
			
		}
		
		return	count;
	}


	public static String NewNumber(String x)
	{
		StringJoiner newNumber = new StringJoiner("");
		IntStream stream3 = x.chars();
		
		stream3.forEach(i -> 
		{
			a=(Character.getNumericValue(i));
			newNumber.add(output);
			outputint=(a + carry*10) /2;
			output = Integer.toString(outputint) ;
			carry = (a + carry*10) % 2;
		
		});
		newNumber.add( Integer.toString(outputint+carry) );
		output = "0";
		carry = 0;
		
		return newNumber.toString().replaceFirst("^0+(?!$)", "");
		
	}
	


	
	public static String NewNumberplus(String x )
	{
		String a="1";
		StringJoiner newNumber = new StringJoiner("");

		if (	Character.getNumericValue(x.charAt(x.length() - 1)) != 9		)
		{
			 a=x.substring(0, (x.length() - 1)) ;
			String b= Integer.toString (Character.getNumericValue(x.charAt(x.length() - 1))  +1) ;
			x=a+b;
			
		} else
		{
			int i;
			for ( i=x.length()-1;i>=0;i--  )
			{
				
				if (Character.getNumericValue(x.charAt(i)) == 9)
					newNumber.add("0");
				else break;
				
			}
			
			if (i<0) x= a+ newNumber.toString();
			if (i==0){
				a= Integer.toString(Character.getNumericValue(x.charAt(i))+1);
				
					}
			if (i>0){
					a= x.substring(0, (i)) + Integer.toString(Character.getNumericValue(x.charAt(i))+1) ;
			}
			
			x= a+ newNumber.toString();
		}
		return x;
	}
	
	public static String NewNumberMinus(String x )
	{
		String a="1";
		StringJoiner newNumber = new StringJoiner("");

		if (	Character.getNumericValue(x.charAt(x.length() - 1)) != 0		)
		{
			 a=x.substring(0, (x.length() - 1)) ;
			String b= Integer.toString (Character.getNumericValue(x.charAt(x.length() - 1))  -1) ;
			x=a+b;
			
		} else
		{
			int i;
			for ( i=x.length()-1;i>=0;i--  )
			{
				
				if (Character.getNumericValue(x.charAt(i)) == 0)
					newNumber.add("9");
				else break;
				
			}
			
			if (i==0){
				x= (Integer.toString(Character.getNumericValue(x.charAt(i))-1) + newNumber.toString()).toString().replaceFirst("^0+(?!$)", "");
			}
					
			if (i>0){
					a= x.substring(0, (i)) + Integer.toString(Character.getNumericValue(x.charAt(i))-1) ;
					x= a+ newNumber.toString();
			}
			
			
		}
		return x;
}

}


