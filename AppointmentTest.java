package Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import ProjectOne.Appointment;

class AppointmentTest {


	public String apptID = "0123456789";
	public Date aptDate = new Date();
	public String desc = "Test Appointment";
	
	@BeforeEach
	void setUp() {
		try {
			aptDate = new SimpleDateFormat("yyyy-MM-dd").parse("2023-06-01");
		} catch (ParseException except) {}
	}
	
	@Test
	void testAppointment() {
		Appointment appt = new Appointment(apptID, aptDate, desc);
		assertAll(
				()-> assertTrue(appt.getID().equals("0123456789")), 
				()-> assertTrue(appt.getDate().equals(aptDate)),
				()-> assertTrue(appt.getDescription().equals("Test Appointment")));
	}
	@Test
	void testRandomApptID() {
		Appointment appt = new Appointment(apptID, aptDate, desc);
		apptID = appt.createRandomApptID();
		assertFalse(appt.getID().equals(appt.createRandomApptID()));
	}
	
	@Test
	void testNullApptID() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, aptDate, desc);
		});
	}
	@Test
	void testNullApptDate() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(apptID, null, desc);
		});
	}

	@Test
	void testNullDescription() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			new Appointment(apptID, aptDate, null);
		});
	}
	
	@Test 
	void testLongDesc() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(apptID, aptDate, "This description is too Long to be a valid description");
		});
	}

	@Test
	public void testSetDesc() {			
		Appointment appt = new Appointment(apptID, aptDate, desc);
		appt.setDesc("Testing Description");
		assertTrue(appt.getDescription().equals("Testing Description"));
	}	
	
	@Test
	public void testSetDescLong() {		
		Appointment appt = new Appointment(apptID, aptDate, desc);
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			appt.setDesc("This description is too Long to be a valid description");
		});
	}
	
	@Test
	public void testSetDescNull() {		
		Appointment appt = new Appointment(apptID, aptDate, desc);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appt.setDesc(null);
		});
	}
	
	@Test 
	void testsetDate() throws ParseException {
		Appointment appt = new Appointment(apptID, aptDate, desc);
		appt.setDate(new Date());
		assertTrue(new Appointment(apptID, aptDate, desc).getDate() == aptDate);
	}
	
	@Test 
	void testsetDateNull() throws ParseException {
		Appointment appt = new Appointment(apptID, aptDate, desc);
		Assertions.assertThrows(NullPointerException.class, () -> {
			appt.setDate(null);
		});
	}

}
