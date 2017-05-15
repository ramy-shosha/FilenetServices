package com.techhup.filenetservices.models;

/* JSON OBJECT
 * 	"id":20,
	  "documentName":"Doc Name",
	  "documentDynamicParameters": {
	    "param1": "value",
	    "param2": "value",
	    "param3": "value"
	  }
 * */

import java.io.Serializable;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "documentDetails")
public class DocumentDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String documentName;
	private HashMap<String, String> documentDynamicParameters;

	public String getId() {
		return id;
	}
	
	@XmlElement
	public void setId(String id) {
		this.id = id;
	}

	public String getDocumentName() {
		return documentName;
	}
	
	@XmlElement
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public HashMap<String, String> getDocumentDynamicParameters() {
		return documentDynamicParameters;
	}
	
	@XmlElement
	public void setDocumentDynamicParameters(HashMap<String, String> documentDynamicParameters) {
		this.documentDynamicParameters = documentDynamicParameters;
	}

}
