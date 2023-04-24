package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import ProjectOne.ContactService;
//import ProjectOne.Contact;
//import ProjectOne.ContactService;
import ProjectOne.TaskService;

class TaskServiceTest {
	
	public String taskID = "0123456789";
	public String name = "Balloons";
	public String description = "Buy Betty's Party Balloons";
	
	@BeforeEach
	void setup() {
		TaskService.taskList.clear();
	}
	
	@Test
	void testTaskService() {
		TaskService taskServ =  new TaskService(taskID, name, description);
		assertAll(
				()-> assertTrue(taskServ.getID().equals("0123456789")), 
				()-> assertTrue(taskServ.getName().equals("Balloons")),
				()-> assertTrue(taskServ.getDescription().equals("Buy Betty's Party Balloons")));
	}
	
	@Test
	void testaddTask() {
		
		assertTrue(TaskService.taskList.isEmpty());
		
		TaskService.addTask("Jolly", "Green Giant Shoes");
		
		assertAll(
				()-> assertFalse(TaskService.taskList.isEmpty()),
				()-> assertTrue(TaskService.taskList.get(0).getName().equals("Jolly")),
				()-> assertTrue(TaskService.taskList.get(0).getDescription().equals("Green Giant Shoes")));
	}	
	@Test
	void testDeleteTask() {
		assertTrue(TaskService.taskList.isEmpty());
		//Add something to the taskList to be deleted
		TaskService.addTask("Jolly", "Green Giant Shoes");
		taskID = TaskService.taskList.get(0).getID();
		TaskService.deleteTask("0123456789");
		assertTrue(TaskService.taskList.isEmpty());
	}
	
	@Test
	void testUpdateName() {
	
		TaskService.addTask("Jolly", "Green Giant Shoes");
		taskID = TaskService.taskList.get(0).getID();
		TaskService.updateName(taskID, "Happy");
	
		assertTrue(TaskService.taskList.get(0).getName().equals("Happy"));
		assertFalse(TaskService.taskList.isEmpty());
	}
	
	@Test
	void testUpdateDesc() {
	
		TaskService.addTask("Jolly", "Green Giant Shoes");
		taskID = TaskService.taskList.get(0).getID();
		TaskService.updateDesc(taskID, "Happiness is the key to success");
	
		assertTrue(TaskService.taskList.get(0).getDescription().equals("Happiness is the key to success"));
		assertFalse(TaskService.taskList.isEmpty());
	}
}
