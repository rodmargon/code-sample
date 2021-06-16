package com.myorganization.myservice.constants;

public class SwaggerConstants {

	private SwaggerConstants() {
	}

	public static final String X_TRANSLATIONS_KEY = "translations";
	public static final String API_VERSION = "1.0";
	public static final String API_TITLE = "Custom Service REST API Definition";
	public static final String API_DESCRIPTOR = "API content for Custom service";

	public static final String APPLICATION_NAME_INFO_KEY = "info.appName";
	public static final String TITLE_INFO_KEY = "info.title";
	public static final String DESCRIPTION_INFO_KEY = "info.description";

	public static final String APPLICATION_NAME_INFO_PACKAGE_KEY = "com.myorganization.myservice";
	public static final String CONTROLLER_PACKAGE_KEY = APPLICATION_NAME_INFO_PACKAGE_KEY + ".controller";
	public static final String DESCRIPTION_INFO_PACKAGE_KEY = APPLICATION_NAME_INFO_PACKAGE_KEY + ".description";
	public static final String TITLE_INFO_PACKAGE_KEY = APPLICATION_NAME_INFO_PACKAGE_KEY + ".title";

	public static final String SUMMARY_KEY = "summary";
	public static final String DESCRIPTION_KEY = "description";

	public static final String PAYLOAD_CUSTOMSERVICE_PARAM_NAME_KEY = "body.param.name";
	public static final String PAYLOAD_CUSTOMSERVICE_PARAM_PACKAGE_KEY = ".body.param.name";

	public static final String SUMMARY_PACKAGE_KEY = CONTROLLER_PACKAGE_KEY + ".myservice.summary";
	public static final String SUMMARY_PACKAGE_IDVALIDATOR_KEY = CONTROLLER_PACKAGE_KEY + ".myservice.summary.idValidator";
	public static final String DESCRIPTION_PACKAGE_KEY = CONTROLLER_PACKAGE_KEY + ".myservice.description";

	public static final String INPUTTEXT_CODE_PARAM_NAME_KEY = "inputText.param.name";
	public static final String INPUTTEXT_CODE_PARAM_PACKAGE_KEY = CONTROLLER_PACKAGE_KEY + ".inputText.param.name";
	public static final String X_EXTENDED_PROPERTIES_KEY = "extended_properties";
	public static final String OPERATION_TYPE_KEY = "operation_type";
	public static final String SYSTEM_TYPE_KEY = "system";
	public static final String BUSINESS_TYPE_KEY = "business";

	public static final String PATH_NAME_KEY = "pathName";
	public static final String PATH_ID_VALIDATOR_DESCRIPTION_KEY = CONTROLLER_PACKAGE_KEY + ".idValidator.pathName";

	public static final String DESCRIPTION_STATUS_PACKAGE_KEY = CONTROLLER_PACKAGE_KEY + ".status.description";
	public static final String OK_SUCCESS_MESSAGE = "OK success status";
	public static final String INTERNAL_SERVER_ERROR_MESSAGE = "Internal server error";
	public static final String SUMMARY_STATUS_PACKAGE_KEY = CONTROLLER_PACKAGE_KEY + ".status.summary";

}
