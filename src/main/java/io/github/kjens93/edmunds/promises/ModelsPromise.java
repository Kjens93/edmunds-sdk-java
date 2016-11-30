package io.github.kjens93.edmunds.promises;

import io.github.kjens93.edmunds.dto.Model;
import io.github.kjens93.edmunds.enums.Category;
import io.github.kjens93.edmunds.enums.State;
import io.github.kjens93.edmunds.enums.View;
import io.github.kjens93.promises.Promise;

import java.util.List;

/**
 * Created by kjensen on 11/29/16.
 */
public interface ModelsPromise extends CountablePromise, Promise<List<Model>> {
    ModelsPromise state(State state);

    ModelsPromise year(int year);

    ModelsPromise submodel(String submodel);

    ModelsPromise category(Category category);

    ModelsPromise view(View view);
}
