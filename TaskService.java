/*Heather Marcolino da Silva
 * SNHU CS-320 
 * 03-26-2023 */

package ProjectOne;

import java.util.ArrayList;

public class TaskService extends Task {
	public TaskService(String taskId, String name, String desc) {
		super (taskId, name, desc);
		// TODO Auto-generated constructor stub
	}
	
	//variables for this class
	protected String name;
	protected String desc;
	protected String taskId;
	
	//creates array list for tasks
	public static ArrayList<Task> taskList = new ArrayList<Task>(0);
	
	//method to add tasks to the Array
	public static void addTask(String name, String description) {
		String taskId = createRandomTaskId();
		
		Task TaskA = new Task(taskId, name, description);
		taskList.add(TaskA);
	}
	//method to delete tasks from the Array
	public static void deleteTask(String TaskID) {
		for (int i = 0; i < taskList.size(); ++i) { 
			if(taskID.compareTo(taskList.get(i).getID()) == 0) {
				taskList.remove(i);
			}
		}
	}
	
	public static void updateName(String TaskID, String name) {
		for (int i = 0; i < taskList.size(); ++i) { 
			if(taskID.compareTo(taskList.get(i).getID()) == 0) {
				taskList.get(i).setName(name);
			}
		}
	}
	
	public static void updateDesc(String TaskID, String description) {
		for (int i = 0; i < taskList.size(); ++i) { 
			if(taskID.compareTo(taskList.get(i).getID()) == 0) {
				taskList.get(i).setDescription(description);
			}
		}
	}

}
