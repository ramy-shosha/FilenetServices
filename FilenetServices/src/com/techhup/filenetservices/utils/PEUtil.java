package com.techhup.filenetservices.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.filenet.api.collection.StringList;
import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.Document;
import com.filenet.api.core.Factory;
import com.filenet.api.core.ObjectStore;

import filenet.vw.api.VWAttachment;
import filenet.vw.api.VWAttachmentType;
import filenet.vw.api.VWFetchType;
import filenet.vw.api.VWLibraryType;
import filenet.vw.api.VWQueue;
import filenet.vw.api.VWQueueQuery;
import filenet.vw.api.VWSession;
import filenet.vw.api.VWStepElement;

public class PEUtil {

	String userName;
	String password;
	String stanza;
	String uri;
	String connectionPoint;
	VWSession myPESession;
	String workflowName = "MSD Main Process";

	public static void main(String[] args) {

		PEUtil peUtil = new PEUtil();
		peUtil.login();
		// peUtil.validateObservation(processNumber);
	}

	public PEUtil() {

		userName = "cpeadmin";
		password = "Ebla1234";
		stanza = "FileNetP8";
		uri = "http://10.0.96.4:9080/wsi/FNCEWS40MTOM";
		connectionPoint = "CMTOS_CP";

	}

	public void login() {

		myPESession = new VWSession();
		// Set Bootstrap Content Engine URI
		myPESession.setBootstrapCEURI(uri);
		// Log onto the Process Engine Server
		myPESession.logon(userName, password, connectionPoint);

	}
	
	public String getUserName(){
		return userName;
	}

	public VWSession getVWSession() {

		return myPESession;
	}

	public void logoff() {

		myPESession.logoff();

	}

	
	public boolean checkFD() {

		boolean result= true;
		String queueName = "SAB";
		// Retrieve the Queue
		VWQueue queue = myPESession.getQueue(queueName);
		// Set Query Parameters
		// Query Flags and Type to retrieve Step Elements
		int queryFlags = VWQueue.QUERY_READ_LOCKED;
		int queryType = VWFetchType.FETCH_TYPE_STEP_ELEMENT;
		VWQueueQuery queueQuery = queue.createQuery(null, null, null, queryFlags, null, null, queryType);
		// Process Results
		while (queueQuery.hasNext()) {
			VWStepElement stepElement = (VWStepElement) queueQuery.next();
			if (!stepElement.getStepName().equalsIgnoreCase("Approved for first draft")) {
				result = false;
				break;
			}
		}

		return result;
	}
	
	public boolean checkSD() {

		boolean result= true;
		String queueName = "SAB";
		// Retrieve the Queue
		VWQueue queue = myPESession.getQueue(queueName);
		// Set Query Parameters
		// Query Flags and Type to retrieve Step Elements
		int queryFlags = VWQueue.QUERY_READ_LOCKED;
		int queryType = VWFetchType.FETCH_TYPE_STEP_ELEMENT;
		VWQueueQuery queueQuery = queue.createQuery(null, null, null, queryFlags, null, null, queryType);
		// Process Results
		while (queueQuery.hasNext()) {
			VWStepElement stepElement = (VWStepElement) queueQuery.next();
			if (!stepElement.getStepName().equalsIgnoreCase("Approval for 2nd draft")) {
				result = false;
				break;
			}
		}

		return result;
	}


	public void validateObservation(String processNumber, String observationContent) {
		System.err.println("processNumber ******************* " + observationContent);
		PEUtil peUtil = new PEUtil();
		peUtil.login();
		// Retrieve the Queue
		VWQueue queue = myPESession.getQueue("SAB");
		// Set Query Parameters
		// Query Flags and Type to retrieve Step Elements
		int queryFlags = VWQueue.QUERY_READ_LOCKED;
		int queryType = VWFetchType.FETCH_TYPE_STEP_ELEMENT;
		VWQueueQuery queueQuery = queue.createQuery(null, null, null, queryFlags, null, null, queryType);
		// Process Results
		while (queueQuery.hasNext()) {
			VWStepElement stepElement = (VWStepElement) queueQuery.next();
			stepElement.doLock(true);
			if (stepElement.getWorkObjectNumber().equals(processNumber)) {
//				stepElement.setParameterValue("ObservationContent", observationContent, true);
				stepElement.doDispatch();
				break;
			}

		}

	}
	
	public void validateall() {
		PEUtil peUtil = new PEUtil();
		peUtil.login();
		// Retrieve the Queue
		VWQueue queue = myPESession.getQueue("SAB");
		// Set Query Parameters
		// Query Flags and Type to retrieve Step Elements
		int queryFlags = VWQueue.QUERY_READ_LOCKED;
		int queryType = VWFetchType.FETCH_TYPE_STEP_ELEMENT;
		VWQueueQuery queueQuery = queue.createQuery(null, null, null, queryFlags, null, null, queryType);
		// Process Results
		while (queueQuery.hasNext()) {
			VWStepElement stepElement = (VWStepElement) queueQuery.next();
			stepElement.doLock(true);
			if (stepElement.getSubject().equalsIgnoreCase("Observation Validation")) {
				stepElement.doDispatch();
			}

		}

	}
	
	public void processAll() {
		PEUtil peUtil = new PEUtil();
		peUtil.login();
		// Retrieve the Queue
		VWQueue queue = myPESession.getQueue("SAB");
		// Set Query Parameters
		// Query Flags and Type to retrieve Step Elements
		int queryFlags = VWQueue.QUERY_READ_LOCKED;
		int queryType = VWFetchType.FETCH_TYPE_STEP_ELEMENT;
		VWQueueQuery queueQuery = queue.createQuery(null, null, null, queryFlags, null, null, queryType);
		// Process Results
		while (queueQuery.hasNext()) {
			VWStepElement stepElement = (VWStepElement) queueQuery.next();
			stepElement.doLock(true);
			if (stepElement.getSubject().equalsIgnoreCase("Observation Process")) {
				stepElement.doDispatch();
			}

		}

	}

	public void processObservation(String processNumber, HashMap<String, String> params) {
		PEUtil peUtil = new PEUtil();
		peUtil.login();
		// Retrieve the Queue
		VWQueue queue = myPESession.getQueue("SAB");
		// Set Query Parameters
		// Query Flags and Type to retrieve Step Elements
		int queryFlags = VWQueue.QUERY_READ_LOCKED;
		int queryType = VWFetchType.FETCH_TYPE_STEP_ELEMENT;
		VWQueueQuery queueQuery = queue.createQuery(null, null, null, queryFlags, null, null, queryType);
		// Process Results
		while (queueQuery.hasNext()) {
			VWStepElement stepElement = (VWStepElement) queueQuery.next();
			stepElement.doLock(true);
			if (stepElement.getWorkObjectNumber().equals(processNumber)) {
				
				for (Iterator iterator = params.keySet().iterator(); iterator.hasNext();) {
					String key = (String) iterator.next();
					if (key.equalsIgnoreCase("response")) {
						stepElement.setSelectedResponse(params.get("response"));
					} else {
						stepElement.setParameterValue(key, params.get(key), true);
					}
				}
				
				
				
				stepElement.doDispatch();
				break;
			}

		}

	}

}
