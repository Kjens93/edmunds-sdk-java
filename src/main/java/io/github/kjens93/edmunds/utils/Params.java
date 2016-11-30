package io.github.kjens93.edmunds.utils;

import io.github.kjens93.edmunds.enums.Category;
import io.github.kjens93.edmunds.enums.State;
import io.github.kjens93.edmunds.enums.View;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kjensen on 11/23/16.
 */
public interface Params {

    static Map<String, Object> createParams(State state, String submodel, Category category, View view) {
        return new HashMap<String, Object>() {{
            put("state", state);
            put("submodel", submodel);
            put("category", category);
            put("view", view);
        }};
    }

    static Map<String, Object> createParams(State state, Integer year, View view) {
        return new HashMap<String, Object>() {{
            put("state", state);
            put("year", year);
            put("view", view);
        }};
    }

    static Map<String, Object> createParams(State state, Integer year, String submodel, Category category, View view) {
        return new HashMap<String, Object>() {{
            put("state", state);
            put("year", year);
            put("submodel", submodel);
            put("category", category);
            put("view", view);
        }};
    }

}
