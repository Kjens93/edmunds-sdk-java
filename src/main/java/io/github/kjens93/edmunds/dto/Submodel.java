package io.github.kjens93.edmunds.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

/**
 * Created by kjensen on 11/23/16.
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class Submodel {

    private String body;
    private String modelName;
    private String niceName;

    @Override
    public String toString() {
        if (body != null) return body;
        if (modelName != null) return modelName;
        if (niceName != null) return niceName;
        return super.toString();
    }

}
