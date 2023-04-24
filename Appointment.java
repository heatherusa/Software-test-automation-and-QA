package ProjectOne;

import java.nio.charset.Charset;
import java.util.*;


public class Appointment {
	
	protected String appointmentID;
	protected Date appointmentDate;
	protected String description;
	
	public Appointment(String appID, Date aptDate, String desc) {
		// TODO Auto-generated constructor stub
		
		if(appID == null || appID.length() > 10) { // || appID == null ) {
			throw new IllegalArgumentException("Appointment ID Invalid");
		}
		
		if(aptDate == null || aptDate.before(new Date())) {
			throw new IllegalArgumentException("Appointment Date Invalid "+ aptDate);
		}
		 
		if(desc.length() > 50 || desc == null) {
			throw new IllegalArgumentException("Appointment Description Invalid");
		}
		
		this.appointmentID = appID;
		this.appointmentDate = aptDate;
		this.description = desc;
	}
	
	//create getter methods:
	public String getID() {
		return appointmentID;
	}
	
	public Date getDate() {
		return appointmentDate;
	}
	
	public String getDescription() {
		return description;
	}
	
	//Setter methods for date and description
	public void setDate(Date aptDate) {
		if(aptDate.before(new Date()) || aptDate == null ) {
			throw new IllegalArgumentException("Appointment Date Invalid");
		}
		else {
			this.appointmentDate = aptDate;
		}
	}
	public void setDesc(String desc) {
		if(desc == null || desc.length() > 50) {
			throw new IllegalArgumentException("Appointment Description Invalid");
		}
		else {
			this.description = desc;
		}
	}
	
	//Method Creates random appointment ID 
	public static String createRandomApptID() {
	    byte[] array = new byte[10]; // length is bounded by 10
	    new Random().nextBytes(array);
	    String generatedString = new String(array, Charset.forName("UTF-8"));
	    
	    return generatedString;
	}
}
