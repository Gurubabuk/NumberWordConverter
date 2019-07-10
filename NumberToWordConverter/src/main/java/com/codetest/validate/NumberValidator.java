package com.codetest.validate;

import org.springframework.stereotype.Component;

import com.codetest.exceptions.InvalidNumberException;

@Component
public class NumberValidator {
	
	public boolean validateNumber(String input)
	{
		Long number=Long.parseLong(input);
		//Verify if the number is negative
		if (number < 0) { 
			/*The below commented code will return word with minus
			
            // convert the number to a string
            String numberStr = "" + number;
            // remove minus before the number 
            numberStr = numberStr.substring(1);
            // add minus before the number and convert the rest of number
            return "minus " + numberToWord(Integer.parseInt(numberStr));
          
           */ 
			               
							//(or)
			
			//If number is negative we are throwing exception
			throw new InvalidNumberException("Invalid Negative number");		
			            
		} 
		//If number exceed 999,999,999 then throwing exception
		else if(number > 999999999)
		{
			throw new InvalidNumberException("Number is too large,Please enter below 999,999,999");	
		}
		
		return true;
	}
	

}
