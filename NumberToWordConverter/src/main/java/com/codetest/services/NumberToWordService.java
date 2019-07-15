package com.codetest.services;

import org.springframework.stereotype.Service;

import com.codetest.constants.HigherConstants;
import com.codetest.constants.TensConstants;
import com.codetest.constants.UnitConstants;

@Service
public class NumberToWordService {

	/*If we need database connection using DAO then we can use below commented code.*/
	// @Autowired
	//private DaoRepository daoRepository;
	 
	
	public String numberToWord(Integer number) {
		StringBuilder words = new StringBuilder();

		if (number == 0) {
			words.append(UnitConstants.values()[number]);
			return words.toString();
		}
		// check if number is divisible by 1 million
		if ((number / 1000000) > 0) {
			words.append(" ").append(numberToWord(number / 1000000)).append(" ").append(HigherConstants.million);
			number %= 1000000;
		}
		// check if number is divisible by 1 thousand
		if ((number / 1000) > 0) {
			words.append(" ").append(numberToWord(number / 1000)).append(" ").append(HigherConstants.thousand);
			number %= 1000;
		}
		// check if number is divisible by 1 hundred
		if ((number / 100) > 0) {
			words.append(" ").append(numberToWord(number / 100)).append(" ").append(HigherConstants.hundred);
			number %= 100;
		}

		if (number > 0) {
			// check if number is within teens
			if (number < 20) {
				// fetch the appropriate value from unit constants
				words.append(" ").append(UnitConstants.values()[number]);
			} else {
				// fetch the appropriate value from tens constants
				words.append(" ").append(TensConstants.values()[number / 10]);
				if ((number % 10) > 0) {
					words.append("-").append(UnitConstants.values()[number % 10]);

				}
			}
		}

		return words.toString().trim();

	}
}
