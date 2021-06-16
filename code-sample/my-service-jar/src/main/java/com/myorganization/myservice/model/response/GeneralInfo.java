package com.myorganization.myservice.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeneralInfo implements Serializable {
	
	private static final long serialVersionUID = -6693449312610042405L;
	
	private String returnCode;
	private String returnMessage;

}
