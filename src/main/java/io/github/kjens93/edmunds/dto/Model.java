package io.github.kjens93.edmunds.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kjensen on 11/20/16.
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class Model implements Serializable {

    private String id;
    private String name;
    private String niceName;
    private List<Year> years = new ArrayList<>();

    @Override
    public String toString() {
        if (name != null) return name;
        if (niceName != null) return niceName;
        return getClass().getSimpleName() + "(id=" + id + ")";
    }

//    @JsonIgnore
//    public List<Integer> getYears() {
//        return years.stream().map(Year::getYear).collect(toList());
//    }

//    public List<Year> getModelYears() {
//        return years;
//    }

}
