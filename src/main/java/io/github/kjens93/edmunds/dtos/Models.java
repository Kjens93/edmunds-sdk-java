package io.github.kjens93.edmunds.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.kjens93.edmunds.dtos.Model;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kjensen on 11/22/16.
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class Models {

    private List<Model> models = new ArrayList<>();
    private int modelsCount;

}
