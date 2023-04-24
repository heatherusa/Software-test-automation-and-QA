/*Heather Marcolino da Silva
 * SNHU CS-320 
 * 03-20-2023 */

package ProjectOne;

import java.nio.charset.Charset;
import java.util.Random;

public class Contact {
	// variables
	private String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
		
		//checks parameters and throws illegal argument exception if either criteria is met
		if (contactID.length() >10 || contactID == null) {
			throw new IllegalArgumentException("ContactId Invalid");
		}
		
		else if (firstName.length() >10 || firstName == null) {
			throw new IllegalArgumentException("First Name is Invalid");
		}

		else if (lastName.length() > 10 || lastName == null) { 
			throw new IllegalArgumentException("Last Name is Invalid");
		}

		else if (phone.length() != 10 || phone == null) {
			throw new IllegalArgumentException("Phone Number is Invalid");
		}
		
		else if(address.length() > 30 || address == null) {
			throw new IllegalArgumentException("Address is Invalid");
		}
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		
} 
	public String getID() {
		return contactID;
	}
	
	public String getfirstName() {
		return firstName;
	}
	
	public String getlastName() {
		return lastName;
	}
	
	public String getphone() {
		return phone;
	}
	
	public String getaddress() {
		return address;
	}
	
	public void setfirstName(String first) {
		if (first == null || first.length()>10) {
			throw new IllegalArgumentException("First Name is Invalid");
		}
		else {
			this.firstName = first;
		}
	}
	
	public void setlastName(String last) {
		if (last == null || last.length()>10) {
			throw new IllegalArgumentException("Last Name is Invalid");
		}
		else {
			this.lastName = last;
		}
	}
	
	public void setPhone(String phoneNum) {
		if (phoneNum.length() !=10 || phoneNum == null) {
			throw new IllegalArgumentException("Phone is Invalid");
		}
		else {
			this.phone = phoneNum;
		}
	}
	public void setaddress(String addressNew) {
		if (addressNew.length()>30 || addressNew == null) {
			throw new IllegalArgumentException("Address is Invalid");
		}
		else {
			this.address = addressNew;
		}
	}
	
	//Creates a random ContactId  
	public static String createRandomContactId() {
	    byte[] array = new byte[10]; // length is bounded by 10
	    new Random().nextBytes(array);
	    String generatedString = new String(array, Charset.forName("UTF-8"));
	    
	    return generatedString;
	}
	
}