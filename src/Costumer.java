import java.util.Scanner;

public class Costumer {
	// Class Variables
	private long costumerId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	
	// Constructors
	public Costumer() {
		
	}
	
	public Costumer(String fName, String lName, String email, String pNum) {
		setFirstName(fName);
		setLastName(lName);
		this.email = email;
		phoneNumber = pNum;
	}
	
	// Setters and Getters
	public void setFirstName(String fName) {
		Scanner input = new Scanner(System.in);
		
		if(validName(fName)) {
			firstName = fName;
		} else {
			do {
				System.out.println("Invalid input. Please re-enter first name.\nEnter first name: ");
				firstName = input.nextLine();
			} while (validName(firstName) == false);
		}
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lName) {
		Scanner input = new Scanner(System.in);
		
		if(validName(lName)) {
			lastName = lName;
		} else {
			do {
				System.out.print("Invalid input. Please re-enter last name.\nEnter last name: ");
				lastName = input.nextLine();
			} while (validName(lastName) == false);
		}
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setPhoneNumber(String pNum) {
		Scanner input = new Scanner(System.in);
		
		if(validNumber(pNum)) {
			phoneNumber = pNum;
		} else {
			do {
				System.out.print("Invalid input. Please re-enter email.\nEnter valid phone number: ");
				phoneNumber = input.nextLine();
			} while(validNumber(phoneNumber) == false);
		}
		
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	// Methods
	public boolean validName(String name) {
		char ch;
		
		for (int i = 0; i < name.length(); i++) {
			ch = name.charAt(i);
			if (Character.isDigit(ch)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean validNumber(String number) {
		char ch;
		
		for(int i = 0; i < number.length(); i++) {
			ch = number.charAt(i);
			if (number.length() != 10) {
				return false;
			} else if (!Character.isDigit(ch)) {
				return false;
			}
		}
		return true;
	}
}
