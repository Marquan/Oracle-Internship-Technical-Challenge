package oracle.intern.tech.challenge.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Challenge1")
public class Challenge1Controller {

	@GetMapping("/minCoins")
	public ResponseEntity<List<Double>> minCoins(@RequestParam double amount,@ RequestParam List<Double> denominations) {
		System.out.println("Amount: "+amount);
		//List<Double> coinValues = new ArrayList<>();
		//coinValues.add(0.01);
		//coinValues.add(0.05);
		//coinValues.add(0.1);
		//coinValues.add(0.2);
		//coinValues.add(0.5);
		//coinValues.add(1.0);
		//coinValues.add(2.0);
		//coinValues.add(5.0);
		//coinValues.add(10.0);
		//coinValues.add(50.0);
		//coinValues.add(100.0);
		//coinValues.add(1000.0);
		return new ResponseEntity<List<Double>>(minCoinsNeedMethod(amount,denominations),HttpStatus.OK);
	}
	
	public static List<Double> minCoinsNeedMethod(double amount, List<Double> coinValues) {
		// sort the coin values in descending order
		Collections.sort(coinValues, Collections.reverseOrder());
		// the list of coins
		List<Double> coinsNeeded = new ArrayList<>();
		// current amount
		double currentAmount = Math.max(amount, 0);
		int i = 0;
		while ((i < coinValues.size()) & (currentAmount != 0)) {
			if (coinValues.get(i) > 0) {
				double valueI = coinValues.get(i);
				// get number of coins needed
				int coinsNeed = (int) Math.floor(currentAmount / valueI);
				// get remainder
				currentAmount = currentAmount - coinsNeed*valueI;
				System.out.println("Number of "+valueI+" needed: "+coinsNeed);
				for (int j = 0; j < coinsNeed; j++) {
					coinsNeeded.add(valueI);
				}
				i += 1;
			}
		}
		Collections.sort(coinsNeeded);
		return coinsNeeded;
	}
	
}
