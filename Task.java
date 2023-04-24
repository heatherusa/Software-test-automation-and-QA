/*Heather Marcolino da Silva
 * SNHU CS-320 
 * 03-26-2023 */

package ProjectOne;

import java.nio.charset.Charset;
import java.util.Random;

public class Task {
	
	protected static String taskID;
	protected String name;
	protected String description;
	
	public Task(String TaskID, String name, String description) {
		// TODO Auto-generated constructor stub
				
		if (TaskID.length() >10 || TaskID == null) {
			throw new IllegalArgumentException("Task ID Invalid");
		}
		
		if (name.length() >20 || name == null) {
			throw new IllegalArgumentException("Name is Invalid");
		}

		if (description.length() > 50 || description == null) {
			throw new IllegalArgumentException("Description is Invalid");
		}
		Task.taskID = TaskID;
		this.name = name;
		this.description = description;
		
	}
	
	// Getter methods
	public String getID() {
		return taskID;
	}
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	// Setter methods
	public void setName(String taskName) {
		if (taskName.length()>20 || taskName == null) {
			throw new IllegalArgumentException("Name is Invalid");
		}
		else {
			this.name = taskName;
		}
	}
	
	public void setDescription(String taskDescription) {
		if (taskDescription.length()>50 || taskDescription == null) {
			throw new IllegalArgumentException("Description is Invalid");
		}
		else {
			this.description = taskDescription;
		}
	}
	
	//Creates a random Task ID  
	public static String createRandomTaskId() {
	    byte[] array = new byte[10]; // length is bounded by 10
	    new Random().nextBytes(array);
	    String generatedTaskId = new String(array, Charset.forName("UTF-8"));
	    
	    return generatedTaskId;
	}
	

}
