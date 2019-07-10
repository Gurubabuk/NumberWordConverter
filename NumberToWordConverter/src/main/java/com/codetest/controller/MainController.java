package com.codetest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codetest.exceptions.InvalidNumberException;
import com.codetest.services.NumberToWordService;
import com.codetest.validate.NumberValidator;

@Controller
public class MainController {
	@Autowired
	private NumberToWordService numtowordService;
	
	@Autowired
	private NumberValidator numberValidator;
	@RequestMapping("/")
	public String home() {
		return "home";
		
	}

	@RequestMapping("number")
	public @ResponseBody String convert(@RequestParam("number")String orgNumber,Model m ) {
		String result="";	
			
			try {
				String newNum=orgNumber.replaceAll(",", "");		
				numberValidator.validateNumber(newNum);
				Integer number=Integer.parseInt(newNum);
				result=numtowordService.numberToWord(number);				
			
			}catch(InvalidNumberException e) {
				return e.getMessage();
			}catch(Exception e) {		
				return "Please enter valid number"; 
			}
		
		return result;
	}

}
