package com.gl.javafsd.dsa.denominations;

public class DenominationsCalculator {
	private int[] denominations;
	private int paymentAmount;
	private Result result;
	
	public DenominationsCalculator(
			int[] denominations, int paymentAmount) {
		
		this.denominations = denominations;
		this.paymentAmount = paymentAmount;	
		
		this.result = new Result();
	}
	
	public Result calculate() {
		
		
		int denominationIndex = 0;
		
		int dividend = paymentAmount;
		
		while (denominationIndex < denominations.length) {
						
			int divisor = denominations[denominationIndex];
			
			// Division operation
			int quotient = dividend / divisor;
			int remainder = dividend % divisor;

			System.out.println(
					"Dividend, Divisor " + dividend + ", " + divisor);			
								
			if (quotient != 0) {
				
				
				
				DenominationInstancesPair pair = 
					new DenominationInstancesPair(divisor, quotient);
				
				result.getDenominationInstancesList().add(pair);
				
				
				dividend = remainder;
			}
			
			if (remainder == 0) {
				
				result.setExactPaymentAchievedOrNot(true);
				break;
			}
			
			
			denominationIndex ++;
		}		
		return result;
	}

}
