/*Heather Marcolino da Silva
 * SNHU CS-320 
 * 03-20-2023 */

package ProjectOne;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.ArrayList;

public class ContactService extends Contact {
	public ContactService(String contactID, String firstName, String lastName, String phone, String address) {
		super(contactID, firstName, lastName, phone, address);
		// TODO Auto-generated constructor stub
	}
	//variables for this class
	protected String contactId = createRandomContactId();
	protected String firstName;
	protected String lastName;
	protected String contactAddress;
	protected String contactNumber;
		
	//creates array list for contacts
	public static ArrayList<Contact> contactList = new ArrayList<Contact>(0);
	//method to add contact to the Array
	public static void addContact( String firstName, String lastName, String phone, String address) {
		String contactID = createRandomContactId();
		
		Contact ContactA = new Contact(contactID, firstName, lastName, phone, address);
		contactList.add(ContactA);
	}
	public static void deleteContact(String contactID) {
		for (int i = 0; i < contactList.size(); ++i) {
			if(contactID.compareTo(contactList.get(i).getID()) == 0) {
				contactList.remove(i);
			}
		}
	}
	
	public static void updateFirst(String contactID, String firstName) {
		for (int i = 0; i < contactList.size(); ++i) {
			if (contactID.equals(contactList.get(i).getID())) {
				contactList.get(i).setfirstName(firstName);
			}
		}
	}
	public static void updateLast(String contactID, String lastName) {
		for (int i = 0; i < contactList.size(); ++i) {
			if(contactID.compareTo(contactList.get(i).getID()) == 0) {
				contactList.get(i).setlastName(lastName);
			}
		}
	}
	public static void updatePhone(String contactID, String phone) {
		for (int i = 0; i < contactList.size(); ++i) {
			if(contactID.compareTo(contactList.get(i).getID()) == 0) {
				contactList.get(i).setPhone(phone);
			}
		}
	}
	public static void updateAddress(String contactID, String address) {
		for (int i = 0; i < contactList.size(); ++i) {
			if(contactID.compareTo(contactList.get(i).getID()) == 0) {
				contactList.get(i).setaddress(address);
			}
		}
	}
}
