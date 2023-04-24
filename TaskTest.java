package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ProjectOne.Contact;
import ProjectOne.Task;

class TaskTest {

	public String taskID = "0123456789";
	public String name = "Balloons";
	public String description = "Buy Betty's Party Balloons";
	
	@Test
	void testTask() {
		Task taskT =  new Task(taskID, name, description);
		assertAll(
				()-> assertTrue(taskT.getID().equals("0123456789")), 
				()-> assertTrue(taskT.getName().equals("Balloons")),
				()-> assertTrue(taskT.getDescription().equals("Buy Betty's Party Balloons")));
	}
	
	@Test
	void testTaskIDNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			new Task(null, name, description);
		});
	}
	
	@Test
	void testTaskIDLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("0123455467890", name, description);
		});
	}
	
	@Test
	void testTaskNameNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			new Task(taskID, null, description);
		});
	}
	
	@Test
	void testTaskNameLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(taskID, "asdfghjkl;qwertyuiopzxcvbnm", description);
		});
	}
	
	@Test
	void testTaskDescNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			new Task(taskID, name, null);
		});
	}
	
	@Test
	void testTaskDescLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(taskID, name, "sdfghjkqwertyuiopasdfghjklzxcvbnm,.asdfghjklqwertyuiop");
		});
	}
	
	@Test
	void testSetName() {
		Task task =  new Task(taskID, name, description);
		task.setName("Jolly");
		assertTrue(task.getName().equals("Jolly"));
	}
	
	@Test
	public void testSetNameLong() {		
		Task task =  new Task(taskID, name, description);
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			task.setName("Testing for long name set");
		});
	}
	
	@Test
	public void testSetNameNull() {		
		Task task =  new Task(taskID, name, description);
		Assertions.assertThrows(NullPointerException.class, ()-> {
			task.setName(null);
		});
	}
	
	@Test
	void testSetDesc() {
		Task task =  new Task(taskID, name, description);
		task.setDescription("Jolly Green Giant");
		assertTrue(task.getDescription().equals("Jolly Green Giant"));
	}
	
	@Test
	public void testSetDescLong() {		
		Task task =  new Task(taskID, name, description);
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			task.setDescription("Testing for long Description set feature which is over 50 chars");
		});
	}
	
	@Test
	public void testSetDescNull() {		
		Task task =  new Task(taskID, name, description);
		Assertions.assertThrows(NullPointerException.class, ()-> {
			task.setDescription(null);
		});
	}
	
	@Test
	void testRandomTaskID() {
		Task task =  new Task(taskID, name, description);
		task.createRandomTaskId();
		assertFalse(task.getID().equals(task.createRandomTaskId()));
	}
	

}
