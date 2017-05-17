package com.techhup.filenetservices;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.techhup.filenetservices.models.TaskDetails;
import com.techhup.filenetservices.utils.CEConnection;
import com.techhup.filenetservices.utils.JsonUtil;
import com.techhup.filenetservices.utils.PEUtil;

@Path("/Services")
public class Services {
	CEConnection ceConnection = new CEConnection();
	
	@GET
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public String login(@QueryParam("userName") String userName, @QueryParam("password") String password) {
		try {
			
		ceConnection.establishConnection(userName, password);
		if (ceConnection.isConnected()) {
			return "true";
		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return e.getMessage();
		}
		return "false";
	}
	
	
	@GET
	@Path("/taskList")
	@Produces(MediaType.APPLICATION_JSON)
	public String taskList(@QueryParam("userName") String userName, @QueryParam("password") String password) {
		JSONArray userInbox = null;
		try {
			PEUtil peUtil = new PEUtil(); 
			peUtil.login(userName, password);
			ArrayList<TaskDetails> inboxList = peUtil.getInbox();
			JsonUtil jsonUtil = new JsonUtil();
			userInbox = jsonUtil.userInbox(inboxList);
			return userInbox.toString();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return userInbox.toString();
	}
	
	
	@GET
	@Path("/taskDetails")
	@Produces(MediaType.APPLICATION_JSON)
	public String taskDetials(@QueryParam("userName") String userName, @QueryParam("password") String password, @QueryParam("taskID") String taskID) {
		JSONObject taskDetials = null;
		try {
			PEUtil peUtil = new PEUtil(); 
			peUtil.login(userName, password);
			TaskDetails taskDetails = peUtil.getTaskDetails(taskID);
			JsonUtil jsonUtil = new JsonUtil();
			taskDetials = jsonUtil.taskDetals(taskDetails);
			return taskDetials.toString();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return taskDetials.toString();
	}
}
