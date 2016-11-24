package io.github.kjens93.edmunds;

/**
 * Created by kjensen on 11/20/16.
 */
interface StyleService {

    Query findStyle(int id);

    interface Query extends QueryGettable<Style> {}

}
