package io.github.kjens93.edmunds.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kjensen on 11/20/16.
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class Makes {

    private List<Make> makes = new ArrayList<>();
    private int makesCount;

}