package Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import ProjectOne.AppointmentService;
//import ProjectOne.ContactService;

class AppointmentServiceTest {

	public String apptID = "0123456789";
	public Date aptDate = new Date();
	public String desc = "Test Appointment";
	
	@BeforeEach
	void setUp() {
		try {
			aptDate = new SimpleDateFormat("yyyy-MM-dd").parse("2023-06-01");
		} catch (ParseException except) {}
		//AppointmentService.apptList.clear();
	}
	
	
	
	@Test
	void TestAppointmentService() {
		AppointmentService apptServ = new AppointmentService(apptID, aptDate, desc);
		assertAll(
				()-> assertTrue(apptServ.getID().equals("0123456789")), 
				()-> assertTrue(apptServ.getDate().equals(aptDate)),
				()-> assertTrue(apptServ.getDescription().equals("Test Appointment")));
		//AppointmentService.deleteAppt(apptID);
	}
	
	@Test
	void testaddAppointment() {
		AppointmentService testAdd = new AppointmentService("1234567890", aptDate, "New Test");
		assertTrue(AppointmentService.apptList.isEmpty());
		
		AppointmentService.addAppt(aptDate, "New Test");
		
		assertAll(
			()-> assertFalse(AppointmentService.apptList.isEmpty()),
			()-> assertFalse(AppointmentService.apptList.get(0).getID().isEmpty()),
			()-> assertTrue(AppointmentService.apptList.get(0).getDate().equals(aptDate)),
			()-> assertTrue(AppointmentService.apptList.get(0).getDescription().equals("New Test")));
		AppointmentService.deleteAppt(apptID);
	}
	
	@Test
	void testdeleteAppt() {
		//AppointmentService testDelete = new AppointmentService(apptID, aptDate, desc);
		AppointmentService.addAppt(aptDate, desc);
		apptID = AppointmentService.apptList.get(0).getID();
		assertFalse(AppointmentService.apptList.get(0).getID().isEmpty());
		AppointmentService.deleteAppt(apptID);
		assertTrue(AppointmentService.apptList.isEmpty());
			
	}	
	@BeforeEach
	void breakdown() {
		AppointmentService.apptList.clear();
	}
}
