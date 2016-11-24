package io.github.kjens93.edmunds;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kjensen on 11/20/16.
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
class Years {

    private List<Year> years = new ArrayList<>();
    private int yearsCount;

}
