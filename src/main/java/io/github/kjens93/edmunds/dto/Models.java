package io.github.kjens93.edmunds.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kjensen on 11/22/16.
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class Models implements Serializable {

    private List<Model> models = new ArrayList<>();
    private int modelsCount;

}
