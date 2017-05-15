package com.techhup.filenetservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.techhup.filenetservices.utils.CEConnection;

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
}
