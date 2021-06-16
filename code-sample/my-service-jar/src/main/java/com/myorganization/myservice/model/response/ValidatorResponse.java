package com.myorganization.myservice.model.response;

import com.myorganization.myservice.utils.Errors;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ValidatorResponse implements Serializable {

    private static final long serialVersionUID = -584224418322923011L;

    private List<Errors> errors;

    private String idDocumentType;
    
    private String status;
}
