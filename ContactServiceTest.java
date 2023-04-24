package Test;

//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

//import ProjectOne.Contact;
import ProjectOne.ContactService;

class ContactServiceTest {

	public String contactID = "0123456789";
	public String first = "Rebecca";
	public String last = "Smith";
	public String phone = "8605249535";
	public String address = "54 White St";
	
	
	@BeforeEach
	void setup() {
		ContactService.contactList.clear();
	}
	
	@Test
	void testContactService() {
		ContactService contactA = new ContactService(contactID, first, last, phone, address);
		assertAll(
			()-> assertTrue(contactA.getID().equals("0123456789")), 
			()-> assertTrue(contactA.getfirstName().equals("Rebecca")),
			()-> assertTrue(contactA.getlastName().equals("Smith")),
			()-> assertTrue(contactA.getphone().equals("8605249535")),
			()-> assertTrue(contactA.getaddress().equals("54 White St")));
	}
	
	@Test
	void testaddContact() {
		
		assertTrue(ContactService.contactList.isEmpty());
		
		ContactService.addContact("Rebecca", "Smith","8605249535", "54 White St");
		
		assertAll(
				()-> assertFalse(ContactService.contactList.isEmpty()),
				()-> assertTrue(ContactService.contactList.get(0).getfirstName().equals("Rebecca")),
				()-> assertTrue(ContactService.contactList.get(0).getlastName().equals("Smith")),
				()-> assertTrue(ContactService.contactList.get(0).getphone().equals("8605249535")),
				()-> assertTrue(ContactService.contactList.get(0).getaddress().equals("54 White St")));
	}
	
	@Test
	void testdeleteContact() {
		
		assertTrue(ContactService.contactList.isEmpty());
		
		ContactService.addContact("Rebecca", "Smith","8605249535", "54 White St");
		contactID = ContactService.contactList.get(0).getID();
		ContactService.deleteContact(contactID);
		assertTrue(ContactService.contactList.isEmpty());
	}
	
	
	@Test
	void testUpdateFirst() {

		assertTrue(ContactService.contactList.isEmpty());
		ContactService.addContact("Rebecca", "Smith","8605249535", "54 White St");
		contactID = ContactService.contactList.get(0).getID();
		ContactService.updateFirst(contactID, "Jennifer");
		//Checks to confirm that the first name has been updated to Jennifer
		//contactID = ContactService.contactList.get(0).getID();
		assertTrue(ContactService.contactList.get(0).getfirstName().equals("Jennifer"));
		assertFalse(ContactService.contactList.isEmpty());
	}
	
	@Test
	void testUpdateLast() {

		ContactService.addContact("Rebecca", "Smith","8605249535", "54 White St");
		contactID = ContactService.contactList.get(0).getID();
		ContactService.updateLast(contactID, "Jones");
		//Checks to confirm that the last name has been updated to Jones
		assertTrue(ContactService.contactList.get(0).getlastName().equals("Jones"));
		assertFalse(ContactService.contactList.isEmpty());
	}
	
	@Test
	void testUpdatePhone() {
	
		ContactService.addContact("Rebecca", "Smith","8605249535", "54 White St");
		contactID = ContactService.contactList.get(0).getID();
		ContactService.updatePhone(contactID, "8609999999");
		//Checks to confirm that the Phone Number has been updated to 8609999999
		assertTrue(ContactService.contactList.get(0).getphone().equals("8609999999"));
		assertFalse(ContactService.contactList.isEmpty());
	}
	
	@Test
	void testUpdateAddress() {
	
		ContactService.addContact("Rebecca", "Smith","8605249535", "54 White St");
		contactID = ContactService.contactList.get(0).getID();
		ContactService.updateAddress(contactID, "35 Lincoln Dr.");
	
		assertTrue(ContactService.contactList.get(0).getaddress().equals("35 Lincoln Dr."));
		assertFalse(ContactService.contactList.isEmpty());
	}
	
	@AfterEach
	void breakdown() {
		//ContactService testDelete = new ContactService(contactID, first, last, phone, address);
		ContactService.deleteContact(contactID);
		//assertTrue(ContactService.contactList.isEmpty());
	}
	
}
