package com.codetest.testcase;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.codetest.services.NumberToWordService;

@RunWith(Parameterized.class)
public class NumberToWordTestCases {
		//Passing test Data 
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
        	{ "Zero", 0 },
        	{ "Sixty-seven Thousand five HUNDRED", 67500 },
        	{ "one hundred thousand", 100000 },
            { "six hundred seventy-eight thousand nine hundred", 678900 },
            { "one hundred thousand five hundred sixty-seven", 100567 },
            { "four thousand five hundred eighty-nine", 4589 },
            { "three thousand three hundred thirty-three", 3333 },
            { "seventy-two", 72 },
            { "one hundred seventy-two thousand three hundred forty-six", 172346 },
            { "eight hundred ninety thousand", 890000 },
            { "six hundred thousand seven hundred", 600700 },
            { "sixty-seven", 67 },
            { "nine hundred ninety-nine million nine hundred ninety-nine thousand nine hundred ninety-nine", 999999999 } 
           });
    }

    private Integer input;
    private String expected;
    
    //This constructor must be provided for the parameterized tests to work.
    public NumberToWordTestCases(String expected,Integer input) {
        this.input = input;
        this.expected = expected;
    }
    
	

    @Test
    public void NumberToWordTest() {
    	NumberToWordService c=new NumberToWordService();
        assertEquals(expected.toLowerCase(), c.numberToWord(input).toLowerCase());
        
    }

}

