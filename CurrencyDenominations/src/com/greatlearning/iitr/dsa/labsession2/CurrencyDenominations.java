package com.greatlearning.iitr.dsa.labsession2;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class CurrencyDenominations {
	   public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Get input from user
	        System.out.print("Enter the size of currency denominations: ");
	        int size = scanner.nextInt();
	        int[] denominations = new int[size];
	        System.out.print("Enter the currency denominations value: ");
	        for (int i = 0; i < size; i++) {
	            denominations[i] = scanner.nextInt();
	        }
	        System.out.print("Enter the amount you want to pay: ");
	        int amount = scanner.nextInt();

	        // Sort the denominations in descending order
	        Arrays.sort(denominations);
	        for (int i = 0; i < denominations.length / 2; i++) {
	            int temp = denominations[i];
	            denominations[i] = denominations[denominations.length - i - 1];
	            denominations[denominations.length - i - 1] = temp;
	        }

	        // Make the payment using the higher denominations first
	        Map<Integer, Integer> payment = new HashMap<>();
	        for (int i = 0; i < denominations.length; i++) {
	            int count = 0;
	            while (amount >= denominations[i]) {
	                amount -= denominations[i];
	                count++;
	            }
	            if (count > 0) {
	                payment.put(denominations[i], count);
	            }
	            if (amount == 0) {
	                break;
	            }
	        }

	        // Print the payment approach in ratio
	        System.out.println("Your payment approach in order to give min no of notes will be");
	        for (int denomination : denominations) {
	            if (payment.containsKey(denomination)) {
	                System.out.println(denomination + ": " + payment.get(denomination));
	            }
	        }

	        scanner.close();
	    }

}
