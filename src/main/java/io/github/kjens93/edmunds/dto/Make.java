package io.github.kjens93.edmunds.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kjensen on 11/20/16.
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class Make {

    private int id;
    private int modelsCount;
    private String name;
    private String niceName;
    private List<Model> models = new ArrayList<>();

    @Override
    public String toString() {
        if (name != null) return name;
        if (niceName != null) return niceName;
        return getClass().getSimpleName() + "(id=" + id + ")";
    }

}
