package Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ProjectOne.Contact;

class ContactTest {

	public String contactID = "0123456789";
	public String first = "Rebecca";
	public String last = "Smith";
	public String phone = "8605249535";
	public String address = "54 White St";
	
	@Test
	void testContact() {
		Contact contact = new Contact(contactID, first, last, phone, address);
		assertAll(
				()-> assertTrue(contact.getID().equals("0123456789")), 
				()-> assertTrue(contact.getfirstName().equals("Rebecca")),
				()-> assertTrue(contact.getlastName().equals("Smith")),
				()-> assertTrue(contact.getphone().equals("8605249535")),
				()-> assertTrue(contact.getaddress().equals("54 White St")));
	}
	
	@Test
	void testRandomContactID() {
		Contact contact = new Contact(contactID, first, last, phone, address);
		contact.createRandomContactId();
		assertFalse(contact.getID().equals(contact.createRandomContactId()));
	}
	
	@Test
	void testContactIDNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			new Contact(null, first, last, phone, address);
		});
	}
	
	@Test
	void testContactIDLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("01234567890", first, last, phone, address);
		});
	}
	
	@Test
	void testContactfNameNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			new Contact(contactID, null, last, phone, address);
		});
	}
	
	@Test
	void testContactfNameLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactID, "Rebeccamaba", last, phone, address);
		});
	}

	@Test
	void testContactlNameNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			new Contact(contactID, first, null, phone, address);
		});
	}
	
	@Test
	void testContactlNameLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1638754294", "Rebecca", "Smithsonian", "8605249535", "54 White St, Putnam, CT 06260");
		});
	}
	
	@Test
	void testContactphoneNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			new Contact(contactID, first, last, null, address);
		});
	}
	
	@Test
	void testContactphoneLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1638754294", "Rebecca", "Smithsonian", "18605249535", "54 White St, Putnam, CT 06260");
		});
	}
	
	@Test
	void testContactAddressNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			new Contact(contactID, first, last, phone, null);
		});
		
	}
	
	@Test
	void testContactAddressLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1638754294", "Rebecca", "Smithsonian", "8605249535", "54 Whitehaus Street, Putnam, CT 06260");
		});
	}
	
	@Test
	public void testSetFirst() {		
		Contact contact = new Contact(contactID, first, last, phone, address);
		contact.setfirstName("Betty");
		assertTrue(contact.getfirstName().equals("Betty"));
	}
	
	@Test
	public void testSetFirstLong() {		
		Contact contact = new Contact(contactID, first, last, phone, address);
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			contact.setfirstName("Rebeccamaba");
		});
	}
	
	@Test
	public void testSetFirstNull() {		
		Contact contact = new Contact(contactID, first, last, phone, address);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setfirstName(null);
		});
	}
	
	@Test
	public void testSetLast() {			
		Contact contact = new Contact(contactID, first, last, phone, address);
		contact.setlastName("White");
		assertTrue(contact.getlastName().equals("White"));
	}	
	
	@Test
	public void testSetLastLong() {		
		Contact contact = new Contact(contactID, first, last, phone, address);
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			contact.setlastName("Whitehausen");
		});
	}
	
	@Test
	public void testSetLastNull() {		
		Contact contact = new Contact(contactID, first, last, phone, address);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setlastName(null);
		});
	}
	
	@Test
	public void testSetPhone() {			
		Contact contact = new Contact(contactID, first, last, phone, address);
		contact.setPhone("8609991234");
		assertTrue(contact.getphone().equals("8609991234"));
	}	
	
	@Test
	public void testSetPhoneLong() {		
		Contact contact = new Contact(contactID, first, last, phone, address);
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			contact.setPhone("18609991234");
		});
	}
	
	@Test
	public void testSetPhoneNull() {		
		Contact contact = new Contact(contactID, first, last, phone, address);
		Assertions.assertThrows(NullPointerException.class, () -> {
			contact.setPhone(null);
		});
	}
	
	@Test
	public void testSetAddress() {			
		Contact contact = new Contact(contactID, first, last, phone, address);
		contact.setaddress("5457 White St");
		assertTrue(contact.getaddress().equals("5457 White St"));
	}	
	
	@Test
	public void testSetAddressLong() {		
		Contact contact = new Contact(contactID, first, last, phone, address);
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			contact.setaddress("5457 White Street, Putnam, CT 06260");
		});
	}
	
	@Test
	public void testSetAddressNull() {		
		Contact contact = new Contact(contactID, first, last, phone, address);
		Assertions.assertThrows(NullPointerException.class, () -> {
			contact.setaddress(null);
		});
	}
}
