package midsem.q3;

import java.util.Scanner;

public class PincodeVerifier {

	public boolean verifyPincode(String pincode) throws IncorrectPincodeException {
		boolean pincodeFlag = true;
		
		if (pincode == null) {
			pincodeFlag = false;
			throw new IncorrectPincodeException("pincode is null");
		}
		else if (pincode.length() == 0) {
			pincodeFlag = false;
			throw new IncorrectPincodeException("pincode is empty");
		}
		else if (pincode.length() < 6) {
			pincodeFlag = false;
			throw new IncorrectPincodeException("pincode length is less than 6");
		}
		else if (pincode.length() > 6) {
			pincodeFlag = false;
			throw new IncorrectPincodeException("pincode length is more than 6");
		}
		else if (pincode.charAt(0) == '0') {
			pincodeFlag = false;
			throw new IncorrectPincodeException("pincode begins with a 0");
		}
		
		for(int i = 0; i < pincode.length(); i++) {
			if (pincode.charAt(i) >= '0' && pincode.charAt(i) <= '9')
				pincodeFlag = true;
			else {
				pincodeFlag = false;
				throw new IncorrectPincodeException("pincode does not have numeric digits");
			}
		}
		
		return pincodeFlag;
	}
	
	public static void main(String[] args) {
		String pincode;
		Scanner scanner = new Scanner(System.in);
		PincodeVerifier pincodeVerifier = new PincodeVerifier();
		boolean pincodeFlag = false;
		
		while(!pincodeFlag) {
			System.out.println("\nEnter the pincode: ");
			pincode = scanner.nextLine();
			try {
				pincodeFlag = pincodeVerifier.verifyPincode(pincode);
			} catch (IncorrectPincodeException e) {
//				System.out.println(e.getMessage());
				e.printStackTrace();
				System.out.println();
			}
		}
		System.out.println("Done");
	}
}
