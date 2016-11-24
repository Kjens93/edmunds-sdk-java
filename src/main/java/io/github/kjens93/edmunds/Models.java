package io.github.kjens93.edmunds;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kjensen on 11/22/16.
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
class Models {

    private List<Model> models = new ArrayList<>();
    private int modelsCount;

}
