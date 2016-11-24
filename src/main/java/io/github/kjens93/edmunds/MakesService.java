package io.github.kjens93.edmunds;

import java.util.List;

/**
 * Created by kjensen on 11/20/16.
 */
interface MakesService extends MakeService {

    Query findAllMakes();

    interface Query extends QueryCountableGettable<List<Make>> {
        Query state(State state);

        Query year(int year);

        Query view(View view);
    }

}
