package com.myorganization.myservice.controller;

import com.myorganization.myservice.model.response.ServiceStatusResponse;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

import static com.myorganization.myservice.constants.SwaggerConstants.*;
import static org.springframework.http.HttpStatus.OK;


@Controller
public class StatusController implements ServletContextAware {

	@Autowired(required = false)
	private BuildProperties buildProperties;

	@Autowired
	private ServletContext servletContext;

	@ApiOperation(notes = "Endpoint to get status of the service", value = "Status endpoint", extensions = {
			@Extension(name = "translations", properties = {
					@ExtensionProperty(name = SUMMARY_KEY, value = SUMMARY_STATUS_PACKAGE_KEY),
					@ExtensionProperty(name = DESCRIPTION_KEY, value = DESCRIPTION_STATUS_PACKAGE_KEY) }),
			@Extension(name = X_EXTENDED_PROPERTIES_KEY, properties = {
					@ExtensionProperty(name = OPERATION_TYPE_KEY, value = SYSTEM_TYPE_KEY) }) })
	@ApiResponses(value = { @ApiResponse(code = 200, message = OK_SUCCESS_MESSAGE),
			@ApiResponse(code = 500, message = INTERNAL_SERVER_ERROR_MESSAGE) })
	@GetMapping(path = "/api/status", produces = "application/json")
	public ResponseEntity<ServiceStatusResponse> status() {
		return new ResponseEntity<>(new ServiceStatusResponse(servletContext, buildProperties), OK);
	}

	@Override
	public void setServletContext(final ServletContext servletContext) {
		this.servletContext = servletContext;
	}

} 