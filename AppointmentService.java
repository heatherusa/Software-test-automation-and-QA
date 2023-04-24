package ProjectOne;
//import java.nio.charset.Charset;
import java.util.*;

public class AppointmentService extends Appointment {

	public AppointmentService(String appointmentID, Date aptDate, String description) {
		super(appointmentID, aptDate, description);
		// TODO Auto-generated constructor stub
	}

	protected String appointmentID = createRandomApptID();
	protected Date aptDate;
	protected String description;
	
	//creates array list for appointments
	public static ArrayList<Appointment> apptList = new ArrayList<Appointment>(0);
	
	//method to add contact to the Array
	public static void addAppt(Date aptDate, String description) {
		String appointmentID = createRandomApptID();
		
		Appointment Appt = new Appointment(appointmentID, aptDate, description);
		apptList.add(Appt);
	}
	
	//method to delete contact from Array
	public static void deleteAppt(String apptID) {
		for (int i = 0; i < apptList.size(); i++) {
			if(apptID.compareTo(apptList.get(i).getID()) == 0) {
			//if (AppointmentService.apptList.get(i).getID() == apptID) {
				apptList.remove(i);
			} 
		}
	}
}
