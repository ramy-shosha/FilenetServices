package com.techhup.filenetservices.utils;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.techhup.filenetservices.models.TaskDetails;

public class JsonUtil {

	
	public JSONArray userInbox(ArrayList<TaskDetails> inboxList){
		
		JSONArray list = new JSONArray();
		
		for (Iterator iterator = inboxList.iterator(); iterator.hasNext();) {
			TaskDetails object = (TaskDetails) iterator.next();
			JSONObject obj = new JSONObject();
	        obj.put("id", object.getId());
	        obj.put("taskName",object.getTaskName());
	        list.add(obj);
		}
		
		return list;
	}
	
}
