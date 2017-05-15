package com.techhup.filenetservices.definitions;


public enum EnviromentDefinitions {
	
	/* Observations Definitions */
	Observation_DOCUMENT_CLASS_NAME("ECM_Document_Subclass"),
	Report_DOCUMENT_CLASS_NAME("ECM_Content_DocumentClass"),
	Observations_DOCUMENT_MIMETYPE("application/msword"),
	Observations_OBJECTSTORE_NAME("ICN"),
	Observations_FOLER_PATH("/SAB Reports"),
	URI("http://10.0.96.4:9080/wsi/FNCEWS40MTOM"),
	STANZA("FileNetP8"),
	ADMIN("cpeadmin"),
	ADMIN_PASS("Ebla1234"),
	Observations_FOLER_NAME("SAB Intial Report");

	private String setting;

	private EnviromentDefinitions(String _setting)
	{
		this.setting = _setting;
	}

	public String getStringValue()
	{
		return this.setting;
	}

}
