package com.myorganization.myservice.utils;

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
public class Errors implements Serializable{

    private static final long serialVersionUID = -4707322410452775840L;

    public static final String CODE_IDVALIDATION_ERROR = 		"ICESD004";

    private  String code;
    private  String message;

}