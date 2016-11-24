package io.github.kjens93.edmunds;

/**
 * Created by kjensen on 11/23/16.
 */
interface MakeService {

    Query findMake(String niceName);

    interface Query extends QueryGettable<Make> {
        Query state(State state);

        Query year(int year);

        Query view(View view);
    }

}
