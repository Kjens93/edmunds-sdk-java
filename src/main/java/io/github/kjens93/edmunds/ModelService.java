package io.github.kjens93.edmunds;

/**
 * Created by kjensen on 11/23/16.
 */
interface ModelService {

    Query findModel(String makeNiceName, String modelNiceName);

    interface Query extends QueryGettable<Model> {
        Query state(State state);

        Query year(int year);

        Query submodel(String submodel);

        Query category(Category category);

        Query view(View view);
    }

}
