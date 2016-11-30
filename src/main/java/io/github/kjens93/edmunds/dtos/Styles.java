package io.github.kjens93.edmunds.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.kjens93.edmunds.dtos.Style;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kjensen on 11/20/16.
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class Styles {

    private List<Style> styles = new ArrayList<>();
    private int stylesCount;

}
