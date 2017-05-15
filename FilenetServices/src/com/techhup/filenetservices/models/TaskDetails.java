package com.techhup.filenetservices.models;

import java.io.Serializable;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "taskDetails")

public class TaskDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String taskName;
	private String inboxName;
	private String taskDescription;
	private boolean taskStatus;
	private HashMap<String, String> taskDynamicParameters;
	private HashMap<String, String> taskAttachments;
	private HashMap<String, String> customActions;

	public TaskDetails() {
	}

	public TaskDetails(String id, String name) {
		this.id = id;
		this.taskName = name;
	}

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

	public String getInboxName() {
		return inboxName;
	}

	public void setInboxName(String inboxName) {
		this.inboxName = inboxName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public boolean isTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(boolean taskStatus) {
		this.taskStatus = taskStatus;
	}

	public HashMap<String, String> getTaskDynamicParameters() {
		return taskDynamicParameters;
	}

	public void setTaskDynamicParameters(HashMap<String, String> taskDynamicParameters) {
		this.taskDynamicParameters = taskDynamicParameters;
	}

	public HashMap<String, String> getTaskAttachments() {
		return taskAttachments;
	}

	public void setTaskAttachments(HashMap<String, String> taskAttachments) {
		this.taskAttachments = taskAttachments;
	}

	public HashMap<String, String> getCustomActions() {
		return customActions;
	}

	public void setCustomActions(HashMap<String, String> customActions) {
		this.customActions = customActions;
	}
}
