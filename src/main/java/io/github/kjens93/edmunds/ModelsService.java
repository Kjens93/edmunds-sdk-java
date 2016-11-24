package io.github.kjens93.edmunds;

import java.util.List;

/**
 * Created by kjensen on 11/20/16.
 */
interface ModelsService extends ModelService {

    Query findAllModels(String makeNiceName);

    interface Query extends QueryCountableGettable<List<Model>> {
        Query state(State state);

        Query year(int year);

        Query submodel(String submodel);

        Query category(Category category);

        Query view(View view);
    }

}
