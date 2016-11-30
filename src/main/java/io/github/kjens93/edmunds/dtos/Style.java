package io.github.kjens93.edmunds.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

/**
 * Created by kjensen on 11/20/16.
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class Style {

    private int id;
    private String name;
    private String trim;
    private Price price;
    private Submodel submodel;

    @Override
    public String toString() {
        if (name != null) return name;
        if (trim != null) return trim;
        return getClass().getSimpleName() + "(id=" + id + ")";
    }

}
