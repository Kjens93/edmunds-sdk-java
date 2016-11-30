package io.github.kjens93.edmunds.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.kjens93.edmunds.enums.State;
import lombok.Value;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kjensen on 11/20/16.
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class Year implements Serializable {

    private int id;
    private int year;
    private List<State> states = new ArrayList<>();
    private List<Style> styles = new ArrayList<>();

    @Override
    public String toString() {
        return year + "";
    }

}
