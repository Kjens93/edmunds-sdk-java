package io.github.kjens93.edmunds;

import java.util.List;

/**
 * Created by kjensen on 11/20/16.
 */
interface StylesService extends StyleService {

    Query1 findStyles(String makeNiceName, String modelNiceName, int year);

    Query2 findStyles(String makeNiceName, String modelNiceName);

    Query2 findStyles(String makeNiceName);

    Query2 findStyles();

    interface Query1 extends QueryCountableGettable<List<Style>> {
        Query1 state(State state);

        Query1 submodel(String submodel);

        Query1 category(Category category);

        Query1 view(View view);
    }

    interface Query2 extends QueryCountable {
        Query2 state(State state);
    }

}
