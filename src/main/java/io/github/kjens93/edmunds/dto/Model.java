package io.github.kjens93.edmunds.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by kjensen on 11/20/16.
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class Model {

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

    public List<Integer> getYears() {
        return years.stream().map(Year::getYear).collect(toList());
    }

    public List<Year> getModelYears() {
        return years;
    }

}
