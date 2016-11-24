package io.github.kjens93.edmunds;

/**
 * Created by kjensen on 11/23/16.
 */
interface YearService {

    Query findModelYear(String makeNiceName, String modelNiceName, int year);

    interface Query extends QueryGettable<Year> {
        Query state(State state);

        Query submodel(String submodel);

        Query category(Category category);

        Query view(View view);
    }

}
