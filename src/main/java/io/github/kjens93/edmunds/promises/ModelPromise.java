package io.github.kjens93.edmunds.promises;

import io.github.kjens93.edmunds.dto.Model;
import io.github.kjens93.edmunds.enums.Category;
import io.github.kjens93.edmunds.enums.State;
import io.github.kjens93.edmunds.enums.View;
import io.github.kjens93.promises.Promise;

/**
 * Created by kjensen on 11/29/16.
 */
public interface ModelPromise extends Promise<Model> {
    ModelPromise state(State state);

    ModelPromise year(int year);

    ModelPromise submodel(String submodel);

    ModelPromise category(Category category);

    ModelPromise view(View view);
}
