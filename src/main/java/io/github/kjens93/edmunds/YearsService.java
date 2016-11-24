package io.github.kjens93.edmunds;

import java.util.List;

/**
 * Created by kjensen on 11/20/16.
 */
interface YearsService extends YearService {

    Query findAllModelYears(String makeNiceName, String modelNiceName);

    interface Query extends QueryCountableGettable<List<Year>> {
        Query state(State state);

        Query submodel(String submodel);

        Query category(Category category);

        Query view(View view);
    }

}
