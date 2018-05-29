package RegistrationNumberGenerator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegistrationNumber {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		for(int i = 1 ; i < 3728767; i++) {
			getNthRegistrationNumber("KA51 MJ1234" , i);
		}
		
	}
	
	public static String appendZero(int num) {
		String remString = "";
		if(num < 9) {
			remString = "000" + num;
		}else if(num < 99) {
			remString = "00" + num;
		}else if(num < 999) {
			remString = "0" + num;
		}else {
			remString = "" + num;
		}
		return remString;
	}
	
	private static void getNthRegistrationNumber(String registrationNum, int i) throws IOException, InterruptedException {
		Integer num = Integer.valueOf(registrationNum.substring(7));
		String alphabet1 = registrationNum.substring(5, 7);
		char [] charArr = alphabet1.toCharArray();
		String constantPart = registrationNum.substring(0,4);
		int finalNum = num + i;
		String ans = "";
		if(finalNum >= 0) {
			int div = finalNum / 10000;
			int rem = finalNum % 10000;
			
			if(div == 0) {
				ans = constantPart +" "+ alphabet1 + appendZero(rem);
			}else if(div < 26) {
					int secondAlphabet = (int)(charArr[1]+ div) ;
					if(secondAlphabet > 90) {
						secondAlphabet -= 90;
						secondAlphabet = (secondAlphabet + 64) < 90 ? (secondAlphabet + 64) : 90;
					}
					alphabet1 = charArr[0] + Character.toString ((char) (int)(secondAlphabet)) ;  
					ans = constantPart +" "+ alphabet1 + appendZero(rem);
				}else {
					int newDiv = div/26;
					int newRem = div % 26;
					int newAlphabetAsciiSec = (int)(charArr[1]+ newRem);
					int newAlphabetAsciiOne = (int)(charArr[0]+ newDiv);
					if(newAlphabetAsciiSec > 90) {
						newAlphabetAsciiSec -= 90;
						newAlphabetAsciiSec = (newAlphabetAsciiSec + 64) < 90 ? (newAlphabetAsciiSec + 64) : 90; 
						newAlphabetAsciiOne++;
					}
					if(newAlphabetAsciiOne <= 90) {
						alphabet1 = Character.toString ((char) (int)(newAlphabetAsciiOne)) + Character.toString ((char) (int)(newAlphabetAsciiSec)) ;  
						ans = constantPart +" "+ alphabet1 + appendZero(rem);
					}else {
						
						System.out.println("Invalid Registration Number");
						return;
					}					
				}
			}
			System.out.println(ans);
		}
	}	
	
	

	

