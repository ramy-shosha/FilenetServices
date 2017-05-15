package com.techhup.filenetservices.models;

/* JSON OBJECT
 * 	actionsHistory:[{
  "id":20,
  "taskName":"Task Name",
  "taskDynamicHistory": {
    "action1": "value",
    "action2": "value",
    "action3": "value"
  }
}]
 * */

import java.io.Serializable;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "actionsHistory")
public class ActionsHistory implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String taskName;
	private HashMap<String, String> taskDynamicHistory;

	public String getId() {
		return id;
	}

	@XmlElement
	public void setId(String id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	@XmlElement
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public HashMap<String, String> getTaskDynamicHistory() {
		return taskDynamicHistory;
	}

	@XmlElement
	public void setTaskDynamicHistory(HashMap<String, String> taskDynamicHistory) {
		this.taskDynamicHistory = taskDynamicHistory;
	}

}
